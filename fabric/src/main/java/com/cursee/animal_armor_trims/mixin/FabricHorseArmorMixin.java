package com.cursee.animal_armor_trims.mixin;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HorseRenderer.class)
public class FabricHorseArmorMixin {
	
	@Inject(method="<init>", at = @At("TAIL"))
	private void injected(EntityRendererProvider.Context context, CallbackInfo ci) {
	
	}
}
