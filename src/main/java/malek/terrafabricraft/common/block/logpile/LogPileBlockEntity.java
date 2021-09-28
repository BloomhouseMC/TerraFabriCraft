package malek.terrafabricraft.common.block.logpile;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import malek.terrafabricraft.common.ImplementedInventory;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LogPileBlockEntity extends BlockEntity implements ImplementedInventory, MenuProvider, WorldlyContainer {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    public LogPileBlockEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.LOG_PILE_BLOCK_ENTITY, pos, state);
    }

    public static <T extends BlockEntity> void tick(Level world, BlockPos blockPos, BlockState state, T t) {
        ((LogPileBlockEntity)t).tick(world, blockPos, state);
    }
    private void tick(Level world, BlockPos pos, BlockState state) {
       // System.out.println("hi");
    }
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
        return new LogPileGuiDescription(syncId, inv, ContainerLevelAccess.create(level, worldPosition));
    }
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    public Component getDisplayName() {
        return new TextComponent("Log Pile");
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        clearContent();
        ContainerHelper.loadAllItems(tag, this.inventory);
    }
    @Override
    public CompoundTag save(CompoundTag tag) {
        super.save(tag);
        tag = super.save(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
        return tag;
    }

    @Override
    public int[] getSlotsForFace(Direction var1) {
        // Just return an array of all slots
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return true;
    }


}
