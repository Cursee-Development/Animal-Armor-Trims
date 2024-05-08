package com.cursee.animal_armor_trims.mixin;

import com.cursee.animal_armor_trims.AnimalArmorTrimsForge;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.HorseArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.DyeableHorseArmorItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HorseArmorLayer.class)
public class ForgeHALSecondMixin { //} extends RenderLayer<Horse, HorseModel<Horse>> {
	
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
	// 	// ((HorseArmorLayer)(Object) this).getParentModel().renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.armorCutoutNoCull(AnimalArmorTrimsForge.TEST)), f, g, h, j, k,l);
	//
	// 	VertexConsumer consumer = multiBufferSource.getBuffer(RenderType.armorCutoutNoCull(AnimalArmorTrimsForge.COAST_AMETHYST));
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

		ItemStack $$10 = p_117035_.getArmor();
		if ($$10.getItem() instanceof HorseArmorItem $$11) {
			// (this.getParentModel()).copyPropertiesTo(this.model); // TODO see if this is necessary
			this.model.prepareMobModel(p_117035_, p_117036_, p_117037_, p_117038_);
			this.model.setupAnim(p_117035_, p_117036_, p_117037_, p_117039_, p_117040_, p_117041_);

//			float $$16 = 1.0F;
//			float $$17 = 1.0F;
//			float $$18 = 1.0F;
			
			if ($$11 instanceof DyeableHorseArmorItem) {
				int $$12 = ((DyeableHorseArmorItem)$$11).getColor($$10);
				$$16 = (float)($$12 >> 16 & 255) / 255.0F;
				$$17 = (float)($$12 >> 8 & 255) / 255.0F;
				$$18 = (float)($$12 & 255) / 255.0F;
			}
			
			VertexConsumer $$19 = p_117033_.getBuffer(RenderType.entityCutoutNoCull($$11.getTexture()));
			((ForgeHALSecondMixin)(Object) this).model.renderToBuffer(p_117032_, $$19, p_117034_, OverlayTexture.NO_OVERLAY, $$16, $$17, $$18, 1.0F);
			
			
			if ($$10.getTag() != null && $$10.getTag().contains("Trim")) {
				
				CompoundTag compoundTag = $$10.getTagElement("Trim");
				
				if (compoundTag != null) {
					
					String material = compoundTag.getString("material");
					
					String pattern = compoundTag.getString("pattern");
					
					VertexConsumer $$20;
					
					switch (material) {
						case "minecraft:amethyst" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_AMETHYST));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_AMETHYST));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_AMETHYST));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_AMETHYST));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_AMETHYST));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_AMETHYST));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_AMETHYST));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_AMETHYST));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_AMETHYST));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_AMETHYST));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_AMETHYST));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_AMETHYST));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_AMETHYST));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_AMETHYST));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_AMETHYST));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_AMETHYST));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:copper" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_COPPER));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_COPPER));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_COPPER));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_COPPER));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_COPPER));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_COPPER));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_COPPER));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_COPPER));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_COPPER));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_COPPER));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_COPPER));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_COPPER));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_COPPER));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_COPPER));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_COPPER));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_COPPER));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:diamond" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_DIAMOND));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_DIAMOND));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_DIAMOND));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_DIAMOND));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_DIAMOND));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_DIAMOND));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_DIAMOND));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_DIAMOND));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_DIAMOND));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_DIAMOND));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_DIAMOND));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_DIAMOND));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_DIAMOND));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_DIAMOND));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_DIAMOND));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_DIAMOND));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:emerald" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_EMERALD));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_EMERALD));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_EMERALD));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_EMERALD));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_EMERALD));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_EMERALD));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_EMERALD));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_EMERALD));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_EMERALD));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_EMERALD));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_EMERALD));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_EMERALD));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_EMERALD));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_EMERALD));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_EMERALD));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_EMERALD));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:gold" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_GOLD));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_GOLD));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_GOLD));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_GOLD));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_GOLD));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_GOLD));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_GOLD));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_GOLD));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_GOLD));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_GOLD));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_GOLD));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_GOLD));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_GOLD));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_GOLD));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_GOLD));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_GOLD));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:iron" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_IRON));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_IRON));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_IRON));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_IRON));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_IRON));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_IRON));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_IRON));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_IRON));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_IRON));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_IRON));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_IRON));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_IRON));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_IRON));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_IRON));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_IRON));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_IRON));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:lapis" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_LAPIS));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_LAPIS));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_LAPIS));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_LAPIS));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_LAPIS));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_LAPIS));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_LAPIS));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_LAPIS));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_LAPIS));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_LAPIS));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_LAPIS));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_LAPIS));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_LAPIS));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_LAPIS));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_LAPIS));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_LAPIS));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:netherite" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_NETHERITE));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_NETHERITE));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_NETHERITE));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_NETHERITE));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_NETHERITE));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_NETHERITE));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_NETHERITE));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_NETHERITE));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_NETHERITE));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_NETHERITE));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_NETHERITE));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_NETHERITE));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_NETHERITE));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_NETHERITE));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_NETHERITE));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_NETHERITE));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:quartz" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_QUARTZ));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_QUARTZ));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_QUARTZ));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_QUARTZ));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_QUARTZ));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_QUARTZ));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_QUARTZ));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_QUARTZ));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_QUARTZ));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_QUARTZ));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_QUARTZ));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_QUARTZ));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_QUARTZ));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_QUARTZ));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_QUARTZ));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_QUARTZ));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						case "minecraft:redstone" -> {
							switch (pattern) {
								case "minecraft:coast" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_REDSTONE));
								case "minecraft:dune" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_REDSTONE));
								case "minecraft:eye" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_REDSTONE));
								case "minecraft:host" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_REDSTONE));
								case "minecraft:raiser" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_REDSTONE));
								case "minecraft:rib" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_REDSTONE));
								case "minecraft:sentry" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_REDSTONE));
								case "minecraft:shaper" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_REDSTONE));
								case "minecraft:silence" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_REDSTONE));
								case "minecraft:snout" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_REDSTONE));
								case "minecraft:spire" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_REDSTONE));
								case "minecraft:tide" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_REDSTONE));
								case "minecraft:vex" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_REDSTONE));
								case "minecraft:ward" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_REDSTONE));
								case "minecraft:wayfinder" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_REDSTONE));
								case "minecraft:wild" ->
									$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_REDSTONE));
								default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
							}
						}
						default -> {
							$$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
						}
					}
					
					// switch (pattern) {
					// 	case "minecraft:coast" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST_AMETHYST));
					// 	case "minecraft:dune" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.DUNE_AMETHYST));
					// 	case "minecraft:eye" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.EYE_AMETHYST));
					// 	case "minecraft:host" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.HOST_AMETHYST));
					// 	case "minecraft:raiser" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RAISER_AMETHYST));
					// 	case "minecraft:rib" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.RIB_AMETHYST));
					// 	case "minecraft:sentry" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SENTRY_AMETHYST));
					// 	case "minecraft:shaper" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SHAPER_AMETHYST));
					// 	case "minecraft:silence" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SILENCE_AMETHYST));
					// 	case "minecraft:snout" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SNOUT_AMETHYST));
					// 	case "minecraft:spire" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.SPIRE_AMETHYST));
					// 	case "minecraft:tide" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TIDE_AMETHYST));
					// 	case "minecraft:vex" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.VEX_AMETHYST));
					// 	case "minecraft:ward" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WARD_AMETHYST));
					// 	case "minecraft:wayfinder" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WAYFINDER_AMETHYST));
					// 	case "minecraft:wild" -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.WILD_AMETHYST));
					// 	default -> $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.BLANK));
					// }
					
					// VertexConsumer $$20 = p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.COAST));
					
					
					
					this.model.renderToBuffer(p_117032_, $$20, p_117034_, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0F);
					// this.model.renderToBuffer(p_117032_, p_117033_.getBuffer(RenderType.entityCutoutNoCull(AnimalArmorTrimsForge.TEST)), p_117034_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
				}
			}
			
		}
	}
}
