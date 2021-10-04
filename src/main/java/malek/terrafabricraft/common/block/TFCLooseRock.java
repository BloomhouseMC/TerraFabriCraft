package malek.terrafabricraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class TFCLooseRock extends GroundCoverBlock implements Waterloggable {
    public static final IntProperty COUNT = IntProperty.of("count", 1, 3);
    public TFCLooseRock(Settings settings) {
        super(settings.nonOpaque().breakInstantly());
        this.setDefaultState((BlockState)this.getDefaultState().with(COUNT, 1));
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient()) {
            return ActionResult.PASS;
        }
        if(player.isSneaking()) {
            return ActionResult.PASS;
        }
        if (dropItem == null) {
            dropItem = this.asItem();
            spawnDebris(world, pos);
            world.breakBlock(pos, true);
        } else {
            spawnDebris(world, pos);
            world.breakBlock(pos, false);
        }
        return ActionResult.PASS;
    }

    private void spawnDebris(World world, BlockPos pos) {
        //System.out.println(world.getBlockState(pos));
        if(world.getBlockState(pos).getBlock() instanceof TFCLooseRock) {
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropItem, world.getBlockState(pos).get(COUNT))));
        }
        else {
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropItem)));
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int count = state.get(COUNT);
        return switch (count) {
            case 1 -> Block.createCuboidShape(4, 0, 4, 11, 2, 11);
            case 2 -> Block.createCuboidShape(1, 0, 1, 15, 2, 15);
            case 3 -> Block.createCuboidShape(4, 0, 4, 12, 4, 12);
            default -> Block.createCuboidShape(1, 0, 1, 15, 2, 15);
        };
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COUNT);
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isClient) {
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropItem, world.getBlockState(pos).get(COUNT))));
        }
        super.onBreak(world, pos, state, player);
    }

}