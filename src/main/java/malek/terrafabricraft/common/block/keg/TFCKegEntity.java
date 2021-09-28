//package malek.terrafabricraft.common.block.keg;
//
//import malek.terrafabricraft.common.ImplementedInventory;
//import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
//import malek.terrafabricraft.common.registry.TFCObjects;
//import malek.terrafabricraft.common.registry.WoodBlock;
//import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.core.NonNullList;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TextComponent;
//import net.minecraft.world.ContainerHelper;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.WorldlyContainer;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.ContainerLevelAccess;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import org.jetbrains.annotations.Nullable;
//import software.bernie.geckolib3.core.IAnimatable;
//import software.bernie.geckolib3.core.PlayState;
//import software.bernie.geckolib3.core.builder.AnimationBuilder;
//import software.bernie.geckolib3.core.controller.AnimationController;
//import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
//import software.bernie.geckolib3.core.manager.AnimationData;
//import software.bernie.geckolib3.core.manager.AnimationFactory;
//
//public class TFCKegEntity extends BlockEntity implements ImplementedInventory, MenuProvider, WorldlyContainer, IAnimatable {
//    private final AnimationFactory manager = new AnimationFactory(this);
//    private final NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
//    private static final int[] TOP_SLOTS = new int[]{0};
//    private static final int[] BOTTOM_SLOTS = new int[]{1};
//    private static final int[] SIDE_SLOTS = new int[]{0, 1};
//    private int tankSize = 8000;
//    private int operationTime;
//    private int water = 0;
//    private int maxWater = getTankSize();
//    private int progress = 0;
//    private int maxProgress = getOperationTime();
//    private boolean on = false;
//
//
//    public TFCKegEntity(BlockPos pos, BlockState state) {
//        super(TFCObjects.KEG_BLOCK_ENTITY, pos, state);
//        operationTime = 180;
//        tankSize = 8000;
//        maxProgress = getOperationTime();
//        maxWater = getTankSize();
//    }
//
//
//
//    @Override
//    public NonNullList<ItemStack> getItems() {
//        return inventory;
//    }
//
//    @Override
//    public int[] getSlotsForFace(Direction side) {
//        if (side == Direction.UP) {
//            return TOP_SLOTS;
//        } else if (side == Direction.DOWN) {
//            return BOTTOM_SLOTS;
//        } else {
//            return SIDE_SLOTS;
//        }
//    }
//
//    @Override
//    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
//        return canPlaceItem(slot, stack);
//    }
//
//    @Override
//    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
//        return true;
//    }
//
//    @Override
//    public Component getDisplayName() {
//        String string = this.getBlockState().getBlock().getName().getString();
//        String i = string.substring(string.lastIndexOf(".")+1);
//
//
//
//        return new TextComponent(i);
//    }
//
//    @Nullable
//    @Override
//    public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
//        return new KegGuiDescription(syncId, inv, ContainerLevelAccess.create(level, worldPosition));
//    }
//
//    @Override
//    public void load(CompoundTag tag) {
//        super.load(tag);
//        clearContent();
//        ContainerHelper.loadAllItems(tag, this.inventory);
//    }
//    @Override
//    public CompoundTag save(CompoundTag tag) {
//        super.save(tag);
//        tag = super.save(tag);
//        ContainerHelper.saveAllItems(tag, this.inventory);
//        return tag;
//    }
//
//
//    public int getTankSize() {
//        return tankSize;
//    }
//
//    public int getOperationTime() {
//        return operationTime;
//    }
//
//    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//        AnimationController<?> controller = event.getController();
//        controller.transitionLengthTicks = 0;
//        controller.setAnimation(new AnimationBuilder().addAnimation("animation.keg.process", true));
//
//        return PlayState.CONTINUE;
//    }
//
//    @Override
//    public void registerControllers(AnimationData animationData) {
//        animationData.addAnimationController(new AnimationController<TFCKegEntity>(this, "controller", 0, this::predicate));
//    }
//
//    @Override
//    public AnimationFactory getFactory() {
//        return this.manager;
//    }
//
//}
