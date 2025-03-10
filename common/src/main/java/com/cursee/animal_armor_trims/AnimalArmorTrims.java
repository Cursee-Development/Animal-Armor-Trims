package com.cursee.animal_armor_trims;

import net.minecraft.resources.ResourceLocation;

public class AnimalArmorTrims {

    public static void init() {}

    public static ResourceLocation identifier(String value) {
        return new ResourceLocation(Constants.MOD_ID, value);
    }
}