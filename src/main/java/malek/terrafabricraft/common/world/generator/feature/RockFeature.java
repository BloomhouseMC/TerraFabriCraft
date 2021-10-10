package malek.terrafabricraft.common.world.generator.feature;

import com.mojang.serialization.Codec;
import malek.terrafabricraft.common.block.TFCLooseRock;
import malek.terrafabricraft.common.registry.RockBlock;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

import static java.lang.Math.min;

public class RockFeature extends Feature<OreFeatureConfig> {
    public RockFeature(Codec<OreFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(FeatureContext<OreFeatureConfig> context) {
       return generate(context.getWorld(), context.getGenerator(), context.getRandom(), context.getOrigin(), context.getConfig());
    }


    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos,
                            OreFeatureConfig config) {

        BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE_WG, pos);
        BlockPos tempPos = new BlockPos(topPos.getX(), 0, topPos.getZ());
        /*
        if(random.nextBoolean()) {
            int ourY = random.nextInt(255);
            for (int y = ourY; y <= min(255, ourY + random.nextInt(7)); y++) {
                for (int x = 0; x < random.nextInt(50); x++) {
                    for (int z = 0; z < random.nextInt(50); z++) {

                        BlockPos positionRep = tempPos.add(x, y, z);
                        world.setBlockState(positionRep, getBlockState(random, positionRep, world), 2);



                    }
                }
            }
        }

         */
        if(random.nextInt(config.targets.get(0).state.getBlock().hashCode()) % 16 == 0 ) {
            BlockState looseState = RockBlock.rockToDebris.get(config.targets.get(0).state);
                for (int x = 0; x < random.nextInt(50); x++) {
                    for (int z = 0; z < random.nextInt(50); z++) {
                        if(random.nextFloat() < 0.1) {
                            BlockPos myPos = new BlockPos(pos.getX() +x, topPos.getY()+2, pos.getZ()+z);
                            while(world.getBlockState(myPos).isAir()) {
                                myPos = myPos.down();
                            }
                            myPos = myPos.up();
                            if(world.getBlockState(myPos.down()).getBlock() == Blocks.GRASS
                                    || world.getBlockState(myPos.down()).getBlock() == Blocks.TALL_GRASS
                                    || world.getBlockState(myPos.down()).getBlock() == Blocks.WATER
                                    || world.getBlockState(myPos.down()).getBlock() instanceof TFCLooseRock) {

                            } else {
                                world.setBlockState(myPos, looseState.with(TFCLooseRock.COUNT, random.nextInt(3) + 1), 2);
                            }
                        }
                        for (int y = world.getBottomY(); y < topPos.getY(); y++) {
                        BlockPos pos1 = new BlockPos(pos.getX() + x, y, pos.getZ() + z);
                        if (world.getBlockState(pos1).getBlock() == Blocks.STONE) {
                            world.setBlockState(pos1, config.targets.get(0).state, 2);
                        }
                    }
                }
            }

        }
        return true;
    }
    public BlockState getBlockState(Random random, BlockPos pos, StructureWorldAccess world) {
        return TFCObjects.CHERT.raw.block.getDefaultState();
    }
}
