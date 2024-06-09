package com.cursee.animal_armor_trims.mixin;

import com.cursee.animal_armor_trims.AnimalArmorTrimsForge;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.WolfModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.WolfArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.component.DyedItemColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WolfArmorLayer.class)
public class ForgeWolfArmorLayerMixin {



//	@Shadow @Final private HorseModel<Horse> model;

	@Shadow @Final private WolfModel<Wolf> model;

	// @Inject(at = @At("RETURN"), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V")
	@Inject(at = @At("RETURN"), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/Wolf;FFFFFF)V")
	private void inject(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Wolf wolf, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
		PoseStack p_117032_ = poseStack;
		MultiBufferSource p_117033_ = multiBufferSource;
		int p_117034_ = i;
		Wolf p_117035_ = wolf;
		float p_117036_ = f;
		float p_117037_ = g;
		float p_117038_ = h;
		float p_117039_ = j;
		float p_117040_ = k;
		float p_117041_ = l;

		float $$16 = 1.0F;
		float $$17 = 1.0F;
		float $$18 = 1.0F;

		ItemStack $$10 = wolf.getBodyArmorItem();
		if ($$10.getItem() instanceof AnimalArmorItem $$11) {
			this.model.prepareMobModel(p_117035_, p_117036_, p_117037_, p_117038_);
			this.model.setupAnim(p_117035_, p_117036_, p_117037_, p_117039_, p_117040_, p_117041_);

			if ($$11 instanceof AnimalArmorItem && $$11.getMaterial() == ArmorMaterials.LEATHER && $$10.is(ItemTags.DYEABLE)) {
				int $$12 = DyedItemColor.getOrDefault($$10, -6265536);
				$$16 = (float)($$12 >> 16 & 255) / 255.0F;
				$$17 = (float)($$12 >> 8 & 255) / 255.0F;
				$$18 = (float)($$12 & 255) / 255.0F;
			}

			VertexConsumer $$19 = p_117033_.getBuffer(RenderType.entityCutoutNoCull($$11.getTexture()));
			((ForgeWolfArmorLayerMixin)(Object) this).model.renderToBuffer(p_117032_, $$19, p_117034_, OverlayTexture.NO_OVERLAY, $$16, $$17, $$18, 1.0F);

			if ($$10.getComponents().has(DataComponents.TRIM)) {

				DataComponentMap components = $$10.getComponents();

				ArmorTrim trim = components.get(DataComponents.TRIM);


				if (trim != null) {


					TrimMaterial trimMaterial = trim.material().value();
					TrimPattern trimPattern = trim.pattern().value();

					// String material = trimMaterial.toString().toLowerCase();
					// String pattern = trimPattern.toString().toLowerCase();

					String material = "minecraft:"+trimMaterial.assetName();
					String pattern = trimPattern.assetId().toString();

					// System.out.println(material + Character.SPACE_SEPARATOR + pattern);
					// trimmaterial[assetname=amethyst, ingredient=reference{resourcekey[minecraft:item / minecraft:amethyst_shard]=amethyst_shard}, itemmodelindex=1.0, overridearmormaterials={}, description=translation{key='trim_material.minecraft.amethyst', args=[]}[style={color=#9a5cc6}]]
					//
					// trimpattern[assetid=minecraft:ward, templateitem=reference{resourcekey[minecraft:item / minecraft:ward_armor_trim_smithing_template]=ward_armor_trim_smithing_template}, description=translation{key='trim_pattern.minecraft.ward', args=[]}, decal=false]

					VertexConsumer $$20;

					switch (material) {
						case "minecraft:amethyst" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_AMETHYST));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_AMETHYST));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_AMETHYST));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_AMETHYST));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_AMETHYST));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_AMETHYST));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_AMETHYST));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_AMETHYST));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_AMETHYST));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_AMETHYST));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_AMETHYST));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_AMETHYST));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_AMETHYST));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_AMETHYST));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_AMETHYST));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_AMETHYST));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:copper" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_COPPER));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_COPPER));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_COPPER));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_COPPER));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_COPPER));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_COPPER));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_COPPER));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_COPPER));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_COPPER));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_COPPER));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_COPPER));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_COPPER));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_COPPER));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_COPPER));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_COPPER));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_COPPER));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:diamond" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_DIAMOND));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_DIAMOND));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_DIAMOND));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_DIAMOND));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_DIAMOND));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_DIAMOND));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_DIAMOND));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_DIAMOND));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_DIAMOND));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_DIAMOND));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_DIAMOND));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_DIAMOND));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_DIAMOND));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_DIAMOND));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_DIAMOND));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_DIAMOND));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:emerald" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_EMERALD));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_EMERALD));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_EMERALD));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_EMERALD));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_EMERALD));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_EMERALD));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_EMERALD));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_EMERALD));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_EMERALD));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_EMERALD));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_EMERALD));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_EMERALD));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_EMERALD));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_EMERALD));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_EMERALD));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_EMERALD));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:gold" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_GOLD));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_GOLD));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_GOLD));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_GOLD));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_GOLD));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_GOLD));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_GOLD));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_GOLD));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_GOLD));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_GOLD));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_GOLD));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_GOLD));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_GOLD));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_GOLD));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_GOLD));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_GOLD));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:iron" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_IRON));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_IRON));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_IRON));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_IRON));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_IRON));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_IRON));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_IRON));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_IRON));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_IRON));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_IRON));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_IRON));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_IRON));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_IRON));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_IRON));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_IRON));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_IRON));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:lapis" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_LAPIS));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_LAPIS));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_LAPIS));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_LAPIS));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_LAPIS));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_LAPIS));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_LAPIS));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_LAPIS));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_LAPIS));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_LAPIS));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_LAPIS));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_LAPIS));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_LAPIS));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_LAPIS));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_LAPIS));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_LAPIS));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:netherite" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_NETHERITE));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_NETHERITE));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_NETHERITE));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_NETHERITE));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_NETHERITE));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_NETHERITE));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_NETHERITE));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_NETHERITE));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_NETHERITE));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_NETHERITE));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_NETHERITE));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_NETHERITE));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_NETHERITE));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_NETHERITE));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_NETHERITE));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_NETHERITE));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:quartz" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_QUARTZ));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_QUARTZ));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_QUARTZ));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_QUARTZ));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_QUARTZ));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_QUARTZ));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_QUARTZ));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_QUARTZ));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_QUARTZ));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_QUARTZ));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_QUARTZ));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_QUARTZ));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_QUARTZ));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_QUARTZ));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_QUARTZ));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_QUARTZ));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						case "minecraft:redstone" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_REDSTONE));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_REDSTONE));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_REDSTONE));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_REDSTONE));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_REDSTONE));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_REDSTONE));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_REDSTONE));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_REDSTONE));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_REDSTONE));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_REDSTONE));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_REDSTONE));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_REDSTONE));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_REDSTONE));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_REDSTONE));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_REDSTONE));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_REDSTONE));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
							}
						}
						default -> {
							$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
						}
					}

					// switch (pattern) {
					// 	case "minecraft:coast" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_AMETHYST));
					// 	case "minecraft:dune" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_AMETHYST));
					// 	case "minecraft:eye" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_AMETHYST));
					// 	case "minecraft:host" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_AMETHYST));
					// 	case "minecraft:raiser" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_AMETHYST));
					// 	case "minecraft:rib" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_AMETHYST));
					// 	case "minecraft:sentry" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_AMETHYST));
					// 	case "minecraft:shaper" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_AMETHYST));
					// 	case "minecraft:silence" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_AMETHYST));
					// 	case "minecraft:snout" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_AMETHYST));
					// 	case "minecraft:spire" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_AMETHYST));
					// 	case "minecraft:tide" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_AMETHYST));
					// 	case "minecraft:vex" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_AMETHYST));
					// 	case "minecraft:ward" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_AMETHYST));
					// 	case "minecraft:wayfinder" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_AMETHYST));
					// 	case "minecraft:wild" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_AMETHYST));
					// 	default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
					// }

					// VertexConsumer $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST));



					this.model.renderToBuffer(p_117032_, $$20, p_117034_, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0F);
					// this.model.renderToBuffer(p_117032_, p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TEST)), p_117034_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
				}
			}

		}
	}

