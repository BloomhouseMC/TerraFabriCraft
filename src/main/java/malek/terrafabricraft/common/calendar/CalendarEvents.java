package malek.terrafabricraft.common.calendar;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import java.util.List;

public class CalendarEvents {

    public static void onPlayerLoggedIn(Player initialplayer)
    {
        if (initialplayer instanceof ServerPlayer player)
        {
            // Check total players and reset player / calendar time ticking
            MinecraftServer server = player.getServer();
            if (server != null)
            {
            //    Calendars.SERVER.setPlayersLoggedOn(server.getCurrentPlayerCount() > 0);
            }
        }
    }

    public static void onPlayerLoggedOut(Player initialPlayer)
    {
        if (initialPlayer instanceof ServerPlayer player)
        {
            // Check total players and reset player / calendar time ticking
            MinecraftServer server = player.getServer();
            if (server != null)
            {
                List<ServerPlayer> players = server.getPlayerList().getPlayers();
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
