package malek.terrafabricraft.common.item;

import malek.terrafabricraft.common.block.TFCLooseRock;
import malek.terrafabricraft.common.knapping.KnappingScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import org.jetbrains.annotations.Nullable;

public class TFCLooseRockItem extends BlockItem {

    public TFCLooseRockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getPlayer().isSneaking()) {
            openScreen(context.getPlayer(), context.getStack());
            return ActionResult.SUCCESS;
        }
        if (context.getWorld().getBlockState(context.getBlockPos()).getBlock().asItem() != null
                && context.getWorld().getBlockState(context.getBlockPos()).getBlock().asItem() == context.getStack().getItem()) {
            if (context.getWorld().getBlockState(context.getBlockPos()).get(TFCLooseRock.COUNT) == 3) {
                return ActionResult.PASS;
            }
            context.getWorld().setBlockState(context.getBlockPos(), context.getWorld().getBlockState(context.getBlockPos()).with(TFCLooseRock.COUNT, context.getWorld().getBlockState(context.getBlockPos()).get(TFCLooseRock.COUNT) + 1));
            context.getPlayer().getMainHandStack().setCount(context.getPlayer().getMainHandStack().getCount() - 1);
            return ActionResult.PASS;
        } else {
            ActionResult actionResult = this.place(new ItemPlacementContext(context));
            return actionResult;
        }
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
                public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                    return new KnappingScreenHandler(syncId, inv, looseRockItemStack);
                }
            });
        }
    }
}
