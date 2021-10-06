package malek.terrafabricraft.common.knapping;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;

public class KnappingScreenHandler extends ScreenHandler {
    private final Property selectedSquare;

    public KnappingScreenHandler(int syncID, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        this(syncID, playerInventory, packetByteBuf.readItemStack());
    }

    public KnappingScreenHandler(int i, PlayerInventory inv, ItemStack looseRockStack) {
        super(TFCScreens.KNAPPING_SCREEN_HANDLER, i);
        selectedSquare = Property.create();
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < 5;
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            this.selectedSquare.set(id);
            TerraFabriCraft.LOGGER.debug("Selecting square");
        }

        return true;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }


}
