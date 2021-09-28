package malek.terrafabricraft.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.CLIENT)
@Mixin(InventoryMenu.class)
public class PlayerScreenHandlerMixin extends AbstractContainerMenu {

@Final
@Shadow private final CraftingContainer craftSlots = new CraftingContainer(this, 3, 20);

    protected PlayerScreenHandlerMixin(@Nullable MenuType<?> type, int syncId) {
        super(type, syncId);
    }

    @ModifyConstant(method = "<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", constant = @Constant(intValue = 98))
    private int yeetInventory2x2Grid(int value){
        return 300;
    }

    @Inject(method = "<init>(Lnet/minecraft/world/entity/player/Inventory;ZLnet/minecraft/world/entity/player/Player;)V", at = @At("TAIL"))
    private void inventory3x3Grid(Inventory inventory, boolean onServer, Player owner, CallbackInfo ci){
        int m;
        int n;
        for(n = 0; n < 3; ++n) {
            for(m = 0; m < 3; ++m) {
                this.addSlot(new Slot(this.craftSlots, m + n * 3 + 48, 98 + m * 18 - 9, 18 + n * 18 - 9));
            }
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
