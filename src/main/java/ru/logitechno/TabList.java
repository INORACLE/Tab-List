package ru.logitechno;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

public class TabList implements ModInitializer {
    public static final String MOD_ID = "tablist";
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        Config.load();
        ServerTickEvents.END_SERVER_TICK.register(TabListUpdater::onServerTick);
        LOGGER.info("TabList mod initialized");
    }
}
