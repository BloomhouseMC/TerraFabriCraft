package io.github.bloomhousemc.terrafabricraft.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.CLIENT)
@Mixin(PlayerScreenHandler.class)
public class PlayerScreenHandlerMixin extends ScreenHandler {


    @Final @Shadow private final CraftingInventory craftingInput = new CraftingInventory(this, 3, 20);

    protected PlayerScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }


    /**
     * @author - MrSterner
     * Removes the original 2x2
     */
    @ModifyConstant(method = "<init>(Lnet/minecraft/entity/player/PlayerInventory;ZLnet/minecraft/entity/player/PlayerEntity;)V", constant = @Constant(intValue = 98))
    private int yeetInventory2x2Grid(int value){
        return 300;
    }

    /**
     * @author - MrSterner
     * Adds a 3x3 crafting grid in the inventory.
     */
    @Inject(method = "<init>(Lnet/minecraft/entity/player/PlayerInventory;ZLnet/minecraft/entity/player/PlayerEntity;)V", at = @At("TAIL"))
    private void inventory3x3Grid(PlayerInventory inventory, boolean onServer, PlayerEntity owner, CallbackInfo ci){
        int m;
        int n;
        for(n = 0; n < 3; ++n) {
            for(m = 0; m < 3; ++m) {
                this.addSlot(new Slot(this.craftingInput, m + n * 3 + 48, 98 + m * 18 - 9, 18 + n * 18 - 9));
            }
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
