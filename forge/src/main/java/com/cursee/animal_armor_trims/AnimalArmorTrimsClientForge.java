package com.cursee.animal_armor_trims;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class AnimalArmorTrimsClientForge {

    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModClientBusEvents {

        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                AnimalArmorTrimsClient.init();
            });
        }
    }
}
