package com.cursee.animal_armor_trims.core.util;

import com.cursee.animal_armor_trims.AnimalArmorTrims;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public class HorseRenderLayerHelper {
    public static VertexConsumer createVertexConsumer(CompoundTag trim, MultiBufferSource buffer) {

        String material = trim.getString("material").replace("minecraft:", "");
        String pattern = trim.getString("pattern").replace("minecraft:", "");

        VertexConsumer vertexConsumer;

        switch (material) {
            case "amethyst" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_AMETHYST));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_AMETHYST));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_AMETHYST));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_AMETHYST));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_AMETHYST));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_AMETHYST));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_AMETHYST));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_AMETHYST));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_AMETHYST));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_AMETHYST));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_AMETHYST));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_AMETHYST));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_AMETHYST));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_AMETHYST));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_AMETHYST));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_AMETHYST));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "copper" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_COPPER));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_COPPER));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_COPPER));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_COPPER));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_COPPER));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_COPPER));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_COPPER));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_COPPER));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_COPPER));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_COPPER));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_COPPER));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_COPPER));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_COPPER));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_COPPER));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_COPPER));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_COPPER));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "diamond" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_DIAMOND));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_DIAMOND));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_DIAMOND));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_DIAMOND));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_DIAMOND));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_DIAMOND));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_DIAMOND));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_DIAMOND));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_DIAMOND));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_DIAMOND));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_DIAMOND));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_DIAMOND));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_DIAMOND));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_DIAMOND));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_DIAMOND));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_DIAMOND));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "emerald" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_EMERALD));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_EMERALD));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_EMERALD));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_EMERALD));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_EMERALD));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_EMERALD));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_EMERALD));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_EMERALD));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_EMERALD));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_EMERALD));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_EMERALD));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_EMERALD));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_EMERALD));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_EMERALD));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_EMERALD));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_EMERALD));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "gold" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_GOLD));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_GOLD));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_GOLD));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_GOLD));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_GOLD));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_GOLD));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_GOLD));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_GOLD));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_GOLD));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_GOLD));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_GOLD));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_GOLD));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_GOLD));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_GOLD));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_GOLD));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_GOLD));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "iron" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_IRON));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_IRON));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_IRON));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_IRON));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_IRON));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_IRON));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_IRON));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_IRON));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_IRON));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_IRON));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_IRON));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_IRON));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_IRON));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_IRON));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_IRON));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_IRON));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "lapis" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_LAPIS));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_LAPIS));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_LAPIS));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_LAPIS));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_LAPIS));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_LAPIS));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_LAPIS));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_LAPIS));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_LAPIS));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_LAPIS));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_LAPIS));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_LAPIS));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_LAPIS));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_LAPIS));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_LAPIS));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_LAPIS));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "netherite" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_NETHERITE));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_NETHERITE));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_NETHERITE));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_NETHERITE));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_NETHERITE));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_NETHERITE));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_NETHERITE));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_NETHERITE));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_NETHERITE));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_NETHERITE));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_NETHERITE));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_NETHERITE));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_NETHERITE));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_NETHERITE));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_NETHERITE));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_NETHERITE));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "quartz" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_QUARTZ));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_QUARTZ));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_QUARTZ));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_QUARTZ));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_QUARTZ));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_QUARTZ));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_QUARTZ));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_QUARTZ));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_QUARTZ));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_QUARTZ));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_QUARTZ));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_QUARTZ));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_QUARTZ));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_QUARTZ));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_QUARTZ));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_QUARTZ));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            case "redstone" -> {
                switch (pattern) {
                    case "coast" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(COAST_REDSTONE));
                    case "dune" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(DUNE_REDSTONE));
                    case "eye" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(EYE_REDSTONE));
                    case "host" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(HOST_REDSTONE));
                    case "raiser" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RAISER_REDSTONE));
                    case "rib" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(RIB_REDSTONE));
                    case "sentry" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SENTRY_REDSTONE));
                    case "shaper" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SHAPER_REDSTONE));
                    case "silence" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SILENCE_REDSTONE));
                    case "snout" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SNOUT_REDSTONE));
                    case "spire" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(SPIRE_REDSTONE));
                    case "tide" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(TIDE_REDSTONE));
                    case "vex" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(VEX_REDSTONE));
                    case "ward" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WARD_REDSTONE));
                    case "wayfinder" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WAYFINDER_REDSTONE));
                    case "wild" -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(WILD_REDSTONE));
                    default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
                }
            }
            default -> vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(BLANK));
        }

        return vertexConsumer;
    }

    public static final ResourceLocation BLANK = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/blank.png");

    public static final ResourceLocation COAST_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_amethyst.png");
    public static final ResourceLocation DUNE_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_amethyst.png");
    public static final ResourceLocation EYE_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_amethyst.png");
    public static final ResourceLocation HOST_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_amethyst.png");
    public static final ResourceLocation RAISER_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_amethyst.png");
    public static final ResourceLocation RIB_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_amethyst.png");
    public static final ResourceLocation SENTRY_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_amethyst.png");
    public static final ResourceLocation SHAPER_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_amethyst.png");
    public static final ResourceLocation SILENCE_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_amethyst.png");
    public static final ResourceLocation SNOUT_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_amethyst.png");
    public static final ResourceLocation SPIRE_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_amethyst.png");
    public static final ResourceLocation TIDE_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_amethyst.png");
    public static final ResourceLocation VEX_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_amethyst.png");
    public static final ResourceLocation WARD_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_amethyst.png");
    public static final ResourceLocation WAYFINDER_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_amethyst.png");
    public static final ResourceLocation WILD_AMETHYST = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_amethyst.png");

    public static final ResourceLocation COAST_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_copper.png");
    public static final ResourceLocation DUNE_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_copper.png");
    public static final ResourceLocation EYE_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_copper.png");
    public static final ResourceLocation HOST_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_copper.png");
    public static final ResourceLocation RAISER_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_copper.png");
    public static final ResourceLocation RIB_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_copper.png");
    public static final ResourceLocation SENTRY_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_copper.png");
    public static final ResourceLocation SHAPER_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_copper.png");
    public static final ResourceLocation SILENCE_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_copper.png");
    public static final ResourceLocation SNOUT_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_copper.png");
    public static final ResourceLocation SPIRE_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_copper.png");
    public static final ResourceLocation TIDE_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_copper.png");
    public static final ResourceLocation VEX_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_copper.png");
    public static final ResourceLocation WARD_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_copper.png");
    public static final ResourceLocation WAYFINDER_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_copper.png");
    public static final ResourceLocation WILD_COPPER = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_copper.png");

    public static final ResourceLocation COAST_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_diamond.png");
    public static final ResourceLocation DUNE_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_diamond.png");
    public static final ResourceLocation EYE_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_diamond.png");
    public static final ResourceLocation HOST_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_diamond.png");
    public static final ResourceLocation RAISER_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_diamond.png");
    public static final ResourceLocation RIB_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_diamond.png");
    public static final ResourceLocation SENTRY_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_diamond.png");
    public static final ResourceLocation SHAPER_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_diamond.png");
    public static final ResourceLocation SILENCE_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_diamond.png");
    public static final ResourceLocation SNOUT_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_diamond.png");
    public static final ResourceLocation SPIRE_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_diamond.png");
    public static final ResourceLocation TIDE_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_diamond.png");
    public static final ResourceLocation VEX_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_diamond.png");
    public static final ResourceLocation WARD_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_diamond.png");
    public static final ResourceLocation WAYFINDER_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_diamond.png");
    public static final ResourceLocation WILD_DIAMOND = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_diamond.png");

    public static final ResourceLocation COAST_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_emerald.png");
    public static final ResourceLocation DUNE_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_emerald.png");
    public static final ResourceLocation EYE_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_emerald.png");
    public static final ResourceLocation HOST_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_emerald.png");
    public static final ResourceLocation RAISER_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_emerald.png");
    public static final ResourceLocation RIB_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_emerald.png");
    public static final ResourceLocation SENTRY_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_emerald.png");
    public static final ResourceLocation SHAPER_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_emerald.png");
    public static final ResourceLocation SILENCE_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_emerald.png");
    public static final ResourceLocation SNOUT_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_emerald.png");
    public static final ResourceLocation SPIRE_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_emerald.png");
    public static final ResourceLocation TIDE_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_emerald.png");
    public static final ResourceLocation VEX_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_emerald.png");
    public static final ResourceLocation WARD_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_emerald.png");
    public static final ResourceLocation WAYFINDER_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_emerald.png");
    public static final ResourceLocation WILD_EMERALD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_emerald.png");

    public static final ResourceLocation COAST_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_gold.png");
    public static final ResourceLocation DUNE_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_gold.png");
    public static final ResourceLocation EYE_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_gold.png");
    public static final ResourceLocation HOST_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_gold.png");
    public static final ResourceLocation RAISER_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_gold.png");
    public static final ResourceLocation RIB_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_gold.png");
    public static final ResourceLocation SENTRY_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_gold.png");
    public static final ResourceLocation SHAPER_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_gold.png");
    public static final ResourceLocation SILENCE_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_gold.png");
    public static final ResourceLocation SNOUT_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_gold.png");
    public static final ResourceLocation SPIRE_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_gold.png");
    public static final ResourceLocation TIDE_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_gold.png");
    public static final ResourceLocation VEX_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_gold.png");
    public static final ResourceLocation WARD_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_gold.png");
    public static final ResourceLocation WAYFINDER_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_gold.png");
    public static final ResourceLocation WILD_GOLD = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_gold.png");

    public static final ResourceLocation COAST_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_iron.png");
    public static final ResourceLocation DUNE_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_iron.png");
    public static final ResourceLocation EYE_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_iron.png");
    public static final ResourceLocation HOST_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_iron.png");
    public static final ResourceLocation RAISER_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_iron.png");
    public static final ResourceLocation RIB_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_iron.png");
    public static final ResourceLocation SENTRY_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_iron.png");
    public static final ResourceLocation SHAPER_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_iron.png");
    public static final ResourceLocation SILENCE_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_iron.png");
    public static final ResourceLocation SNOUT_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_iron.png");
    public static final ResourceLocation SPIRE_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_iron.png");
    public static final ResourceLocation TIDE_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_iron.png");
    public static final ResourceLocation VEX_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_iron.png");
    public static final ResourceLocation WARD_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_iron.png");
    public static final ResourceLocation WAYFINDER_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_iron.png");
    public static final ResourceLocation WILD_IRON = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_iron.png");

    public static final ResourceLocation COAST_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_lapis.png");
    public static final ResourceLocation DUNE_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_lapis.png");
    public static final ResourceLocation EYE_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_lapis.png");
    public static final ResourceLocation HOST_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_lapis.png");
    public static final ResourceLocation RAISER_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_lapis.png");
    public static final ResourceLocation RIB_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_lapis.png");
    public static final ResourceLocation SENTRY_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_lapis.png");
    public static final ResourceLocation SHAPER_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_lapis.png");
    public static final ResourceLocation SILENCE_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_lapis.png");
    public static final ResourceLocation SNOUT_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_lapis.png");
    public static final ResourceLocation SPIRE_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_lapis.png");
    public static final ResourceLocation TIDE_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_lapis.png");
    public static final ResourceLocation VEX_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_lapis.png");
    public static final ResourceLocation WARD_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_lapis.png");
    public static final ResourceLocation WAYFINDER_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_lapis.png");
    public static final ResourceLocation WILD_LAPIS = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_lapis.png");

    public static final ResourceLocation COAST_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_netherite.png");
    public static final ResourceLocation DUNE_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_netherite.png");
    public static final ResourceLocation EYE_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_netherite.png");
    public static final ResourceLocation HOST_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_netherite.png");
    public static final ResourceLocation RAISER_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_netherite.png");
    public static final ResourceLocation RIB_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_netherite.png");
    public static final ResourceLocation SENTRY_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_netherite.png");
    public static final ResourceLocation SHAPER_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_netherite.png");
    public static final ResourceLocation SILENCE_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_netherite.png");
    public static final ResourceLocation SNOUT_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_netherite.png");
    public static final ResourceLocation SPIRE_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_netherite.png");
    public static final ResourceLocation TIDE_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_netherite.png");
    public static final ResourceLocation VEX_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_netherite.png");
    public static final ResourceLocation WARD_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_netherite.png");
    public static final ResourceLocation WAYFINDER_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_netherite.png");
    public static final ResourceLocation WILD_NETHERITE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_netherite.png");

    public static final ResourceLocation COAST_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_quartz.png");
    public static final ResourceLocation DUNE_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_quartz.png");
    public static final ResourceLocation EYE_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_quartz.png");
    public static final ResourceLocation HOST_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_quartz.png");
    public static final ResourceLocation RAISER_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_quartz.png");
    public static final ResourceLocation RIB_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_quartz.png");
    public static final ResourceLocation SENTRY_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_quartz.png");
    public static final ResourceLocation SHAPER_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_quartz.png");
    public static final ResourceLocation SILENCE_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_quartz.png");
    public static final ResourceLocation SNOUT_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_quartz.png");
    public static final ResourceLocation SPIRE_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_quartz.png");
    public static final ResourceLocation TIDE_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_quartz.png");
    public static final ResourceLocation VEX_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_quartz.png");
    public static final ResourceLocation WARD_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_quartz.png");
    public static final ResourceLocation WAYFINDER_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_quartz.png");
    public static final ResourceLocation WILD_QUARTZ = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_quartz.png");

    public static final ResourceLocation COAST_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/coast_redstone.png");
    public static final ResourceLocation DUNE_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/dune_redstone.png");
    public static final ResourceLocation EYE_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/eye_redstone.png");
    public static final ResourceLocation HOST_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/host_redstone.png");
    public static final ResourceLocation RAISER_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/raiser_redstone.png");
    public static final ResourceLocation RIB_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/rib_redstone.png");
    public static final ResourceLocation SENTRY_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/sentry_redstone.png");
    public static final ResourceLocation SHAPER_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/shaper_redstone.png");
    public static final ResourceLocation SILENCE_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/silence_redstone.png");
    public static final ResourceLocation SNOUT_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/snout_redstone.png");
    public static final ResourceLocation SPIRE_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/spire_redstone.png");
    public static final ResourceLocation TIDE_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/tide_redstone.png");
    public static final ResourceLocation VEX_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/vex_redstone.png");
    public static final ResourceLocation WARD_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/ward_redstone.png");
    public static final ResourceLocation WAYFINDER_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wayfinder_redstone.png");
    public static final ResourceLocation WILD_REDSTONE = AnimalArmorTrims.identifier("textures/entity/horse/armor/trims/wild_redstone.png");
}
