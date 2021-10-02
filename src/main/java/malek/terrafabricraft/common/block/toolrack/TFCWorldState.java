package malek.terrafabricraft.common.block.toolrack;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;

import java.util.LinkedHashMap;
import java.util.Map;

public class TFCWorldState extends PersistentState {
    public final Map<Long, DefaultedList<ItemStack>> toolRackList = new LinkedHashMap<>();


    public static TFCWorldState readNbt(NbtCompound nbt) {
        TFCWorldState worldState = new TFCWorldState();
        NbtList toolRackList = nbt.getList("ToolRack", NbtType.COMPOUND);
        for (int i = 0; i < toolRackList.size(); i++) {
            NbtCompound toolRackCompound = toolRackList.getCompound(i);
            DefaultedList<ItemStack> inventory = null;
            if (toolRackCompound.contains("Inventory")) {
                inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
                Inventories.readNbt(toolRackCompound.getCompound("Inventory"), inventory);
            }
            worldState.toolRackList.put(toolRackCompound.getLong("Pos"), inventory);
        }
        return worldState;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        NbtList toolRackList = new NbtList();
        this.toolRackList.forEach((pos, inventory) -> {
            NbtCompound toolRackCompound = new NbtCompound();
            toolRackCompound.putLong("Pos", pos);
            if (inventory != null) {
                toolRackCompound.put("Inventory", Inventories.writeNbt(new NbtCompound(), inventory));
            }
            toolRackList.add(toolRackCompound);
        });
        nbt.put("ToolRack", toolRackList);
        return nbt;
    }

    public static TFCWorldState get(World world) {
        return ((ServerWorld) world).getPersistentStateManager().getOrCreate(TFCWorldState::readNbt, TFCWorldState::new, TerraFabriCraft.MODID + "_universal");
    }
}
