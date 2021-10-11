package malek.terrafabricraft.common.world.generator.feature;

import com.mojang.serialization.Codec;
import malek.terrafabricraft.common.block.TFCLooseRock;
import malek.terrafabricraft.common.registry.RockBlock;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
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
        if(random.nextInt(config.targets.get(0).state.getBlock().hashCode()) % 16 == 0 ) {
            //This is for special rock;
            BlockState state = config.targets.get(0).state;
            BlockState secondState = state;
            BlockState looseState = RockBlock.stateToRock.get(state).loose.getDefaultState();
            RockBlock rockBlock = RockBlock.stateToRock.get(state);
            if(random.nextFloat() < 0.2) {
                secondState = rockBlock.oreStones.get(random.nextInt(rockBlock.oreStones.size())).getDefaultState();
                //TODO : MAKE IT SO THAT ORE STONES THAT HAVE SPEICAL PLACABLE LIKE LOOSE ROCK VARIANTS ACTUALLY HAVE THEM IN THEIR CLASSES YA DOFUS.
            }
                for (int x = 0; x < random.nextInt(50); x++) {
                    for (int z = 0; z < random.nextInt(50); z++) {
                        if(random.nextFloat() < 0.03) {
                            BlockPos myPos = new BlockPos(pos.getX() +x, topPos.getY()+2, pos.getZ()+z);
                            while(world.getBlockState(myPos).isAir()) {
                                myPos = myPos.down();
                            }
                            myPos = myPos.up();
                            if(world.getBlockState(myPos.down()).getBlock() == Blocks.GRASS
                                    || world.getBlockState(myPos.down()).getBlock() == Blocks.TALL_GRASS
                                    || world.getBlockState(myPos.down()).getBlock() == Blocks.WATER
                                    || world.getBlockState(myPos.down()).getBlock() instanceof TFCLooseRock
                                    || world.getBlockState(myPos.down()).getBlock() instanceof LeavesBlock) {

                            } else {
                                world.setBlockState(myPos, looseState.with(TFCLooseRock.COUNT, random.nextInt(3) + 1), 2);
                            }
                        }
                        for (int y = world.getBottomY(); y < topPos.getY(); y++) {
                        BlockPos pos1 = new BlockPos(pos.getX() + x, y, pos.getZ() + z);
                        if (world.getBlockState(pos1).getBlock() == Blocks.STONE) {
                            if(random.nextFloat() < 0.35) {
                                world.setBlockState(pos1, secondState, 2);
                            }
                            else {
                                world.setBlockState(pos1, state, 2);
                            }
                        }
                    }
                }
            }

        }
        return true;
    }
}
