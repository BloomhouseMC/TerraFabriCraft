package malek.terrafabricraft.common.block.logpile;

import malek.terrafabricraft.common.ImplementedInventory;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class LogPileBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory, SidedInventory {
    public final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public LogPileBlockEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.LOG_PILE_BLOCK_ENTITY, pos, state);
    }

    public static <T extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState state,LogPileBlockEntity blockEntity, T t) {
        ((LogPileBlockEntity)t).tick(world, blockPos, state, blockEntity);
    }
    public int fireTicks = 0;
    public static void tick(World world, BlockPos pos, BlockState state, LogPileBlockEntity blockEntity) {
        if (!world.isClient) {
            if (blockEntity.inventory.get(0).getItem() == Items.AIR && blockEntity.inventory.get(1).getItem() == Items.AIR && blockEntity.inventory.get(2).getItem() == Items.AIR && blockEntity.inventory.get(3).getItem() == Items.AIR) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
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

    @Override
    public ItemStack removeStack(int slot, int count) {
        System.out.println("out");
        System.out.println(this.inventory.get(0).getItem());
        if(this.inventory.get(0).getItem() == Items.AIR && this.inventory.get(1).getItem() == Items.AIR && this.inventory.get(2).getItem() == Items.AIR && this.inventory.get(3).getItem() == Items.AIR){
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            System.out.println("in");
        }
        return ImplementedInventory.super.removeStack(slot, count);
    }

}
