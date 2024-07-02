package com.cursee.animal_armor_trims;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class AnimalArmorTrimsNeoForge {

    public AnimalArmorTrimsNeoForge(IEventBus eventBus) {

        AnimalArmorTrims.init();
    }
}
