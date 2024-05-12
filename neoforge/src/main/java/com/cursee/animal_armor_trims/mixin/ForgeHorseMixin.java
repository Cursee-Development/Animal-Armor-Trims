package com.cursee.animal_armor_trims.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Horse.class)
public class ForgeHorseMixin {
	
	@Inject(method = "mobInteract", at = @At("HEAD"))
	private void injected(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
		
		// Horse horse = ((Horse) (Object) this);
		
		if ( !((Horse) (Object) this).isTamed() & !((Horse) (Object) this).isVehicle() & !((Horse) (Object) this).isBaby() & player.isCreative()) {
			
			((Horse) (Object) this).tameWithName(player);
			
		}
	}
}
