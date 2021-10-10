package malek.terrafabricraft.common.knapping;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WPlayerInvPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.netty.buffer.Unpooled;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.item.ceramic.CeramicVessel;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

public class KnappingScreenHandler extends SyncedGuiDescription {
    private boolean[][] knapped_area = new boolean[5][5];
    final ItemStack itemStack;
    KnappingScreen parent;

    public KnappingScreenHandler(int synchronizationID, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        this(synchronizationID, playerInventory, packetByteBuf.readItemStack());
    }

    public KnappingScreenHandler(int synchronizationID, PlayerInventory playerInventory, ItemStack itemStack) {
        super(TFCScreens.KNAPPING_SCREEN_HANDLER, synchronizationID, playerInventory);
        //super(TFCScreens.KNAPPING_SCREEN_HANDLER, synchronizationID);
        //super(TFCScreens.KNAPPING_SCREEN_HANDLER, synchronizationID);
        this.itemStack = itemStack;
        WGridPanel root = new WGridPanel();
        setRootPanel(root);

        //WSprite gui = new WSprite(new Identifier("terrafabricraft:textures/gui/knapping.png"));

        //root.add(gui, 0,0,7,7);
        WSprite background = new WSprite(new Identifier("terrafabricraft:textures/gui/knapping/rock/loose/andesite.png"));
        root.add(background, 1, 1, 5, 5);
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                WKnappButton wKnappButton = new WKnappButton(this, i, j);
                root.add(wKnappButton, i + 1, j + 1);
            }
        }

        root.add(this.createPlayerInventoryPanel(WPlayerInvPanel.createInventoryLabel(playerInventory).setHorizontalAlignment(HorizontalAlignment.CENTER)), 0, 4);
        root.validate(this);

    }




/*
    public KnappingScreenHandler(int syncId, PlayerInventory playerInventory , ItemStack itemStack) {
        this.itemStack = itemStack;
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        //WSprite gui = new WSprite(new Identifier("terrafabricraft:textures/gui/knapping.png"));

        //root.add(gui, 0,0,7,7);
        WSprite background = new WSprite(new Identifier("terrafabricraft:textures/gui/knapping/rock/loose/andesite.png"));
        root.add(background, 1, 1, 5, 5);
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                WKnappButton wKnappButton = new WKnappButton(this, i, j);
                root.add(wKnappButton, i + 1, j + 1);
            }
        }

        root.add(this.createPlayerInventoryPanel(WPlayerInvPanel.createInventoryLabel(playerInventory).setHorizontalAlignment(HorizontalAlignment.CENTER)), 0, 4);
        root.validate(this);
    }

 */

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }


    private static class WKnappButton extends WSprite {
        private static final Identifier imageid = new Identifier("terrafabricraft:textures/gui/knapping/knapping_overlay.png");
        private KnappingScreenHandler knappingScreenHandler;
        private int knapx;
        private int knapy;

        WKnappButton(KnappingScreenHandler knappingScreenHandler, int knapx, int knapy) {
            super(imageid);
            this.knappingScreenHandler = knappingScreenHandler;
            this.knapx = knapx;
            this.knapy = knapy;
        }

        @Override
        public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
            if (knappingScreenHandler.knapped_area[knapx][knapy]) super.paint(matrices, x, y, mouseX, mouseY);
        }

        @Environment(EnvType.CLIENT)
        @Override
        public InputResult onMouseMove(int x, int y) {
            if (this.knappingScreenHandler.parent.mouseDown && !knappingScreenHandler.knapped_area[knapx][knapy]) {
                MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                this.knappingScreenHandler.knapped_area[knapx][knapy] = true;
                PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                passedData.writeInt(knapx);
                passedData.writeInt(knapy);
                ClientSidePacketRegistry.INSTANCE.sendToServer(TerraFabriCraft.KNAPPING_PACKET_ID, passedData);
                return InputResult.PROCESSED;
            }
            return InputResult.IGNORED;
        }

        @Override
        public InputResult onClick(int x, int y, int button) {
            if (!knappingScreenHandler.knapped_area[knapx][knapy]) {
                MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                this.knappingScreenHandler.knapped_area[knapx][knapy] = true;
                PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                passedData.writeInt(knapx);
                passedData.writeInt(knapy);
                ClientSidePacketRegistry.INSTANCE.sendToServer(TerraFabriCraft.KNAPPING_PACKET_ID, passedData);
                return InputResult.PROCESSED;
            }
            return InputResult.IGNORED;
        }
    }


}
