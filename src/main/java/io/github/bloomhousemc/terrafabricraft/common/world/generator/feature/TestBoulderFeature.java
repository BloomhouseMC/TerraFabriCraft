package io.github.bloomhousemc.terrafabricraft.common.world.generator.feature;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import io.github.bloomhousemc.terrafabricraft.common.util.TFCUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.List;
import java.util.Random;

public class TestBoulderFeature extends Feature<SingleStateFeatureConfig> {

    public TestBoulderFeature(Codec<SingleStateFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<SingleStateFeatureConfig> context) {
        BlockPos blockPos = context.getOrigin();
        World world = context.getWorld().toServerWorld();
        Random random = context.getRandom();
        for(; blockPos.getY() > 3; blockPos = blockPos.down())
        {
            if(!world.isAir(blockPos.down()))
            {
                Block block = world.getBlockState(blockPos.down()).getBlock();
                if(isSoil(block.getDefaultState()) || isStone(block.getDefaultState()))
                {
                    break;
                }
            }
        }

        if(blockPos.getY() <= 3)
        {
            return false;
        }
        else
        {
            List<BlockPos> rockPositions = Lists.newArrayList();
            for(int i = 0; i < 4; ++i)
            {
                int xSize = random.nextInt(3);
                int ySize = random.nextInt(4);
                int zSize = random.nextInt(3);
                float distance = (float) (xSize + ySize + zSize) * 0.333F + 0.5F;

                for(BlockPos genPos : BlockPos.iterate(blockPos.add(-xSize, -ySize, -zSize), blockPos.add(xSize, ySize, zSize)))
                {
                    if(genPos.getSquaredDistance(blockPos) <= (double) (distance * distance))
                    {
                        BlockPos placePos = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, genPos);
                        BlockState downState = world.getBlockState(placePos.down());
                        while(downState.getMaterial().isReplaceable() || downState.isIn(BlockTags.LOGS) || downState.isIn(BlockTags.LEAVES))
                        {
                            placePos = placePos.down();
                            downState = world.getBlockState(placePos.down());
                        }
                        if(!(downState.isOf(TFCObjects.CONGLOMERATE.raw.block) || isSoil(downState.getBlock().getDefaultState()) || isStone(downState.getBlock().getDefaultState()) || downState.getBlock() == Blocks.GRAVEL))
                            continue;

                        world.setBlockState(placePos, context.getConfig().state, 4);
                        rockPositions.add(placePos);
                    }
                }
                blockPos = blockPos.add(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
            }
            for(BlockPos placePositions : rockPositions)
            {
                if(random.nextInt(10) == 0)
                {
                    for(Direction direction : Direction.values())
                    {
                        BlockPos offsetPos = placePositions.offset(direction);
                        if(world.isAir(offsetPos) && random.nextBoolean())
                        {
                            world.setBlockState(offsetPos, TFCUtils.getRandomRawStone(random), 16);
                        }
                    }
                }
            }

            return true;
        }
    }
}
