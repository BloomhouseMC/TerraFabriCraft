package malek.terrafabricraft.common.block.keg;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class KegGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 17;
    BlockEntity blockEntity;
    WPlainPanel root;
    int sizeX = 80;
    int sizeY = 80;
    public KegGuiDescription(int syncId, Inventory playerInventory, ContainerLevelAccess context) {
        super(TFCScreens.KEG_SCREEN_HANDLER, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context, 6));

        root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(sizeX, sizeY);
        root.setInsets(Insets.ROOT_PANEL);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        WItemSlot itemSlot1 = WItemSlot.of(blockInventory, 1);
        WItemSlot itemSlot2 = WItemSlot.of(blockInventory, 2);
        WItemSlot itemSlot3 = WItemSlot.of(blockInventory, 3);
        WBar tankBarLeft = new WBar(new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/tank_empty.png"), new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/tank_full.png"), 0, 1, WBar.Direction.UP);
        WBar tankBarRight = new WBar(new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/tank_empty.png"), new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/tank_full.png"), 4, 5, WBar.Direction.UP);
        WBar progressBar = new WBar(new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/progress_off.png"), new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/progress_green.png"), 2, 3, WBar.Direction.RIGHT);
        //WLabel title = new WLabel(new TranslatableText("block.terrafabricraft.keg"), WLabel.DEFAULT_TEXT_COLOR);
        //title.setHorizontalAlignment(HorizontalAlignment.CENTER);


        int sizeOfSlot = 18;
        int halfSlot = 9;
        int diagonal = ((sizeOfSlot+halfSlot));
        int diagonalY = sizeOfSlot;
        int x= 0;
        int y = 0;
        root.add(itemSlot, 4 * 9, 2 * 18 - 9);
        root.add(itemSlot1, 6 * 18 + 4, 2 * 18 - 9);
        root.add(itemSlot2, 1 * 9, 4 * 18 - 9);
        root.add(itemSlot3, 15 * 9, 4 * 18 - 9);

        root.add(tankBarLeft, 0, 18 - 9, 2 * 18, 3 * 18);
        root.add(tankBarRight, 7*18, 18 - 9, 2 * 18, 3 * 18);

        root.add(progressBar, 3 * 18, 2 * 18 + 1 - 9, 3 * 18, 18);
        //root.add(title, 0, -1, 9 * 18, 18);

        root.add(this.createPlayerInventoryPanel(WPlayerInvPanel.createInventoryLabel(playerInventory).setHorizontalAlignment(HorizontalAlignment.CENTER)), x, y+80);

        root.validate(this);



        /*
        WGridPanel root = new WGridPanel(1);
        setRootPanel(root);
        root.setSize(160, 128 + 36);

        WSprite background = new WSprite(new Identifier(TerraFabriCraft.MODID, "textures/gui/keg.png"));
        root.add(background, 0, 0, 9 * 18, 5 * 18);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 4 * 9, 3 * 9);

        WBar tankBar = new WBar(new Identifier(TerraFabriCraft.MODID, "textures/gui/tank_empty.png"), new Identifier(TerraFabriCraft.MODID, "textures/gui/tank_full.png"), 0, 1, WBar.Direction.UP);
        tankBar.withTooltip("gui." + TerraFabriCraft.MODID + ".keg_tooltip");
        root.add(tankBar, 0, 18, 2 * 18, 3 * 18);

        WBar tankBar2 = new WBar(new Identifier(TerraFabriCraft.MODID, "textures/gui/tank_empty.png"), new Identifier(TerraFabriCraft.MODID, "textures/gui/tank_full.png"), 4, 5, WBar.Direction.UP);
        tankBar2.withTooltip("gui." + TerraFabriCraft.MODID + ".keg_tooltip");
        root.add(tankBar2, 7*18, 18, 2 * 18, 3 * 18);

        WItemSlot outSlot = WItemSlot.outputOf(blockInventory, 1);
        root.add(outSlot, 6 * 18 + 4, 2 * 18);

        WBar progressBar = new WBar(new Identifier(TerraFabriCraft.MODID, "textures/gui/progress_off.png"), new Identifier(TerraFabriCraft.MODID, "textures/gui/progress_green.png"), 2, 3, WBar.Direction.RIGHT);
        root.add(progressBar, 3 * 18, 2 * 18 + 1, 3 * 18, 18);

        WLabel title = new WLabel(new TranslatableText("block.terrafabricraft.keg"), WLabel.DEFAULT_TEXT_COLOR);
        title.setHorizontalAlignment(HorizontalAlignment.CENTER);
        root.add(title, 0, -1, 9 * 18, 18);

        root.add(this.createPlayerInventoryPanel(), 0, 5 * 18);

        root.validate(this);

         */
    }
    private BlockEntity getBlockEntity(ContainerLevelAccess ctx) {
        return (BlockEntity) ctx.evaluate((world, pos) -> {
            BlockState state = world.getBlockState(pos);
            Block b = state.getBlock();
            System.out.println(world.getBlockEntity(pos));
            blockEntity = world.getBlockEntity(pos);
            return world.getBlockEntity(pos);

        }).get();
    }
}
