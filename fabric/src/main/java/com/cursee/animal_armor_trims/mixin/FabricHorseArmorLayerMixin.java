package com.cursee.animal_armor_trims.mixin;

import com.cursee.animal_armor_trims.core.util.HorseRenderLayerHelper;
import com.cursee.animal_armor_trims.platform.Services;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.HorseArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.*;
import net.raphimc.immediatelyfast.feature.batching.BatchingBuffer;
import net.raphimc.immediatelyfast.feature.batching.BatchingBuffers;
import net.raphimc.immediatelyfast.feature.core.BatchableBufferSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

import static com.cursee.animal_armor_trims.core.util.HorseRenderLayerHelper.*;

@Mixin(HorseArmorLayer.class)
public class FabricHorseArmorLayerMixin {

    @Shadow @Final private HorseModel<Horse> model;

    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/HorseModel;renderToBuffer(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;IIFFFF)V"))
    // @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Horse;FFFFFF)V", at = @At("TAIL"))
    private void animalArmorTrims$onRenderHorseArmorLayer(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Horse horse, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {

        poseStack.pushPose();

        ItemStack armor = horse.getArmor();
        if (!(armor.getItem() instanceof HorseArmorItem)) return;

        if (armor.getTag() == null || !armor.getTag().contains("Trim")) return;

        CompoundTag trim = armor.getTagElement("Trim");

        if (trim == null) return;

        String material = trim.getString("material").replace("minecraft:", "");
        String pattern = trim.getString("pattern").replace("minecraft:", "");

        VertexConsumer vertexConsumer = HorseRenderLayerHelper.createVertexConsumer(trim, buffer);

        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0F);
        poseStack.popPose();
    }
}
