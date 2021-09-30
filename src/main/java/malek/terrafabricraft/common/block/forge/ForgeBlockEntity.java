package malek.terrafabricraft.common.block.forge;

import malek.terrafabricraft.common.ImplementedInventory;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ForgeBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory, SidedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public ForgeBlockEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.LOG_PILE_BLOCK_ENTITY, pos, state);
    }

    public static <T extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState state, T t) {
        ((ForgeBlockEntity)t).tick(world, blockPos, state);
    }
    private void tick(World world, BlockPos pos, BlockState state) {
       // System.out.println("hi");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new LogPileGuiDescription(syncId, inv, ScreenHandlerContext.create(world, pos));
    }
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    public Text getDisplayName() {
        return new LiteralText("Log Pile");
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

    @Override
    public int[] getAvailableSlots(Direction var1) {
        // Just return an array of all slots
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }


}
