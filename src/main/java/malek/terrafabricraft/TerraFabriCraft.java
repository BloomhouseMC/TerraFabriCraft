package malek.terrafabricraft;

import malek.terrafabricraft.common.block.placeable.PlaceableBlock;
import malek.terrafabricraft.common.block.placeable.PlaceableBlockEntity;
import malek.terrafabricraft.common.calendar.CalendarManager;
import malek.terrafabricraft.common.config.TFCConfig;
import malek.terrafabricraft.common.event.TFCEvents;
import malek.terrafabricraft.common.item.TFCFood;
import malek.terrafabricraft.common.item.ceramic.CeramicVessel;
import malek.terrafabricraft.common.registry.*;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.network.S2CPacketTypeCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.registry.ItemConstructedCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class TerraFabriCraft implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger(TerraFabriCraft.MODID);

    public static final String MODID = "terrafabricraft";
    public static final ItemGroup EARTH_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "earth"), () -> new ItemStack(TFCObjects.SAND_WHITE));
    public static final ItemGroup ORES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "ores"), () -> new ItemStack(TFCObjects.ORE_SMALL_NATIVE_COPPPER));
    public static final ItemGroup ROCK_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "rock"), () -> new ItemStack(TFCObjects.ANDESITE.raw.block));
    public static final ItemGroup METAL_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "metal"), () -> new ItemStack(TFCObjects.INGOT.wrought_iron));
    public static final ItemGroup WOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "wood"), () -> new ItemStack(TFCObjects.WOOD_DOUGLAS_FIR.log));
    public static final ItemGroup FLORA_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "flora"), () -> new ItemStack(TFCObjects.CORAL_BRAIN.coral));
    public static final ItemGroup DEVICES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "devices"), () -> new ItemStack(TFCObjects.LOG_PILE));
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "food"), () -> new ItemStack(TFCObjects.RED_APPLE));
    //public static final ItemGroup MISC_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "misc"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup DECORATIONS_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "decorations"), () -> new ItemStack(TFCObjects.ALABASTER_STAINED_CYAN.brick.block));


    @Override
    public void onInitialize() {
        // Config *must* be loaded before any other registry
        TFCConfig.init();
        //Features must always be loaded before TFCObjects.
        TFCFeatures.init();
        TFCObjects.init();
        TFCBiome.init();
        TFCEntityTypes.init();
        TFCEvents.init();
        TFCScreens.init();
        TFCParticleTypes.init();
        TFCRecipeTypes.init();
        CalendarManager.init();



        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if(player.isSneaking() && player.getStackInHand(hand).getItem() == TFCObjects.CERAMIC_VESSEL){
                BlockPos pos = hitResult.getBlockPos();
                int newPosX = pos.getX();
                int newPosY = pos.getY();
                int newPosZ = pos.getZ();
                Direction direction = hitResult.getSide();
                switch (direction) {
                    case UP ->  newPosY = pos.getY() + 1;
                    case DOWN -> newPosY = pos.getY() - 1;
                    case NORTH -> newPosZ = pos.getZ() - 1;
                    case SOUTH -> newPosZ = pos.getZ() + 1;
                    case EAST -> newPosX = pos.getX() + 1;
                    case WEST -> newPosX = pos.getX() - 1;
                }
                double normalX = (hitResult.getPos().x - pos.getX());
                double normalZ = (hitResult.getPos().z - pos.getZ());



                BlockPos blockPos = new BlockPos(newPosX,newPosY,newPosZ);
                BlockState newPlaceable = TFCObjects.PLACEABLE.getDefaultState();
                newPlaceable = TFCObjects.PLACEABLE.getDefaultState().with(Properties.HORIZONTAL_FACING, newPlaceable.get(PlaceableBlock.FACING));
                BlockPos checkAir = new BlockPos(newPosX,newPosY-1,newPosZ);
                if(world.getBlockState(checkAir).getBlock() != Blocks.AIR){
                    world.setBlockState(blockPos, newPlaceable, 3);
                    BlockEntity placeableEntity = world.getBlockEntity(blockPos);
                    PlaceableBlockEntity placeableEntity1 = (PlaceableBlockEntity) placeableEntity;
                    placeableEntity1.inventory.set(0,player.getStackInHand(hand).split(1));

                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
            return ActionResult.PASS;
        });

//        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
//            lines.add(new TranslatableText("tooltip.terrafabricraft.itemprop", new TranslatableText("Pog", new TranslatableText("Big"))));
//            /*
//            ClientWorld world = MinecraftClient.getInstance().world;
//            if (world != null && stack.isFood() && stack.getItem() != TFCObjects.DECAY_FOOD_TEST2) {
//                int percent = ((TFCFood.FoodDecay) (Object) stack).getRotPercentage(world);
//                lines.add(new TranslatableText("tooltip.terrafabricraft.rot_status", percent).setStyle(Style.EMPTY.withColor(TextColor.parse("gray"))));
//            }
//
//             */
//        });
    }
}
