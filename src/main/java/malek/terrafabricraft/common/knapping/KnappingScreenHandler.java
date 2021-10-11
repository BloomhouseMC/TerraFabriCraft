package malek.terrafabricraft.common.knapping;

import com.mojang.blaze3d.systems.RenderSystem;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;

public class KnappingScreenHandler extends AbstractRecipeScreenHandler<CraftingInventory> {
    private final CraftingInventory input;
    private final CraftingResultInventory output;
    private final CraftingResultInventory result;
    private final PlayerEntity player;

    public KnappingScreenHandler(int syncID, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        this(syncID, playerInventory, packetByteBuf.readItemStack());
    }

    public KnappingScreenHandler(int i, PlayerInventory inv, ItemStack looseRockStack) {
        super(TFCScreens.KNAPPING_SCREEN_HANDLER, i);
        input = new CraftingInventory(this, 5, 5);
        result = new CraftingResultInventory();
        output = new CraftingResultInventory();
        player = inv.player;
        this.addSlot(new CraftingResultSlot(inv.player, this.input, this.result, 0, 124, 35));

        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            for (int k = 0; k <= 11; k++) {
                for (int j = 0; j <= 11; j++) {
                    KnappingButton bCarveButton = new KnappingButton(matrices, k, j);
                }
            }
        });
        int n;
        int m;
        for (n = 0; n < 5; ++n) {
            for (m = 0; m < 5; ++m) {
                this.addSlot(new Slot(input, m + n * 5, 30 + m * 18, 17 + n * 18));
            }
        }

        var removedSpacing = 35;
        int l;
        for (l = 0; l < 3; ++l) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inv, k + l * 9 + 9, 8 + k * 18, 84 + removedSpacing + l * 18));
            }
        }

        for (l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inv, l, 8 + l * 18, 142 + removedSpacing));
        }


    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < 5;
    }

    @Override
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        super.onSlotClick(slotIndex, button, actionType, player);
        TerraFabriCraft.LOGGER.debug("Detected " + actionType + " click!");
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }


    @Override
    public void populateRecipeFinder(RecipeMatcher finder) {

    }

    @Override
    public void clearCraftingSlots() {

    }

    @Override
    public boolean matches(Recipe<? super CraftingInventory> recipe) {
        return recipe.matches(input, player.world);
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 0;
    }

    @Override
    public int getCraftingWidth() {
        return 0;
    }

    @Override
    public int getCraftingHeight() {
        return 0;
    }

    @Override
    public int getCraftingSlotCount() {
        return 0;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return RecipeBookCategory.CRAFTING;
    }

    @Override
    public boolean canInsertIntoSlot(int index) {
        return false;
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack itemStack2 = slot.getStack();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (index == 1) {
                item.onCraft(itemStack2, player.world, player);
                if (!this.insertItem(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickTransfer(itemStack2, itemStack);
            } else if (index == 0) {
                if (!this.insertItem(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
/*            } else if (this.world.getRecipeManager().getFirstMatch(RecipeType.STONECUTTING, new SimpleInventory(new ItemStack[]{itemStack2}), this.world).isPresent()) {
                if (!this.insertItem(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }*/
            } else if (index >= 2 && index < 29) {
                if (!this.insertItem(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.insertItem(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            }

            slot.markDirty();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, itemStack2);
            this.sendContentUpdates();
        }

        return itemStack;
    }

    private static class KnappingButton {
        MatrixStack matrices;
        int x;
        int y;
        int mouseX;
        int mouseY;
        public KnappingButton(MatrixStack matrices, int x, int y) {
            this.matrices = matrices;
            this.x = x;
            this.y = y;
            this.mouseX = -1;
            this.mouseY = -1;
        }
        public void paint() {
            var width = 18;
            var height = 18;

            if (width <= 0) width = 1;
            if (height <= 0) height = 1;

            float r = (0xFFFFFFFF >> 16 & 255) / 255.0F;
            float g = (0xFFFFFFFF >> 8 & 255) / 255.0F;
            float b = (0xFFFFFFFF & 255) / 255.0F;
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder buffer = tessellator.getBuffer();
            Matrix4f model = matrices.peek().getModel();
            RenderSystem.enableBlend();
            RenderSystem.setShaderTexture(0, new Identifier(TerraFabriCraft.MODID, "gui/knapping/rock.loose/andesite"));
            RenderSystem.setShaderColor(r, g, b, 1.0f);
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
            buffer.vertex(model, x, y + height, 0).texture(0.0F, 1.0F).next();
            buffer.vertex(model, x + width, y + height, 0).texture(1.0F, 1.0F).next();
            buffer.vertex(model, x + width, y, 0).texture(1.0F, 0.0F).next();
            buffer.vertex(model, x, y, 0).texture(0.0F, 0.0F).next();
            buffer.end();
            BufferRenderer.draw(buffer);
            RenderSystem.disableBlend();
        }
    }

//    protected KnappingButton addSlot(KnappingButton button) {
//        button.id = this.slots.size();
//        this.slots.add(button);
//        this.trackedStacks.add(ItemStack.EMPTY);
//        this.previousTrackedStacks.add(ItemStack.EMPTY);
//        return button;
//    }
}
