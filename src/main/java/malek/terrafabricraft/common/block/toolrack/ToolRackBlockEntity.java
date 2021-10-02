package malek.terrafabricraft.common.block.toolrack;

import malek.terrafabricraft.common.block.keg.Keg;
import malek.terrafabricraft.common.block.keg.KegEntity;
import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.common.registry.TFCRecipeTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.LinkedHashMap;
import java.util.Map;

import static malek.terrafabricraft.common.block.keg.Keg.WORKING;

public class ToolRackBlockEntity extends BlockEntity implements BlockEntityClientSerializable, Inventory {
    @Environment(EnvType.CLIENT)
    public final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public ToolRackBlockEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.TOOL_RACK_BLOCK_ENTITY, pos, state);
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

    public void handle(ItemStack stack, PlayerEntity player, int itemSlot){
        if(!stack.isEmpty() && inventory.get(itemSlot).isEmpty()){
            inventory.set(itemSlot, stack.split(1));
        }else if(!inventory.get(itemSlot).isEmpty()){
            player.dropItem(inventory.get(itemSlot).copy(), false, true);
            inventory.set(itemSlot, new ItemStack(Items.AIR));
        }
    }

    public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
            System.out.println("State: " + state.get(Properties.HORIZONTAL_FACING));
            System.out.println("Side: " + hit.getSide());
            if(state.get(Properties.HORIZONTAL_FACING) == hit.getSide()){
                switch (hit.getSide()){
                    case NORTH:
                        if((hit.getPos().x - pos.getX()) < 0.5 && (hit.getPos().y - pos.getY()) > 0.5)
                            handle(stack, player, 0);
                        if((hit.getPos().x - pos.getX()) > 0.5 && (hit.getPos().y - pos.getY()) > 0.5)
                            handle(stack, player, 1);
                        if((hit.getPos().x - pos.getX()) < 0.5 && (hit.getPos().y - pos.getY()) < 0.5)
                            handle(stack, player, 2);
                        if((hit.getPos().x - pos.getX()) > 0.5 && (hit.getPos().y - pos.getY()) < 0.5)
                            handle(stack, player, 3);
                        break;
                    case SOUTH:
                        if((hit.getPos().x - pos.getX()) > 0.5 && (hit.getPos().y - pos.getY()) > 0.5)
                            handle(stack, player, 0);
                        if((hit.getPos().x - pos.getX()) < 0.5 && (hit.getPos().y - pos.getY()) > 0.5)
                            handle(stack, player, 1);
                        if((hit.getPos().x - pos.getX()) > 0.5 && (hit.getPos().y - pos.getY()) < 0.5)
                            handle(stack, player, 2);
                        if((hit.getPos().x - pos.getX()) < 0.5 && (hit.getPos().y - pos.getY()) < 0.5)
                            handle(stack, player, 3);
                         break;
                    case EAST:
                    case WEST:
                }
                this.sync();




            }
    }
}
