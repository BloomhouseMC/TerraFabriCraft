package malek.terrafabricraft.common.block.placeable;

import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static malek.terrafabricraft.common.util.HelperUtil.handleGUILessInventory;

public class PlaceableBlockEntity extends BlockEntity implements BlockEntityClientSerializable, Inventory {

    public final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public PlaceableBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public PlaceableBlockEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.PLACEABLE_BLOCK_ENTITY, pos, state);
    }



    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        for(int i = 0; i < inventory.size(); i++){
            NbtCompound nbtCompound = nbt.getCompound("Item_"+i);
            if (nbtCompound != null && !nbtCompound.isEmpty()) {
                ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
                this.setStack(i, itemStack);
            }
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.put("Item_0", this.getStack(0).writeNbt(new NbtCompound()));
        nbt.put("Item_1", this.getStack(1).writeNbt(new NbtCompound()));
        nbt.put("Item_2", this.getStack(2).writeNbt(new NbtCompound()));
        nbt.put("Item_3", this.getStack(3).writeNbt(new NbtCompound()));
        return super.writeNbt(nbt);
    }

    @Override
    public void fromClientTag(NbtCompound nbt){
        for(int i = 0; i < inventory.size(); i++){
            NbtCompound nbtCompound = nbt.getCompound("Item_"+i);
            if (nbtCompound != null && !nbtCompound.isEmpty()) {
                ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
                this.setStack(i, itemStack);
                this.markDirty();
            }
        }
    }

    @Override
    public NbtCompound toClientTag(NbtCompound nbt){
        nbt.put("Item_0", this.getStack(0).writeNbt(new NbtCompound()));
        nbt.put("Item_1", this.getStack(1).writeNbt(new NbtCompound()));
        nbt.put("Item_2", this.getStack(2).writeNbt(new NbtCompound()));
        nbt.put("Item_3", this.getStack(3).writeNbt(new NbtCompound()));
        return nbt;
    }
    public static void tick(World world, BlockPos pos, BlockState state, PlaceableBlockEntity blockEntity) {
        if(!world.isClient){
            if(blockEntity.inventory.get(0).getItem() == Items.AIR && blockEntity.inventory.get(1).getItem() == Items.AIR && blockEntity.inventory.get(2).getItem() == Items.AIR && blockEntity.inventory.get(3).getItem() == Items.AIR){
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            if (getStack(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        inventory.set(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }


    public void clear() {
        inventory.clear();
    }

    public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient){
            ItemStack stack = player.getStackInHand(hand);
            double normalX = (hit.getPos().x - pos.getX());
            double normalZ = (hit.getPos().z - pos.getZ());
            if (normalX < 0.5 && normalZ > 0.5) {
                handleGUILessInventory(stack, player, hand, inventory, 2);}
            else if (normalX > 0.5 && normalZ > 0.5) {
                handleGUILessInventory(stack, player, hand, inventory, 3);}
            else if (normalX < 0.5 && normalZ < 0.5) {
                handleGUILessInventory(stack, player, hand, inventory, 0);}
            else if (normalX > 0.5 && normalZ < 0.5) {
                handleGUILessInventory(stack, player, hand, inventory, 1);}
            this.sync();
        }
    }
}