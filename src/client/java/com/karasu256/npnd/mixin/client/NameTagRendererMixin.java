package com.karasu256.npnd.mixin.client;

import com.karasu256.npnd.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class NameTagRendererMixin {
    @Unique
    private ModConfig config;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        this.config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @Inject(method = "renderLabelIfPresent*", at = @At("HEAD"), cancellable = true)
    private void renderLabelIfPresent(CallbackInfo ci) {
        if (config.hidePlayerNames) {
            ci.cancel();
        }
    }
}
