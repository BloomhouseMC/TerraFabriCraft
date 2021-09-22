package malek.terrafabricraft;

import malek.terrafabricraft.common.registry.TFCComponents;
import malek.terrafabricraft.common.registry.TFCEntityTypes;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class TerraFabriCraft implements ModInitializer {

	public static final String MODID = "terrafabricraft";
	public static final ItemGroup TERRAFABRICRAFT_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.ROCK_BLOCK));

	@Override
	public void onInitialize() {
		TFCObjects.init();
		TFCEntityTypes.init();
	}
}
