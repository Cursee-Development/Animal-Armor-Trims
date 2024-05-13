package com.cursee.animal_armor_trims.platform.services;

public interface IPlatformHelper {

    String getModLoaderName();

    String getGameDirectory();

    boolean isModLoaded(String modId);

    boolean isDevelopmentEnvironment();

    boolean isClientSide();
}