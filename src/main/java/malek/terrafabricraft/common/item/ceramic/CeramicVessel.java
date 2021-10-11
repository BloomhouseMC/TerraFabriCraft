package malek.terrafabricraft.common.item.ceramic;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CeramicVessel extends Item  {
    public Mode mode = Mode.INVENTORY;

    public CeramicVessel(Item.Settings settings) {
        super(settings);

    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        System.out.println(mode.name);
        if(!user.isSneaking()){
            mode = Mode.INVENTORY;
            openScreen(user, user.getStackInHand(hand), mode);
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        if(user.isSneaking()){
            mode = Mode.ALLOY_LIQUID;
            openScreen(user, user.getStackInHand(hand), mode);
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }
    public static void openScreen(PlayerEntity player, ItemStack vesselItemStack, Mode mode) {
        if(player.world != null && !player.world.isClient) {
            player.openHandledScreen(new ExtendedScreenHandlerFactory() {
                @Override
                public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
                    packetByteBuf.writeItemStack(vesselItemStack);
                }

                @Override
                public Text getDisplayName() {
                    return mode == Mode.INVENTORY ?
                        new TranslatableText(vesselItemStack.getItem().getTranslationKey()) :
                        new TranslatableText(vesselItemStack.getItem().getTranslationKey()).append(" Liquid");
                }

                @Override
                public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                    return new CeramicVesselScreenHandler(syncId, inv, vesselItemStack);
                }
            });
        }
    }
    public enum Mode {
        INVENTORY("INVENTORY"),
        ALLOY_LIQUID("ALLOY_LIQUID"),
        ALLOY_SOLID("ALLOY_SOLID");

        public final String name;

        Mode(String name) {
            this.name = name;
        }
    }
    public Mode mode() {
        //TODO: Add conditions
        return Mode.INVENTORY;
    }
}
