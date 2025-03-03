package io.github.gaming32.anyfreetype.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.font.providers.TrueTypeGlyphProviderDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TrueTypeGlyphProviderDefinition.class)
public class MixinTrueTypeGlyphProviderDefinition {
    @WrapOperation(
        method = "load",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/String;equals(Ljava/lang/Object;)Z"
        )
    )
    private boolean anyFreeType(String instance, Object o, Operation<Boolean> original) {
        if (instance.equals("TrueType")) {
            return true;
        }
        return original.call(instance, o);
    }
}
