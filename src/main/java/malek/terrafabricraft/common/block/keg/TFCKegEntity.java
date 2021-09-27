package malek.terrafabricraft.common.block.keg;

import malek.terrafabricraft.common.ImplementedInventory;
import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.common.registry.WoodBlock;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
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
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class TFCKegEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory, SidedInventory {
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


    public TFCKegEntity(WoodBlock wood, BlockPos pos, BlockState state) {
        super(wood, pos, state);
        operationTime = 180;
        tankSize = 8000;
        maxProgress = getOperationTime();
        maxWater = getTankSize();
    }



    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
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
        return null;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return null;
    }


    public int getTankSize() {
        return tankSize;
    }

    public int getOperationTime() {
        return operationTime;
    }

}
