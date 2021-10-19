package malek.terrafabricraft.common.block.placeable;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
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

public class PlaceableBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public static IntProperty STAGE = IntProperty.of("stage", 0, 16);
    public PlaceableBlock(Settings settings) {
        super(settings.nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(STAGE, 0));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlaceableBlockEntity(pos, state);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
        builder.add(STAGE);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx){
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }
    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        if(blockState.get(STAGE) == 0) {
            return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 0.01f, 1.0f);
        }
        int stage = blockState.get(STAGE);
        if(stage == 16) {
            return VoxelShapes.fullCube();
        }
        return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f*stage, 1.0f);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (tickerWorld, pos, tickerState, blockEntity) -> PlaceableBlockEntity.tick(tickerWorld, pos, tickerState, (PlaceableBlockEntity) blockEntity);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        if(state.get(STAGE) == 0) {
            return BlockRenderType.INVISIBLE;
        }
        return BlockRenderType.MODEL;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ((PlaceableBlockEntity) world.getBlockEntity(pos)).onUse(state, world, pos, player, hand, hit);
        }
        return ActionResult.PASS;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        PlaceableBlockEntity blockEntity = (PlaceableBlockEntity) world.getBlockEntity(pos);
        for(int i = 0; i < 4; i++){
            dropStack(world, pos, blockEntity.inventory.get(i));
            blockEntity.inventory.set(i, ItemStack.EMPTY);
        }
    }


}
