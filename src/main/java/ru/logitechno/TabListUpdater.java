package ru.logitechno;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundTabListPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public class TabListUpdater {
    public static void onServerTick(MinecraftServer server) {
        if (server.getTickCount() % 32 != 0) return;

        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            Component header = Component.literal(TabListVariables.tablistChars(Config.header, player, server));
            Component footer = Component.literal(TabListVariables.tablistChars(Config.footer, player, server));
            ClientboundTabListPacket packet = new ClientboundTabListPacket(header, footer);
            player.connection.send(packet);
        }
    }
}
