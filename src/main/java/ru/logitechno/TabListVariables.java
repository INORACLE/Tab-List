package ru.logitechno;

import me.lucko.spark.api.Spark;
import me.lucko.spark.api.SparkProvider;
import me.lucko.spark.api.statistic.StatisticWindow;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public class TabListVariables {
    public static String tablistChars(String text, ServerPlayer player, MinecraftServer server) {
        if (server == null) return text;

        Spark spark = null;
        try {
            spark = SparkProvider.get();
        } catch (Exception ignored) {
        }

        String result = text;
        result = result.replace("#TPS", String.valueOf(getTPS(spark)));
        result = result.replace("#MSPT", String.valueOf(getMSPT(spark)));
        result = result.replace("#PLAYERCOUNT", Integer.toString(getPlayerCount(server)));
        result = result.replace("#PING", Integer.toString(getPlayerPing(player)));
        result = result.replace("#N", "\n");
        result = result.replace("&", "\u00a7");
        return result;
    }

    private static double getTPS(Spark spark) {
        if (spark == null) return 0;
        try {
            var tps = spark.tps();
            if (tps == null) return 0;
            return Math.round(tps.poll(StatisticWindow.TicksPerSecond.SECONDS_5) * 10.0) / 10.0;
        } catch (Exception e) {
            return 0;
        }
    }

    private static double getMSPT(Spark spark) {
        if (spark == null) return 0;
        try {
            var mspt = spark.mspt();
            if (mspt == null) return 0;
            return Math.round(mspt.poll(StatisticWindow.MillisPerTick.SECONDS_10).mean() * 10.0) / 10.0;
        } catch (Exception e) {
            return 0;
        }
    }

    private static int getPlayerCount(MinecraftServer server) {
        return server.getPlayerList().getPlayerCount();
    }

    private static int getPlayerPing(ServerPlayer player) {
        return player.connection.latency();
    }
}
