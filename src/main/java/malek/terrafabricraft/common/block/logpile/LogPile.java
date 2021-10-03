package malek.terrafabricraft.common.block.logpile;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class LogPile extends BlockWithEntity implements BlockEntityProvider, InventoryProvider {
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
    public LogPile(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(AXIS, Direction.Axis.Y));
    }
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return changeRotation(state, rotation);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
        switch(rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch((Direction.Axis)state.get(AXIS)) {
                    case X:
                        return (BlockState)state.with(AXIS, Direction.Axis.Z);
                    case Z:
                        return (BlockState)state.with(AXIS, Direction.Axis.X);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LogPileBlockEntity(pos, state);
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return LogPileBlockEntity::tick;
    }
    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return (SidedInventory) world.getBlockEntity(pos);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        return ActionResult.SUCCESS;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
