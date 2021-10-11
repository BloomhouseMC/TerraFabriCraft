package malek.terrafabricraft.common.knapping;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlayerInvPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.netty.buffer.Unpooled;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.item.TFCLooseRockItem;
import malek.terrafabricraft.common.item.ceramic.CeramicVessel;
import malek.terrafabricraft.common.item.ceramic.CeramicVesselScreenHandler;
import malek.terrafabricraft.common.recipes.KnappingRecipe;
import malek.terrafabricraft.common.registry.TFCRecipeTypes;
import malek.terrafabricraft.common.registry.TFCScreens;
import malek.terrafabricraft.common.util.TFCUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

public class KnappingScreenHandler extends SyncedGuiDescription {
    private boolean[][] knapped_area = new boolean[5][5];
    final ItemStack itemStack;
    KnappingScreen parent;
    private final int padding = 8;
    private final int extraPaddeing = 4;
    private final int titleSpace = 10;
    public KnappingRecipe knappingRecipe = null;

    public KnappingScreenHandler(int synchronizationID, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        this(synchronizationID, playerInventory, packetByteBuf.readItemStack());
    }

    public KnappingScreenHandler(int synchronizationID, PlayerInventory playerInventory, ItemStack itemStack) {
        super(TFCScreens.KNAPPING_SCREEN_HANDLER, synchronizationID, playerInventory);
        this.itemStack = itemStack;
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(175, 200);
        root.setInsets(Insets.ROOT_PANEL);

        //WSprite gui = new WSprite(new Identifier("terrafabricraft:textures/gui/knapping.png"));

        //root.add(gui, 0,0,7,7);
        WSprite background = new WSprite(new Identifier("terrafabricraft:textures/gui/knapping/rock/loose/andesite.png"));
        root.add(background, 0, 1, 5, 5);
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                WKnappButton wKnappButton = new WKnappButton(this, i, j);
                root.add(wKnappButton, i + 0, j + 1);
            }
        }
        //TODO: hook identifier to result of a recipe
        WSprite result = new WSprite(new Identifier("terrafabricraft:textures/item/stone/axe_head.png"));
        WSprite slot = new WSprite(new Identifier("terrafabricraft:textures/gui/slot.png"));
        if(itemStack.getItem() instanceof TFCLooseRockItem tfcLooseRockItem){
            WItemSlot results = WItemSlot.of(tfcLooseRockItem, 0);
            root.add(results, 7, 2);
        }
        root.add(slot, 7, 3);
        root.add(result, 7, 3);

        root.add(this.createPlayerInventoryPanel(WPlayerInvPanel.createInventoryLabel(playerInventory).setHorizontalAlignment(HorizontalAlignment.CENTER)), 0, 6);
        root.validate(this);

    }

    @Override
    public void setStackInSlot(int slot, int revision, ItemStack stack) {
        knappingRecipe = world.getRecipeManager().listAllOfType(TFCRecipeTypes.KNAPPING_RECIPE_TYPE).stream().filter(recipe -> recipe.matches(knapped_area, world)).findFirst().orElse(null);
        super.setStackInSlot(slot, revision, stack);
    }

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
            if (knappingScreenHandler.knapped_area[knapx][knapy]){
                super.paint(matrices, x, y, mouseX, mouseY);
            }
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
