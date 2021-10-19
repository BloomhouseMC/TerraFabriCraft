package malek.terrafabricraft.common.block.logpile;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WPlayerInvPanel;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerContext;

public class LogPileGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 17;
    BlockEntity blockEntity;
    ScreenHandlerContext context;
    WPlainPanel root;
    int sizeX = 80;
    int sizeY = 80;
    public LogPileGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(TFCScreens.LOG_PILE_SCREEN_HANDLER, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context, 3));
        this.context = context;
        root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(sizeX, sizeY);
        root.setInsets(Insets.ROOT_PANEL);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        WItemSlot itemSlot1 = WItemSlot.of(blockInventory, 1);
        WItemSlot itemSlot2 = WItemSlot.of(blockInventory, 2);
        WItemSlot itemSlot3 = WItemSlot.of(blockInventory, 3);

        int sizeOfSlot = 18;
        int halfSlot = 9;
        int diagonal = ((sizeOfSlot+halfSlot));
        int diagonalY = sizeOfSlot;
       int x= 0;
       int y = 0;
        root.add(itemSlot, 45, 15);
        root.add(itemSlot1, 75, 15);
        root.add(itemSlot2, 45, 45);
        root.add(itemSlot3, 75, 45);


//        WSprite sprite = new WSprite(new Identifier(ModScience.MODID, "textures/gui/tesseract/tesseract_ui_tier1.png"));
//        this.titleVisible = false;
//        root.add(sprite, 0, -10, sizeX, sizeY);

        root.add(this.createPlayerInventoryPanel(WPlayerInvPanel.createInventoryLabel(playerInventory).setHorizontalAlignment(HorizontalAlignment.CENTER)), x, y+80);

        root.validate(this);
    }
    private BlockEntity getBlockEntity(ScreenHandlerContext ctx) {
        return (BlockEntity) ctx.get((world, pos) -> {
            BlockState state = world.getBlockState(pos);
            Block b = state.getBlock();
            System.out.println(world.getBlockEntity(pos));
            blockEntity = world.getBlockEntity(pos);
            return world.getBlockEntity(pos);

        }).get();
    }
}
