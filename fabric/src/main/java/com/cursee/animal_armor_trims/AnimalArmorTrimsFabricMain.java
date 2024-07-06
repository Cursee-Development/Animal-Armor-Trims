package com.cursee.animal_armor_trims;

import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class AnimalArmorTrimsFabricMain implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);
    }
}
