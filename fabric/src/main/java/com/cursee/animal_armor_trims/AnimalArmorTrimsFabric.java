package com.cursee.animal_armor_trims;

import com.cursee.animal_armor_trims.core.registry.RegistryFabric;
import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;

public class AnimalArmorTrimsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        AnimalArmorTrims.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        RegistryFabric.register();
    }
}
