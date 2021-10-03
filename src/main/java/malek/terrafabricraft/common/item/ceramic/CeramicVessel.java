package malek.terrafabricraft.common.item.ceramic;

import malek.terrafabricraft.common.block.keg.KegEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
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
        if(!user.isSneaking() && mode == Mode.INVENTORY){
            openScreen(user, user.getStackInHand(hand));
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }
    public static void openScreen(PlayerEntity player, ItemStack vesselItemStack) {
        if(player.world != null && !player.world.isClient) {
            player.openHandledScreen(new ExtendedScreenHandlerFactory() {
                @Override
                public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
                    packetByteBuf.writeItemStack(vesselItemStack);
                }

                @Override
                public Text getDisplayName() {
                    return new TranslatableText(vesselItemStack.getItem().getTranslationKey());
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