//	@Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At("RETURN"))
//	private void inject(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Horse horse, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
//
//		PoseStack p_117032_ = poseStack;
//		MultiBufferSource p_117033_ = multiBufferSource;
//		int p_117034_ = i;
//		Horse p_117035_ = horse;
//		float p_117036_ = f;
//		float p_117037_ = g;
//		float p_117038_ = h;
//		float p_117039_ = j;
//		float p_117040_ = k;
//		float p_117041_ = l;
//
//		float $$16 = 1.0F;
//		float $$17 = 1.0F;
//		float $$18 = 1.0F;
//
//		ItemStack $$10 = horse.getBodyArmorItem();
//		if ($$10.getItem() instanceof AnimalArmorItem $$11) {
//			this.model.prepareMobModel(p_117035_, p_117036_, p_117037_, p_117038_);
//			this.model.setupAnim(p_117035_, p_117036_, p_117037_, p_117039_, p_117040_, p_117041_);
//
//			if ($$11 instanceof AnimalArmorItem && $$11.getMaterial() == ArmorMaterials.LEATHER && $$10.is(ItemTags.DYEABLE)) {
//				int $$12 = DyedItemColor.getOrDefault($$10, -6265536);
//				$$16 = (float)($$12 >> 16 & 255) / 255.0F;
//				$$17 = (float)($$12 >> 8 & 255) / 255.0F;
//				$$18 = (float)($$12 & 255) / 255.0F;
//			}
//
//			VertexConsumer $$19 = p_117033_.getBuffer(RenderType.entityCutoutNoCull($$11.getTexture()));
//			((FabricHorseArmorLayerMixin)(Object) this).model.renderToBuffer(p_117032_, $$19, p_117034_, OverlayTexture.NO_OVERLAY, $$16, $$17, $$18, 1.0F);
//
//			if ($$10.getComponents().has(DataComponents.TRIM)) {
//
//				DataComponentMap components = $$10.getComponents();
//
//				ArmorTrim trim = components.get(DataComponents.TRIM);
//
//
//				if (trim != null) {
//
//
//					TrimMaterial trimMaterial = trim.material().value();
//					TrimPattern trimPattern = trim.pattern().value();
//
//					// String material = trimMaterial.toString().toLowerCase();
//					// String pattern = trimPattern.toString().toLowerCase();
//
//					String material = "minecraft:"+trimMaterial.assetName();
//					String pattern = trimPattern.assetId().toString();
//
//					// System.out.println(material + Character.SPACE_SEPARATOR + pattern);
//					// trimmaterial[assetname=amethyst, ingredient=reference{resourcekey[minecraft:item / minecraft:amethyst_shard]=amethyst_shard}, itemmodelindex=1.0, overridearmormaterials={}, description=translation{key='trim_material.minecraft.amethyst', args=[]}[style={color=#9a5cc6}]]
//					//
//					// trimpattern[assetid=minecraft:ward, templateitem=reference{resourcekey[minecraft:item / minecraft:ward_armor_trim_smithing_template]=ward_armor_trim_smithing_template}, description=translation{key='trim_pattern.minecraft.ward', args=[]}, decal=false]
//
//					VertexConsumer $$20;
//
//					switch (material) {
//						case "minecraft:amethyst" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_AMETHYST));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_AMETHYST));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_AMETHYST));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_AMETHYST));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_AMETHYST));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_AMETHYST));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_AMETHYST));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_AMETHYST));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_AMETHYST));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_AMETHYST));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_AMETHYST));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_AMETHYST));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_AMETHYST));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_AMETHYST));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_AMETHYST));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_AMETHYST));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:copper" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_COPPER));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_COPPER));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_COPPER));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_COPPER));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_COPPER));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_COPPER));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_COPPER));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_COPPER));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_COPPER));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_COPPER));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_COPPER));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_COPPER));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_COPPER));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_COPPER));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_COPPER));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_COPPER));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:diamond" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_DIAMOND));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_DIAMOND));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_DIAMOND));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_DIAMOND));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_DIAMOND));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_DIAMOND));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_DIAMOND));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_DIAMOND));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_DIAMOND));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_DIAMOND));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_DIAMOND));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_DIAMOND));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_DIAMOND));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_DIAMOND));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_DIAMOND));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_DIAMOND));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:emerald" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_EMERALD));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_EMERALD));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_EMERALD));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_EMERALD));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_EMERALD));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_EMERALD));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_EMERALD));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_EMERALD));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_EMERALD));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_EMERALD));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_EMERALD));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_EMERALD));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_EMERALD));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_EMERALD));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_EMERALD));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_EMERALD));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:gold" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_GOLD));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_GOLD));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_GOLD));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_GOLD));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_GOLD));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_GOLD));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_GOLD));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_GOLD));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_GOLD));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_GOLD));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_GOLD));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_GOLD));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_GOLD));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_GOLD));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_GOLD));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_GOLD));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:iron" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_IRON));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_IRON));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_IRON));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_IRON));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_IRON));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_IRON));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_IRON));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_IRON));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_IRON));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_IRON));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_IRON));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_IRON));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_IRON));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_IRON));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_IRON));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_IRON));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:lapis" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_LAPIS));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_LAPIS));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_LAPIS));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_LAPIS));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_LAPIS));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_LAPIS));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_LAPIS));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_LAPIS));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_LAPIS));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_LAPIS));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_LAPIS));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_LAPIS));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_LAPIS));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_LAPIS));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_LAPIS));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_LAPIS));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:netherite" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_NETHERITE));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_NETHERITE));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_NETHERITE));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_NETHERITE));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_NETHERITE));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_NETHERITE));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_NETHERITE));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_NETHERITE));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_NETHERITE));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_NETHERITE));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_NETHERITE));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_NETHERITE));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_NETHERITE));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_NETHERITE));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_NETHERITE));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_NETHERITE));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:quartz" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_QUARTZ));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_QUARTZ));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_QUARTZ));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_QUARTZ));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_QUARTZ));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_QUARTZ));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_QUARTZ));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_QUARTZ));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_QUARTZ));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_QUARTZ));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_QUARTZ));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_QUARTZ));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_QUARTZ));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_QUARTZ));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_QUARTZ));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_QUARTZ));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						case "minecraft:redstone" -> {
//							switch (pattern) {
//								case "minecraft:coast" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_REDSTONE));
//								case "minecraft:dune" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_REDSTONE));
//								case "minecraft:eye" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_REDSTONE));
//								case "minecraft:host" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_REDSTONE));
//								case "minecraft:raiser" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_REDSTONE));
//								case "minecraft:rib" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_REDSTONE));
//								case "minecraft:sentry" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_REDSTONE));
//								case "minecraft:shaper" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_REDSTONE));
//								case "minecraft:silence" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_REDSTONE));
//								case "minecraft:snout" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_REDSTONE));
//								case "minecraft:spire" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_REDSTONE));
//								case "minecraft:tide" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_REDSTONE));
//								case "minecraft:vex" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_REDSTONE));
//								case "minecraft:ward" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_REDSTONE));
//								case "minecraft:wayfinder" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_REDSTONE));
//								case "minecraft:wild" ->
//									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_REDSTONE));
//								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//							}
//						}
//						default -> {
//							$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//						}
//					}
//
//					// switch (pattern) {
//					// 	case "minecraft:coast" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST_AMETHYST));
//					// 	case "minecraft:dune" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_DUNE_AMETHYST));
//					// 	case "minecraft:eye" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_EYE_AMETHYST));
//					// 	case "minecraft:host" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_HOST_AMETHYST));
//					// 	case "minecraft:raiser" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RAISER_AMETHYST));
//					// 	case "minecraft:rib" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_RIB_AMETHYST));
//					// 	case "minecraft:sentry" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SENTRY_AMETHYST));
//					// 	case "minecraft:shaper" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SHAPER_AMETHYST));
//					// 	case "minecraft:silence" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SILENCE_AMETHYST));
//					// 	case "minecraft:snout" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SNOUT_AMETHYST));
//					// 	case "minecraft:spire" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_SPIRE_AMETHYST));
//					// 	case "minecraft:tide" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TIDE_AMETHYST));
//					// 	case "minecraft:vex" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_VEX_AMETHYST));
//					// 	case "minecraft:ward" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WARD_AMETHYST));
//					// 	case "minecraft:wayfinder" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WAYFINDER_AMETHYST));
//					// 	case "minecraft:wild" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_WILD_AMETHYST));
//					// 	default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_BLANK));
//					// }
//
//					// VertexConsumer $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_COAST));
//
//
//
//					this.model.renderToBuffer(p_117032_, $$20, p_117034_, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0F);
//					// this.model.renderToBuffer(p_117032_, p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WOLF_TEST)), p_117034_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
//				}
//			}
//
//		}
//	}
}
