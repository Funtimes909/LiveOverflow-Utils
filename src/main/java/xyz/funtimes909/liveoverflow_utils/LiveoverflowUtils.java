package xyz.funtimes909.liveoverflow_utils;

import xyz.funtimes909.liveoverflow_utils.modules.AntiHumanBypass;
import xyz.funtimes909.liveoverflow_utils.modules.WorldBorderBypass;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class LiveoverflowUtils extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Example");
    public static final HudGroup HUD_GROUP = new HudGroup("Example");

    @Override
    public void onInitialize() {
        LOG.info("Starting LiveOverflow Addon");

        // Modules
        Modules.get().add(new AntiHumanBypass());
        Modules.get().add(new WorldBorderBypass());
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
