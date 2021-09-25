package malek.terrafabricraft.common.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import static malek.terrafabricraft.common.world.worldgen.Tree.*;

public class TFCStructures {
    public static void init() {
//        final TrunkPlacerType<AcaciaTrunkPlacer> ACACIA_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("acacia_trunk_placer", AcaciaTrunkPlacer.CODEC);
        RegistryKey<ConfiguredFeature<?, ?>> treeAcacia = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("terrafirmacraft", "tree_acacia"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeAcacia.getValue(), TREE_ACACIA);

        // You should use the VEGETAL_DECORATION generation step for trees
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, treeAcacia);
    }
}
