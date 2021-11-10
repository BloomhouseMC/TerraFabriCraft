package io.github.bloomhousemc.terrafabricraft.common.world.generator.feature;

import com.mojang.serialization.Codec;
import io.github.bloomhousemc.terrafabricraft.common.util.TFCUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BoulderFeature extends Feature<DefaultFeatureConfig> {
    public BoulderFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        var topPos = context.getWorld().getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
//        Direction offset = Direction.NORTH;
//
//        for (int y = 0; y < 15; y++) {
//            offset = offset.rotateYClockwise();
//            context.getWorld().setBlockState(topPos.up(y).offset(offset), Blocks.STONE.getDefaultState(), 3);
//        }


        var radius = MathHelper.nextInt(context.getRandom(), 1, 4);
        for (int x = 0; x < radius; x++)
            for (int y = 0; y < radius; y++)
                for (int z = 0; z < radius; z++) {
                    context.getWorld().setBlockState(topPos.add(x, y, z), TFCUtils.getRandomRawStone(context.getRandom()), 3);
                }
        return true;
    }
}
