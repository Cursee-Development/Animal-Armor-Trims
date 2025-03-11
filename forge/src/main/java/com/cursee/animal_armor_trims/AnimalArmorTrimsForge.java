package com.cursee.animal_armor_trims;

import com.cursee.animal_armor_trims.core.registry.RegistryForge;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class AnimalArmorTrimsForge {

    public static IEventBus EVENT_BUS = null;
    
    public AnimalArmorTrimsForge(FMLJavaModLoadingContext context) {
        AnimalArmorTrims.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        AnimalArmorTrimsForge.EVENT_BUS = context.getModEventBus();
        RegistryForge.register(AnimalArmorTrimsForge.EVENT_BUS);
    }
}