package malek.terrafabricraft.common.world.generator.feature;

//import I;
import com.mojang.serialization.Codec;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import java.util.Random;

public class BoulderFeature extends Feature<NoneFeatureConfiguration> {
    public BoulderFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        var topPos = context.level().getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, context.origin());
//        Direction offset = Direction.NORTH;
//
//        for (int y = 0; y < 15; y++) {
//            offset = offset.rotateYClockwise();
//            context.getWorld().setBlockState(topPos.up(y).offset(offset), Blocks.STONE.getDefaultState(), 3);
//        }


        var radius = Mth.nextInt(context.random(), 1, 4);
        for (int x = 0; x < radius; x++)
            for (int y = 0; y < radius; y++)
                for (int z = 0; z < radius; z++) {
                    context.level().setBlock(topPos.offset(x, y, z), TFCObjects.ANDESITE.raw.block.defaultBlockState(), 3);
                }
        return true;
    }
}
