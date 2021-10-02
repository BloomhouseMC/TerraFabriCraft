package malek.terrafabricraft.common.block.toolrack;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
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

public class ToolRackBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public ToolRackBlock(Settings settings) {
        super(settings.nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ToolRackBlockEntity(pos, state);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx){
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }
    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = blockState.get(Properties.HORIZONTAL_FACING);
        return switch (dir) {
            case SOUTH -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.2f);
            case NORTH -> VoxelShapes.cuboid(0.0f, 0.0f, 0.8f, 1.0f, 1.0f, 1.0f);
            case WEST -> VoxelShapes.cuboid(0.8f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            case EAST -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 0.2f, 1.0f, 1.0f);
            default -> VoxelShapes.fullCube();
        };
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean client = world.isClient;
        if (!client) {
            ((ToolRackBlockEntity) world.getBlockEntity(pos)).onUse(state, world, pos, player, hand, hit);
        }
        return ActionResult.success(client);
    }
    //BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit
    /*
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Inventory blockEntityInventory = (Inventory) world.getBlockEntity(pos);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(!world.isClient && blockEntityInventory instanceof ToolRackBlockEntity toolRackBlockEntity){
            System.out.println("State: "+state.get(Properties.HORIZONTAL_FACING));
            System.out.println("Side: "+hit.getSide());
            if(state.get(Properties.HORIZONTAL_FACING) == Direction.NORTH && hit.getSide() == Direction.NORTH){
                if((hit.getPos().x - pos.getX()) < 0.5 && (hit.getPos().y - pos.getY()) > 0.5){
                        if(toolRackBlockEntity.getStack(0).isEmpty()){
                            ItemStack stack = player.getStackInHand(hand);
                            if(stack.isEmpty()) return ActionResult.FAIL;
                            toolRackBlockEntity.setStack(0, stack.split(1));
                            toolRackBlockEntity.markDirty();
                            return ActionResult.SUCCESS;
                        }else{
                            ItemStack itemStack = toolRackBlockEntity.getStack(0);
                            System.out.println(itemStack);
                            player.setStackInHand(hand, itemStack.copy());
                            toolRackBlockEntity.removeStack(0);
                            return ActionResult.SUCCESS;
                        }
                }
            }
        }
        return ActionResult.PASS;
    }

     */
}
