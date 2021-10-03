package malek.terrafabricraft.common.block.keg;

import malek.terrafabricraft.common.recipes.BeerBrewingRecipe;
import malek.terrafabricraft.common.recipes.HardBrewingRecipe;
import malek.terrafabricraft.common.recipes.LightBrewingRecipe;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static malek.terrafabricraft.common.util.TFCUtils.addItemToInventoryAndConsume;

public class Keg extends BlockWithEntity {
    public static final IntProperty LEVEL = IntProperty.of("level", 0, 3);
    private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape[] SHAPE = {
            VoxelShapes.union(
                createCuboidShape(2, 0, 2, 14, 16, 3),
                createCuboidShape(2, 0, 13, 14, 16, 14),
                createCuboidShape(2, 0, 2, 3, 16, 14),
                createCuboidShape(13, 0, 2, 14, 16, 14),
                createCuboidShape(2, 0, 2, 14, 4, 14)),
            VoxelShapes.union(
                createCuboidShape(2, 0, 2, 14, 16, 3),
                createCuboidShape(2, 0, 13, 14, 16, 14),
                createCuboidShape(2, 0, 2, 3, 16, 14),
                createCuboidShape(13, 0, 2, 14, 16, 14),
                createCuboidShape(2, 0, 2, 14, 4, 14),
                createCuboidShape(2, 14, 2, 14, 16, 14))};
    public static BooleanProperty WORKING = BooleanProperty.of("working");

    public Keg(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(LEVEL, 0).with(WORKING, false));

    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (tickerWorld, pos, tickerState, blockEntity) -> KegEntity.tick(tickerWorld, pos, tickerState, (KegEntity) blockEntity);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(WORKING) ? SHAPE[1] : SHAPE[0];
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LEVEL, WORKING);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new KegEntity(pos, state);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());

    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof KegEntity tfcKegEntity) {
            Boolean isWorking = world.getBlockState(pos).get(Keg.WORKING);
            ItemStack stack = player.getStackInHand(hand);
                boolean bucket = stack.getItem() == Items.BUCKET, waterBucket = stack.getItem() == Items.WATER_BUCKET, glassBottle = stack.getItem() == Items.GLASS_BOTTLE;
            if ((bucket || waterBucket || glassBottle) && !isWorking) {
                if (!world.isClient) {
                        int targetLevel = tfcKegEntity.getTargetLevel(stack);
                        if (targetLevel > -1) {
                            if (bucket) {
                                addItemToInventoryAndConsume(player, hand, new ItemStack(Items.WATER_BUCKET));
                            }
                            else if (waterBucket) {
                                addItemToInventoryAndConsume(player, hand, new ItemStack(Items.BUCKET));
                            }
                            else if (glassBottle) {
                                ItemStack bottle = null;
                                if (tfcKegEntity.mode == KegEntity.Mode.NORMAL) {
                                    bottle = PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER);
                                }
                                else if (tfcKegEntity.mode == KegEntity.Mode.BEER_BREWING) {
                                    BeerBrewingRecipe beerBrewingRecipe = tfcKegEntity.beerRecipe;
                                    if (beerBrewingRecipe != null) {
                                        bottle = beerBrewingRecipe.getOutput().copy();
                                    }
                                }
                                else if (tfcKegEntity.mode == KegEntity.Mode.HARD_BREWING) {
                                    HardBrewingRecipe hardBrewingRecipe = tfcKegEntity.hardRecipe;
                                    if (hardBrewingRecipe != null) {
                                        bottle = hardBrewingRecipe.getOutput().copy();
                                    }
                                }
                                else if (tfcKegEntity.mode == KegEntity.Mode.LIGHT_BREWING) {
                                    LightBrewingRecipe lightBrewingRecipe = tfcKegEntity.lightRecipe;
                                    if (lightBrewingRecipe != null) {
                                        bottle = lightBrewingRecipe.getOutput().copy();
                                    }
                                }
                                else {
                                    if (targetLevel == 2) {
                                        boolean failed = true;
                                        if (failed) {
                                            tfcKegEntity.mode = tfcKegEntity.fail();
                                            tfcKegEntity.syncKeg();
                                            return ActionResult.FAIL;
                                        }
                                    }
                                }
                                if (bottle != null) {
                                    addItemToInventoryAndConsume(player, hand, bottle);
                                }
                            }
                            if (targetLevel == 0) {
                                tfcKegEntity.mode = tfcKegEntity.reset();
                            }
                            world.setBlockState(pos, state.with(LEVEL, targetLevel));
                            world.playSound(null, pos, bucket ? SoundEvents.ITEM_BUCKET_FILL : waterBucket ? SoundEvents.ITEM_BUCKET_EMPTY : glassBottle ? SoundEvents.ITEM_BOTTLE_FILL : SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1, 1);
                        }

                    tfcKegEntity.syncKeg();
                }
            }
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(LEVEL);
    }
}
