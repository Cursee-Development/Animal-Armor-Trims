package com.cursee.animal_armor_trims.mixin;

import com.cursee.animal_armor_trims.AnimalArmorTrimsFabric;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HorseArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.animal.horse.Horse;

//import net.minecraft.world.item.DyeableHorseArmorItem;
//import net.minecraft.world.item.HorseArmorItem;

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
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HorseArmorLayer.class)
public class FabricHALSecondMixin { //} extends RenderLayer<Horse, HorseModel<Horse>> {
	
	// @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At("TAIL"))
	// public void render(PoseStack p_117032_, MultiBufferSource p_117033_, int p_117034_, Horse p_117035_, float p_117036_, float p_117037_, float p_117038_, float p_117039_, float p_117040_, float p_117041_, CallbackInfo ci) {
	// 	ItemStack $$10 = p_117035_.getArmor();
	// 	if ($$10.getItem() instanceof HorseArmorItem) {
	// 		HorseArmorItem $$11 = (HorseArmorItem)$$10.getItem();
	// 		(( ()() (HorseModel)this).getParentModel()).copyPropertiesTo(this.model);
	// 		this.model.prepareMobModel(p_117035_, p_117036_, p_117037_, p_117038_);
	// 		this.model.setupAnim(p_117035_, p_117036_, p_117037_, p_117039_, p_117040_, p_117041_);
	// 		float $$16;
	// 		float $$17;
	// 		float $$18;
	// 		if ($$11 instanceof DyeableHorseArmorItem) {
	// 			int $$12 = ((DyeableHorseArmorItem)$$11).getColor($$10);
	// 			$$16 = (float)($$12 >> 16 & 255) / 255.0F;
	// 			$$17 = (float)($$12 >> 8 & 255) / 255.0F;
	// 			$$18 = (float)($$12 & 255) / 255.0F;
	// 		} else {
	// 			$$16 = 1.0F;
	// 			$$17 = 1.0F;
	// 			$$18 = 1.0F;
	// 		}
	//
	// 		VertexConsumer $$19 = p_117033_.getBuffer(RenderType.entityCutoutNoCull($$11.getTexture()));
	// 		this.model.renderToBuffer(p_117032_, $$19, p_117034_, OverlayTexture.NO_OVERLAY, $$16, $$17, $$18, 1.0F);
	// 	}
	// }
	
	// @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At("TAIL"))
	// private void injected(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Horse horse, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
	// 	try (Level level = horse.level()) {
	//
	// 		ItemStack itemStack = horse.getArmor();
	//
	// 		if (itemStack.getItem() instanceof HorseArmorItem armorItem) {
	//
	//
	// 			FabricHALMixin.getTrim(level.registryAccess(), itemStack).ifPresent((armorTrim) -> {
	// 				this.renderTrim(armorItem, poseStack, multiBufferSource, horse, armorTrim, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	// 			});
	//
	// 		}
	//
	// 	}
	// 	catch (IOException e) {
	// 		System.out.println(e.getMessage());
	// 	}
	// }
	
//	@Unique
//	private static Optional<ArmorTrim> getTrim(RegistryAccess registryAccess, ItemStack itemStack) {
//		if (itemStack.is(ItemTags.TRIMMABLE_ARMOR) && itemStack.getTag() != null && itemStack.getTag().contains("Trim")) {
//			CompoundTag compoundTag = itemStack.getTagElement("Trim");
//			DataResult<ArmorTrim> var10000 = net. minecraft. world. item. armortrim. ArmorTrim.CODEC.parse(RegistryOps.create(NbtOps.INSTANCE, registryAccess), compoundTag);
//			Logger var10001 = net.minecraft.world.item.armortrim.ArmorTrim.LOGGER;
//			Objects.requireNonNull(var10001);
//			ArmorTrim armorTrim = (ArmorTrim)var10000.resultOrPartial(var10001::error)
////		ArmorTrim armorTrim = (ArmorTrim)var10000.resultOrPartial((s) -> {
////			var10001.error(s);
////		})
//				.orElse((ArmorTrim) null);
//			return Optional.ofNullable(armorTrim);
//		} else {
//			return Optional.empty();
//		}
//	}
	
