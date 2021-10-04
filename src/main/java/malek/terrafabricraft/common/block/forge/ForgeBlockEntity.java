package malek.terrafabricraft.common.block.forge;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import malek.terrafabricraft.common.ImplementedInventory;
import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.common.temperature.ItemTemperature;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
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

public class ForgeBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory, SidedInventory, PropertyDelegateHolder {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(14, ItemStack.EMPTY);
    int temperature = 0;
    final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return temperature;
        }

        @Override
        public void set(int index, int value) {
                temperature = value;
        }

        @Override
        public int size() {
            return 1;
        }
    };
    public ForgeBlockEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.FORGE_BLOCK_ENTITY, pos, state);
    }

    public static <T extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState state, T t) {
        ((ForgeBlockEntity)t).tick(world, blockPos, state);
    }
    int ticks = 0;
    private void tick(World world, BlockPos pos, BlockState state) {
       // System.out.println("hi");
        if(world.isClient) {
            return;
        }
        ticks++;


        temperature++;
        if(temperature > 190) {
            temperature = 0;
        }
        propertyDelegate.set(0, temperature);
        if(ticks%1 == 0) {
            for (ItemStack item : getItems()) {
                ItemTemperature.incrementTemperature(item);
                ItemTemperature.incrementTemperature(item);
                ItemTemperature.incrementTemperature(item);
                ItemTemperature.incrementTemperature(item);
            }
        }
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ForgeGuiDescription(syncId, inv, ScreenHandlerContext.create(world, pos));
    }
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    public Text getDisplayName() {
        return new LiteralText("Forge");
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
    public PropertyDelegate getPropertyDelegate() {
        return propertyDelegate;
    }
}
