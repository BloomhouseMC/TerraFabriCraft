package malek.terrafabricraft.common.world.worldgen;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class AcaciaTrunkPlacer extends TrunkPlacer {
    // Use the fillTrunkPlacerFields to create our codec
    public static final Codec<AcaciaTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).apply(instance, AcaciaTrunkPlacer::new));

    public AcaciaTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return Tree.ACACIA_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        this.setToDirt(world, replacer, random, startPos.down(), config);

        for (int i = 0; i < height; i++) {
            this.getAndSetState(world, replacer, random, startPos.up(i), config);
            this.getAndSetState(world, replacer, random, startPos.up(i).east().north(), config);
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, false),
                new FoliagePlacer.TreeNode(startPos.east().north().up(height), 0, false));
    }
}