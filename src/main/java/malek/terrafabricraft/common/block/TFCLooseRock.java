package malek.terrafabricraft.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class TFCLooseRock extends GroundCoverBlock {
    public static final IntegerProperty COUNT = IntegerProperty.create("count", 1, 3);
    public TFCLooseRock(Properties settings) {
        super(settings.noOcclusion().instabreak());
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(COUNT, 1));
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if(world.isClientSide()) {
            return InteractionResult.PASS;
        }
        if(player.isShiftKeyDown()) {
            return InteractionResult.PASS;
        }
        if (dropItem == null) {
            dropItem = this.asItem();
            spawnDebris(world, pos);
            world.destroyBlock(pos, true);
        } else {
            spawnDebris(world, pos);
            world.destroyBlock(pos, false);
        }
        return InteractionResult.PASS;
    }

    private void spawnDebris(Level world, BlockPos pos) {
        System.out.println(world.getBlockState(pos));
        if(world.getBlockState(pos).getBlock() instanceof TFCLooseRock) {
            world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropItem, world.getBlockState(pos).getValue(COUNT))));
        }
        else {
            world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropItem)));
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        int count = state.getValue(COUNT);
        return switch (count) {
            case 1 -> Block.box(4, 0, 4, 11, 2, 11);
            case 2 -> Block.box(1, 0, 1, 15, 2, 15);
            case 3 -> Block.box(4, 0, 4, 12, 4, 12);
            default -> Block.box(1, 0, 1, 15, 2, 15);
        };
    }
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COUNT);
    }
    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if(!world.isClientSide) {
            world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropItem, world.getBlockState(pos).getValue(COUNT))));
        }
        super.playerWillDestroy(world, pos, state, player);
    }

}
