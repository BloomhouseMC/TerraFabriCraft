package io.github.bloomhousemc.terrafabricraft.common.block.anvil;

import io.github.bloomhousemc.terrafabricraft.client.screens.AnvilGuiDescription;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class TFCAnvilBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {

    public TFCAnvilBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(TFCObjects.ANVIL_BLOCK_ENTITY, blockPos, blockState);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new AnvilGuiDescription(syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
}
