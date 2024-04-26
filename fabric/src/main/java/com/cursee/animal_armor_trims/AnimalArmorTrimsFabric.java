package com.cursee.animal_armor_trims;

import com.cursee.monolib.CommonConstants;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class AnimalArmorTrimsFabric implements ModInitializer {
    
    // public static final ResourceLocation TEST = new ResourceLocation(Constants.MOD_ID, "textures/horse/trim/models_old/coast.png");
    // public static final ResourceLocation TEST = new ResourceLocation(Constants.MOD_ID, "textures/horse/trim/models_old/horse_armor_amethyst.png");
    public static final ResourceLocation TEST = new ResourceLocation(Constants.MOD_ID, "textures/horse/trim/models_old/horse_white_new.png");
    
    @Override
    public void onInitialize() {
        CommonClass.init();
    }
}
