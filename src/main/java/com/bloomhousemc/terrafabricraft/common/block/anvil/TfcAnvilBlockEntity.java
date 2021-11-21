package com.bloomhousemc.terrafabricraft.common.block.anvil;

import com.bloomhousemc.terrafabricraft.client.screens.AnvilGuiDescription;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlockEntities;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
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

public class TfcAnvilBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {

    public TfcAnvilBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(TfcBlockEntities.ANVIL_BLOCK_ENTITY, blockPos, blockState);
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
