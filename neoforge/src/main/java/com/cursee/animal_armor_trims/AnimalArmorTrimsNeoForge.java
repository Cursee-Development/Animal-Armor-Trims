package com.cursee.animal_armor_trims;

import com.cursee.animal_armor_trims.core.registry.RegistryNeoForge;
import com.cursee.monolib.core.sailing.Sailing;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class AnimalArmorTrimsNeoForge {

    public static IEventBus EVENT_BUS = null;

    public AnimalArmorTrimsNeoForge(IEventBus modEventBus) {
        AnimalArmorTrims.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        AnimalArmorTrimsNeoForge.EVENT_BUS = modEventBus;
        RegistryNeoForge.register(AnimalArmorTrimsNeoForge.EVENT_BUS);
    }
}