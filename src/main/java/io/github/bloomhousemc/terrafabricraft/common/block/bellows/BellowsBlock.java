package io.github.bloomhousemc.terrafabricraft.common.block.bellows;

import io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.state.property.Properties.HORIZONTAL_FACING;

public class BellowsBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    private static final VoxelShape SHAPE = VoxelShapes.cuboid(2, 2, 2, 14, 14, 14);
    public BellowsBlock(Settings settings) {
        super(settings.nonOpaque());
        setDefaultState(getStateManager().getDefaultState().with(ON, false));
    }
    static int ticker = 0;
    public static BooleanProperty ON = BooleanProperty.of("on");


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
        builder.add(ON);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!state.get(ON)) {
            world.setBlockState(pos, state.with(ON, true));
            world.playSound(null, pos, SoundEvents.ENTITY_PUFFER_FISH_BLOW_OUT, SoundCategory.BLOCKS, 0.5F, 0.5F);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return !world.isClient ? BellowsBlock::tick : null;
    }

    private static <T extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, T t) {
        if(blockState.get(ON)){
            ticker ++;
            if(ticker >= 30){
                ticker=0;
                world.setBlockState(blockPos, blockState.with(ON, false));
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return TFCObjects.BELLOWS_BLOCK_ENTITY.instantiate(pos,state);
    }
}
