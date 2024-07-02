
minerals = ["amethyst", "copper", "diamond", "emerald", "gold", "iron", "lapis", "netherite", "quartz", "redstone"]
trims = ["bolt", "coast", "dune", "eye", "flow", "host", "raiser", "rib", "sentry", "shaper", "silence", "snout", "spire", "tide", "vex", "ward", "wayfinder", "wild",]

for mineral in minerals:
    for trim in trims:
        print(f"public static final ResourceLocation HORSE_{trim.upper()}_{mineral.upper()} = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, \"textures/horse/trim/models_new/{trim}_{mineral}.png\");")

for mineral1 in minerals:
    for trim1 in trims:
        print(f"public static final ResourceLocation WOLF_{trim1.upper()}_{mineral1.upper()} = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, \"textures/horse/trim/wolf_t_complete/{trim1}_{mineral1}.png\");")
