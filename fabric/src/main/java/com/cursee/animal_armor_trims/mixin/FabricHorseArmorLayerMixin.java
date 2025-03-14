package com.cursee.animal_armor_trims.mixin;

import com.cursee.animal_armor_trims.core.util.HorseRenderLayerHelper;
import com.cursee.animal_armor_trims.platform.Services;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.HorseArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HorseArmorLayer.class)
public class FabricHorseArmorLayerMixin {

    @Shadow @Final private HorseModel<Horse> model;

    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/HorseModel;renderToBuffer(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;IIFFFF)V"))
    private void animalArmorTrims$onRenderHorseArmorLayer(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Horse horse, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {

        ItemStack armor = horse.getArmor();
        if (!(armor.getItem() instanceof HorseArmorItem horseArmor)) return;

        // re-draw the base armor if rendering isn't fixed by ImmediatelyFast
        if (!Services.PLATFORM.isModLoaded("immediatelyfast")) {
            this.model.prepareMobModel(horse, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(horse, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

            float r = 1, g = 1, b = 1;
            if (horseArmor instanceof DyeableHorseArmorItem dyeableHorseArmor) {
                int i = dyeableHorseArmor.getColor(armor);
                r = (float)(i >> 16 & 255) / 255.0F;
                g = (float)(i >> 8 & 255) / 255.0F;
                b = (float)(i & 255) / 255.0F;
            }

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(horseArmor.getTexture()));
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, r, g, b, 1.0F);
        }

        if (!Services.PLATFORM.isModLoaded("immediatelyfast")) poseStack.pushPose();

        if (armor.getTag() == null || !armor.getTag().contains("Trim")) return;

        CompoundTag trim = armor.getTagElement("Trim");

        if (trim == null) return;

        VertexConsumer vertexConsumer = HorseRenderLayerHelper.createVertexConsumer(trim, buffer);

        // poseStack.scale(1.01f, 1.01f, 1.01f);
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

        if (!Services.PLATFORM.isModLoaded("immediatelyfast")) poseStack.popPose();
    }
}
