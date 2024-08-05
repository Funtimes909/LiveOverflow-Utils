package xyz.funtimes909.liveoverflow_utils.mixin;

import net.minecraft.network.packet.s2c.play.*;
import xyz.funtimes909.liveoverflow_utils.modules.WorldBorderBypass;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class WorldBorderMixin {

    @Inject(at = @At("TAIL"), method = "onWorldBorderInitialize", cancellable = true)
    private void onWorldBorderInitialize(WorldBorderInitializeS2CPacket packet, CallbackInfo ci) {
        if (Modules.get().isActive(WorldBorderBypass.class)) {
            ci.cancel();
        }
    }

    @Inject(at = @At("TAIL"), method = "onWorldBorderSizeChanged", cancellable = true)
    public void onWorldBorderSizeChanged(WorldBorderSizeChangedS2CPacket packet, CallbackInfo ci) {
        if (Modules.get().isActive(WorldBorderBypass.class)) {
            ci.cancel();
        }
    }
}
