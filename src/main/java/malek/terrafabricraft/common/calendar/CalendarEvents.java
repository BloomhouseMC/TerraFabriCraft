package malek.terrafabricraft.common.calendar;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.List;

public class CalendarEvents {

    public static void onPlayerLoggedIn(PlayerEntity initialplayer)
    {
        if (initialplayer instanceof ServerPlayerEntity player)
        {
            // Check total players and reset player / calendar time ticking
            MinecraftServer server = player.getServer();
            if (server != null)
            {
            //    Calendars.SERVER.setPlayersLoggedOn(server.getCurrentPlayerCount() > 0);
            }
        }
    }

    public static void onPlayerLoggedOut(PlayerEntity initialPlayer)
    {
        if (initialPlayer instanceof ServerPlayerEntity player)
        {
            // Check total players and reset player / calendar time ticking
            MinecraftServer server = player.getServer();
            if (server != null)
            {
                List<ServerPlayerEntity> players = server.getPlayerManager().getPlayerList();
                int playerCount = players.size();
                // The player logging out doesn't count
                if (players.contains(player))
                {
                    playerCount--;
                }
            //    Calendars.SERVER.setPlayersLoggedOn(playerCount > 0);
            }
        }
    }
}
