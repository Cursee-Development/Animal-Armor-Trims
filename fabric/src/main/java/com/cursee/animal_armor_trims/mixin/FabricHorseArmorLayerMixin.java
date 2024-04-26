package com.cursee.animal_armor_trims.mixin;

import com.cursee.animal_armor_trims.AnimalArmorTrimsFabric;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.DataResult;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.HorseArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.RegistryOps;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Mixin(HorseArmorLayer.class)
public class FabricHorseArmorLayerMixin {
	
	@Shadow @Final private HorseModel<Horse> model;
	
	@Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At("TAIL"))
	private void injected(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Horse horse, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
		
		try (Level level = horse.level()) {
			
			ItemStack itemStack = horse.getArmor();
			
			if (itemStack.getItem() instanceof HorseArmorItem armorItem) {
				
				
				FabricHorseArmorLayerMixin.getTrim(level.registryAccess(), itemStack).ifPresent((armorTrim) -> {
					// this.renderTrim(armorItem, poseStack, multiBufferSource, horse, armorTrim);
//					this.renderTrim(armorItem, poseStack, multiBufferSource, horse, armorTrim, i, i, f, g, h, j);
					this.renderTrim(armorItem, poseStack, multiBufferSource, horse, armorTrim, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
				});
				
				
				// if (itemStack.getTag() != null && itemStack.getTag().contains("Trim")) {
				// 	CompoundTag compoundTag = itemStack.getTagElement("Trim");
				// 	DataResult<ArmorTrim> data = net.minecraft.world.item.armortrim.ArmorTrim.CODEC.parse(RegistryOps.create(NbtOps.INSTANCE, level.registryAccess()), compoundTag);
				// 	ArmorTrim trim = data.resultOrPartial((s -> {
				// 		System.out.println(s);
				// 	})).orElse((ArmorTrim) null);
				//
				//
				// }
			}
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
//		try (Level level = horse.level()) {
//
//			ItemStack itemStack = horse.getArmor();
//			if (itemStack.getItem() instanceof HorseArmorItem armorItem) {
//
//				// get the trim values by mimicking ArmorTrim.getTrim
//
//				if (itemStack.getTag() != null && itemStack.getTag().contains("Trim")) {
//					CompoundTag compoundTag = itemStack.getTagElement("Trim");
//					DataResult var10000 = net. minecraft. world. item. armortrim. ArmorTrim.CODEC.parse(RegistryOps.create(NbtOps.INSTANCE, level.registryAccess()), compoundTag);
//
//				}
//
//				// ArmorTrim.getTrim(((LivingEntity) horse).level().registryAccess(), itemStack).ifPresent((armorTrim) -> {
//				// 	this.renderTrim(armorItem, poseStack, multiBufferSource, i, armorTrim, model);
//				// });
//			}
//		}
//		catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
		
		// getTrim(horse.level().registryAccess(), horse.getArmor()).ifPresent((trim) -> {
		// 	// material of the armor (iron, gold, diamond)
		// 	// pose stack and multibuffer source,
		// 	// some int?
		// 	// the trim
		// 	//
		// 	renderTrim(poseStack, multiBufferSource, horse, trim);
		// });
		
	}
	
	private void renderTrim(HorseArmorItem armorItem, PoseStack poseStack, MultiBufferSource multiBufferSource, Horse horse, ArmorTrim armorTrim, int f, int g, float h, float j, float k, float l) {
		
		// ((HorseArmorLayer)(Object) this).getParentModel().renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.armorCutoutNoCull(armorTrim.innerTexture(ArmorMaterials.IRON))), f, g, h, j, k,l);
		
		((HorseArmorLayer)(Object) this).getParentModel().renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.armorCutoutNoCull(AnimalArmorTrimsFabric.COAST_AMETHYST)), f, g, h, j, k,l);
	}
	
	// @Unique
	// private void renderTrim(HorseArmorItem armorItem, PoseStack poseStack, MultiBufferSource multiBufferSource, Horse horse, ArmorTrim trim) {
	//
	// 	poseStack.pushPose();
	//
	// 	poseStack.popPose();
	// }
	
	
	
	// private void renderTrim(ArmorMaterial $$0, PoseStack $$1, MultiBufferSource $$2, int $$3, ArmorTrim $$4, HorseModel<Horse> $$5, boolean $$6) {
	// 	// TextureAtlasSprite $$7 = this.armorTrimAtlas.getSprite($$6 ? $$4.innerTexture($$0) : $$4.outerTexture($$0));
	// 	// TextureAtlasSprite $$7 = HumanoidArmorLayer.armorTrimAtlas .getSprite($$6 ? $$4.innerTexture($$0) : $$4.outerTexture($$0));
	//
	// 	// TextureAtlasSprite $$7 = this.armorTrimAtlas.getSprite($$6 ? $$4.innerTexture($$0) : $$4.outerTexture($$0));
	//
	// 	// TextureAtlasSprite $$7;
	// 	//
	// 	// VertexConsumer $$8 = $$7.wrap($$2.getBuffer(Sheets.armorTrimsSheet()));
	// 	// $$5.renderToBuffer($$1, $$8, $$3, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	//
	//
	// }
	
@Unique
private static Optional<ArmorTrim> getTrim(RegistryAccess registryAccess, ItemStack itemStack) {
	if (itemStack.is(ItemTags.TRIMMABLE_ARMOR) && itemStack.getTag() != null && itemStack.getTag().contains("Trim")) {
		CompoundTag compoundTag = itemStack.getTagElement("Trim");
		DataResult<ArmorTrim> var10000 = net. minecraft. world. item. armortrim. ArmorTrim.CODEC.parse(RegistryOps.create(NbtOps.INSTANCE, registryAccess), compoundTag);
		Logger var10001 = net.minecraft.world.item.armortrim.ArmorTrim.LOGGER;
		Objects.requireNonNull(var10001);
		ArmorTrim armorTrim = (ArmorTrim)var10000.resultOrPartial(var10001::error)
//		ArmorTrim armorTrim = (ArmorTrim)var10000.resultOrPartial((s) -> {
//			var10001.error(s);
//		})
			.orElse((ArmorTrim) null);
		return Optional.ofNullable(armorTrim);
	} else {
		return Optional.empty();
	}
}
	
//	@Unique
//	private void renderTrim(HorseArmorItem item, PoseStack stack, MultiBufferSource source, int i, ArmorTrim trim, HorseModel<Horse> model) {
//		// System.out.println("attempting to render: " + trim.toString());
//		// System.out.println(trim.pattern());
//		// System.out.println(trim.pattern().value().description().getString());
//
//
//
//	}
	
}
