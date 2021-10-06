package malek.terrafabricraft.common.knapping;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.Property;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class KnappingScreenHandler extends AbstractRecipeScreenHandler {
    private final Property selectedSquare;
    private final Slot outputSlot;
    private final CraftingResultInventory output;

    public KnappingScreenHandler(int syncID, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        this(syncID, playerInventory, packetByteBuf.readItemStack());
    }

    public KnappingScreenHandler(int i, PlayerInventory inv, ItemStack looseRockStack) {
        super(TFCScreens.KNAPPING_SCREEN_HANDLER, i);
        selectedSquare = Property.create();
        this.output = new CraftingResultInventory();
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        int n;
        int m;
        for(n = 0; n < 5; ++n) {
            for(m = 0; m < 5; ++m) {
                this.addSlot(new Slot(inv, m + n * 5, 30 + m * 18, 17 + n * 18));
            }
        }

        int l;
        for (l = 0; l < 3; ++l) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inv, k + l * 9 + 9, 8 + k * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inv, l, 8 + l * 18, 142));
        }

        this.addProperty(this.selectedSquare);
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < 5;
    }

    @Override
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
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
    public boolean matches(Recipe recipe) {
        return false;
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

    public boolean canInsertIntoSlot(int index) {
        return false;
    }
}
