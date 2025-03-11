package com.cursee.animal_armor_trims.mixin;

import com.cursee.animal_armor_trims.Constants;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = RenderType.class)
public abstract class FabricRenderTypeMixin extends RenderStateShard {

    public FabricRenderTypeMixin(String name, Runnable setupState, Runnable clearState) {
        super(name, setupState, clearState);
    }

//    @ModifyArg(method = "method_34834", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderType;create(Ljava/lang/String;Lcom/mojang/blaze3d/vertex/VertexFormat;Lcom/mojang/blaze3d/vertex/VertexFormat$Mode;IZZLnet/minecraft/client/renderer/RenderType$CompositeState;)Lnet/minecraft/client/renderer/RenderType$CompositeRenderType;"), index = 4)
//    private static boolean ZinjectedZ(boolean $$1Z) {
//        return true;
//    }

    @ModifyArg(method = {
            "method_34834" /*TEXT*/,
            "method_34833" /*TEXT_INTENSITY*/,
            "method_36437" /*TEXT_POLYGON_OFFSET*/,
            "method_36436" /*TEXT_INTENSITY_POLYGON_OFFSET*/,
            "method_37348" /*TEXT_SEE_THROUGH*/,
            "method_37347" /*TEXT_INTENSITY_SEE_THROUGH*/
    }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderType;create(Ljava/lang/String;Lcom/mojang/blaze3d/vertex/VertexFormat;Lcom/mojang/blaze3d/vertex/VertexFormat$Mode;IZZLnet/minecraft/client/renderer/RenderType$CompositeState;)Lnet/minecraft/client/renderer/RenderType$CompositeRenderType;"), index = 5)
    private static boolean Zinjected2Z(boolean $$1Z) {
        Constants.LOG.info("mixin working");
        return true;
    }
}