	// @Unique
	// private void renderTrim(HorseArmorItem armorItem, PoseStack poseStack, MultiBufferSource multiBufferSource, Horse horse, ArmorTrim armorTrim, int f, int g, float h, float j, float k, float l) {
	//
	// 	// ((HorseArmorLayer)(Object) this).getParentModel().renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.armorCutoutNoCull(AnimalArmorTrimsFabric.TEST)), f, g, h, j, k,l);
	//
	// 	VertexConsumer consumer = multiBufferSource.getBuffer(RenderType.armorCutoutNoCull(AnimalArmorTrimsFabric.COAST_AMETHYST));
	//
	// 	((HorseArmorLayer)(Object) this).getParentModel().renderToBuffer(poseStack, consumer, f, g, h, j, k,l);
	// }


	@Shadow @Final private HorseModel<Horse> model;

	// TODO: figure out how the fuck this was working????
	// @Override
	@Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At("RETURN"))
	// public void render(@NotNull PoseStack p_117032_, @NotNull MultiBufferSource p_117033_, int p_117034_, @NotNull Horse p_117035_, float p_117036_, float p_117037_, float p_117038_, float p_117039_, float p_117040_, float p_117041_) {
	private void inject(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Horse horse, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {

		PoseStack p_117032_ = poseStack;
		MultiBufferSource p_117033_ = multiBufferSource;
		int p_117034_ = i;
		Horse p_117035_ = horse;
		float p_117036_ = f;
		float p_117037_ = g;
		float p_117038_ = h;
		float p_117039_ = j;
		float p_117040_ = k;
		float p_117041_ = l;

		float $$16 = 1.0F;
		float $$17 = 1.0F;
		float $$18 = 1.0F;

//		ItemStack $$10 = p_117035_.getArmor();
		ItemStack $$10 = horse.getBodyArmorItem();
		if ($$10.getItem() instanceof AnimalArmorItem $$11) {
			// (this.getParentModel()).copyPropertiesTo(this.model); // TODO see if this is necessary
			this.model.prepareMobModel(p_117035_, p_117036_, p_117037_, p_117038_);
			this.model.setupAnim(p_117035_, p_117036_, p_117037_, p_117039_, p_117040_, p_117041_);

//			float $$16 = 1.0F;
//			float $$17 = 1.0F;
//			float $$18 = 1.0F;
			
			if ($$11 instanceof AnimalArmorItem && $$11.getMaterial() == ArmorMaterials.LEATHER && $$10.is(ItemTags.DYEABLE)) {
				int $$12 = DyedItemColor.getOrDefault($$10, -6265536);
				$$16 = (float)($$12 >> 16 & 255) / 255.0F;
				$$17 = (float)($$12 >> 8 & 255) / 255.0F;
				$$18 = (float)($$12 & 255) / 255.0F;
			}
			
			VertexConsumer $$19 = p_117033_.getBuffer(RenderType.entityCutoutNoCull($$11.getTexture()));
			((FabricHALSecondMixin)(Object) this).model.renderToBuffer(p_117032_, $$19, p_117034_, OverlayTexture.NO_OVERLAY, $$16, $$17, $$18, 1.0F);
			
			
//			if ($$10.getTag() != null && $$10.getTag().contains("Trim")) {
			if ($$10.getComponents().has(DataComponents.TRIM)) {

//				CompoundTag compoundTag = $$10.getTagElement("Trim");

				DataComponentMap components = $$10.getComponents();

				ArmorTrim trim = components.get(DataComponents.TRIM);

				
				if (trim != null) {


					TrimMaterial trimMaterial = trim.material().value();
					TrimPattern trimPattern = trim.pattern().value();
					
//					String material = compoundTag.getString("material");
//					String pattern = compoundTag.getString("pattern");
					String material = trimMaterial.toString().toLowerCase();
					String pattern = trimPattern.toString().toLowerCase();
					
					VertexConsumer $$20;
					
					switch (material) {
						case "minecraft:amethyst" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_AMETHYST));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_AMETHYST));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_AMETHYST));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_AMETHYST));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_AMETHYST));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_AMETHYST));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_AMETHYST));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_AMETHYST));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_AMETHYST));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_AMETHYST));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_AMETHYST));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_AMETHYST));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_AMETHYST));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_AMETHYST));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_AMETHYST));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_AMETHYST));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:copper" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_COPPER));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_COPPER));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_COPPER));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_COPPER));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_COPPER));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_COPPER));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_COPPER));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_COPPER));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_COPPER));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_COPPER));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_COPPER));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_COPPER));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_COPPER));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_COPPER));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_COPPER));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_COPPER));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:diamond" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_DIAMOND));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_DIAMOND));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_DIAMOND));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_DIAMOND));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_DIAMOND));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_DIAMOND));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_DIAMOND));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_DIAMOND));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_DIAMOND));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_DIAMOND));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_DIAMOND));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_DIAMOND));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_DIAMOND));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_DIAMOND));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_DIAMOND));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_DIAMOND));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:emerald" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_EMERALD));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_EMERALD));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_EMERALD));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_EMERALD));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_EMERALD));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_EMERALD));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_EMERALD));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_EMERALD));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_EMERALD));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_EMERALD));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_EMERALD));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_EMERALD));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_EMERALD));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_EMERALD));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_EMERALD));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_EMERALD));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:gold" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_GOLD));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_GOLD));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_GOLD));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_GOLD));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_GOLD));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_GOLD));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_GOLD));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_GOLD));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_GOLD));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_GOLD));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_GOLD));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_GOLD));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_GOLD));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_GOLD));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_GOLD));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_GOLD));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:iron" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_IRON));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_IRON));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_IRON));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_IRON));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_IRON));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_IRON));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_IRON));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_IRON));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_IRON));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_IRON));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_IRON));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_IRON));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_IRON));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_IRON));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_IRON));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_IRON));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:lapis" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_LAPIS));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_LAPIS));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_LAPIS));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_LAPIS));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_LAPIS));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_LAPIS));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_LAPIS));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_LAPIS));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_LAPIS));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_LAPIS));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_LAPIS));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_LAPIS));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_LAPIS));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_LAPIS));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_LAPIS));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_LAPIS));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:netherite" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_NETHERITE));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_NETHERITE));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_NETHERITE));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_NETHERITE));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_NETHERITE));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_NETHERITE));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_NETHERITE));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_NETHERITE));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_NETHERITE));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_NETHERITE));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_NETHERITE));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_NETHERITE));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_NETHERITE));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_NETHERITE));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_NETHERITE));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_NETHERITE));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:quartz" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_QUARTZ));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_QUARTZ));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_QUARTZ));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_QUARTZ));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_QUARTZ));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_QUARTZ));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_QUARTZ));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_QUARTZ));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_QUARTZ));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_QUARTZ));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_QUARTZ));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_QUARTZ));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_QUARTZ));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_QUARTZ));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_QUARTZ));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_QUARTZ));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						case "minecraft:redstone" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_REDSTONE));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_REDSTONE));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_REDSTONE));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_REDSTONE));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_REDSTONE));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_REDSTONE));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_REDSTONE));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_REDSTONE));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_REDSTONE));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_REDSTONE));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_REDSTONE));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_REDSTONE));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_REDSTONE));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_REDSTONE));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_REDSTONE));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_REDSTONE));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
							}
						}
						default -> {
							$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
						}
					}
					
					// switch (pattern) {
					// 	case "minecraft:coast" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST_AMETHYST));
					// 	case "minecraft:dune" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.DUNE_AMETHYST));
					// 	case "minecraft:eye" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.EYE_AMETHYST));
					// 	case "minecraft:host" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.HOST_AMETHYST));
					// 	case "minecraft:raiser" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RAISER_AMETHYST));
					// 	case "minecraft:rib" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.RIB_AMETHYST));
					// 	case "minecraft:sentry" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SENTRY_AMETHYST));
					// 	case "minecraft:shaper" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SHAPER_AMETHYST));
					// 	case "minecraft:silence" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SILENCE_AMETHYST));
					// 	case "minecraft:snout" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SNOUT_AMETHYST));
					// 	case "minecraft:spire" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.SPIRE_AMETHYST));
					// 	case "minecraft:tide" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TIDE_AMETHYST));
					// 	case "minecraft:vex" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.VEX_AMETHYST));
					// 	case "minecraft:ward" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WARD_AMETHYST));
					// 	case "minecraft:wayfinder" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WAYFINDER_AMETHYST));
					// 	case "minecraft:wild" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.WILD_AMETHYST));
					// 	default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.BLANK));
					// }
					
					// VertexConsumer $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.COAST));
					
					
					
					this.model.renderToBuffer(p_117032_, $$20, p_117034_, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0F);
					// this.model.renderToBuffer(p_117032_, p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsFabric.TEST)), p_117034_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
				}
			}
			
		}
	}
}
