package com.bloomhousemc.terrafabricraft.common.item;

import com.bloomhousemc.terrafabricraft.common.ImplementedInventory;
import com.bloomhousemc.terrafabricraft.common.gui.knapping.KnappingScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class TfcLooseRockItem extends BlockItem implements ImplementedInventory {
    private final DefaultedList<ItemStack> list = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public TfcLooseRockItem(Block block, Settings settings) {
        super(block, settings);

    }

    public static void openScreen(PlayerEntity player, ItemStack looseRockItemStack) {
        if (player.world != null && !player.world.isClient) {
            player.openHandledScreen(new ExtendedScreenHandlerFactory() {
                @Override
                public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
                    packetByteBuf.writeItemStack(looseRockItemStack);
                }

                @Override
                public Text getDisplayName() {
                    return new TranslatableText(looseRockItemStack.getItem().getTranslationKey());
                }

                @Override
                public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                    return new KnappingScreenHandler(syncId, inv, looseRockItemStack);
                }
            });
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer().isSneaking()) {
            return super.useOnBlock(context);
        }
        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.isSneaking()) {
            openScreen(user, user.getStackInHand(hand));
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return list;
    }
}
