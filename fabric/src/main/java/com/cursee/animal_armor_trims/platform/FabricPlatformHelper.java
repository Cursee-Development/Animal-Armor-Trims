package com.cursee.animal_armor_trims.platform;

import com.cursee.animal_armor_trims.platform.services.IPlatformHelper;
import com.cursee.monolib.util.GlobalFabricObjects;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {
    @Override
    public String getModLoaderName() {
        return "Fabric";
    }

    @Override
    public String getGameDirectory() {
        return GlobalFabricObjects.fabricLoader.getGameDir().toString();
    }

    @Override
    public boolean isModLoaded(String modId) {
        return GlobalFabricObjects.fabricLoader.isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return GlobalFabricObjects.fabricLoader.isDevelopmentEnvironment();
    }

    @Override
    public boolean isClientSide() {
        return GlobalFabricObjects.fabricLoader.getEnvironmentType() == EnvType.CLIENT;
    }
}