//package malek.terrafabricraft.common.block.keg;
//
//import malek.terrafabricraft.common.registry.TFCObjects;
//import net.minecraft.block.*;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.WorldlyContainer;
//import net.minecraft.world.WorldlyContainerHolder;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.context.BlockPlaceContext;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.level.block.BaseEntityBlock;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.HorizontalDirectionalBlock;
//import net.minecraft.world.level.block.RenderShape;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.DirectionProperty;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import org.jetbrains.annotations.Nullable;
//import software.bernie.geckolib3.core.IAnimatable;
//import software.bernie.geckolib3.core.PlayState;
//import software.bernie.geckolib3.core.builder.AnimationBuilder;
//import software.bernie.geckolib3.core.controller.AnimationController;
//import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
//import software.bernie.geckolib3.core.manager.AnimationData;
//import software.bernie.geckolib3.core.manager.AnimationFactory;
//
//public class TFCKeg extends BaseEntityBlock implements WorldlyContainerHolder {
//    /*
//    private static final VoxelShape EAST_SHAPE;
//    private static final VoxelShape WEST_SHAPE;
//    private static final VoxelShape SOUTH_SHAPE;
//    private static final VoxelShape NORTH_SHAPE;
//
//     */
//    private static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
//
//    public TFCKeg(Properties settings) {
//        super(settings);
//        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
//
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
//        return Block.box(2, 0, 2, 14, 16, 14);
//    }
//
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(FACING);
//    }
//
//    @Nullable
//    @Override
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return new TFCKegEntity(pos, state);
//    }
///*
//    static {
//        VoxelShape shape = createCuboidShape(0, 0, 0, 16, 16, 16);
//
//        EAST_SHAPE = shape;
//        NORTH_SHAPE = rotate(Direction.EAST, Direction.NORTH, shape);
//        SOUTH_SHAPE = rotate(Direction.EAST, Direction.SOUTH, shape);
//        WEST_SHAPE = rotate(Direction.EAST, Direction.WEST, shape);
//
//    }
//
// */
//    /*
//    private static VoxelShape rotate(Direction from, Direction to, VoxelShape shape) {
//        VoxelShape[] buffer = new VoxelShape[]{shape, VoxelShapes.empty()};
//
//        int times = (to.getHorizontal() - from.getHorizontal() + 4) % 4;
//        for (int i = 0; i < times; i++) {
//            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(maxZ, minY, minX, minZ, maxY, maxX)));
//            buffer[0] = buffer[1];
//            buffer[1] = VoxelShapes.empty();
//        }
//
//        return buffer[0];
//    }
//
//     */
//    @Override
//    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
//        return (BlockState)this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
//    }
//
//    @Override
//    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
//        player.openMenu(state.getMenuProvider(world, pos));
//        System.out.println(state.getBlock().asItem().getDescriptionId());
//
//        return InteractionResult.SUCCESS;
//    }
//    @Override
//    public RenderShape getRenderShape(BlockState state) {
//        return RenderShape.MODEL;
//    }
//    @Override
//    public boolean hasAnalogOutputSignal(BlockState state) {
//        return true;
//    }
//    @Override
//    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
//        BlockEntity blockEntity = world.getBlockEntity(pos);
//        return 0;
//    }
//
//    @Override
//    public WorldlyContainer getContainer(BlockState state, LevelAccessor world, BlockPos pos) {
//        return (WorldlyContainer) world.getBlockEntity(pos);
//    }
//
//
//}
