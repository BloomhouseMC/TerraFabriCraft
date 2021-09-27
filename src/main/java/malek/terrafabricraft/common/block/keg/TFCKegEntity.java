package malek.terrafabricraft.common.block.keg;

import malek.terrafabricraft.common.ImplementedInventory;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.common.registry.WoodBlock;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TFCKegEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory, SidedInventory, IAnimatable {
    private final AnimationFactory manager = new AnimationFactory(this);
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{1};
    private static final int[] SIDE_SLOTS = new int[]{0, 1};
    private int tankSize = 8000;
    private int operationTime;
    private int water = 0;
    private int maxWater = getTankSize();
    private int progress = 0;
    private int maxProgress = getOperationTime();
    private boolean on = false;


    public TFCKegEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.KEG_BLOCK_ENTITY, pos, state);
        operationTime = 180;
        tankSize = 8000;
        maxProgress = getOperationTime();
        maxWater = getTankSize();
    }



    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.UP) {
            return TOP_SLOTS;
        } else if (side == Direction.DOWN) {
            return BOTTOM_SLOTS;
        } else {
            return SIDE_SLOTS;
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction dir) {
        return isValid(slot, stack);
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    @Override
    public Text getDisplayName() {
        String string = this.getCachedState().getBlock().getName().getString();
        String i = string.substring(string.lastIndexOf(".")+1);



        return new LiteralText(i);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new KegGuiDescription(syncId, inv, ScreenHandlerContext.create(world, pos));
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        clear();
        Inventories.readNbt(tag, this.inventory);
    }
    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag = super.writeNbt(tag);
        Inventories.writeNbt(tag, this.inventory);
        return tag;
    }


    public int getTankSize() {
        return tankSize;
    }

    public int getOperationTime() {
        return operationTime;
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController<?> controller = event.getController();
        controller.transitionLengthTicks = 0;
        controller.setAnimation(new AnimationBuilder().addAnimation("animation.keg.process", true));

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<TFCKegEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.manager;
    }

}
