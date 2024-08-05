package xyz.funtimes909.liveoverflow_utils.mixin;

import xyz.funtimes909.liveoverflow_utils.modules.AntiHumanBypass;
import xyz.funtimes909.liveoverflow_utils.util.CoordinateRounder;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerMoveC2SPacket.class)
public class MovePacketMixin {
    @Mutable
    @Shadow
    @Final
    protected double z;

    @Mutable
    @Shadow
    @Final
    protected double x;

    @Inject(at = @At("TAIL"), method = "<init>"
    )

    private void onPlayerMoveC2SPacket(double x, double y, double z, float yaw, float pitch, boolean onGround, boolean changePosition, boolean changeLook, CallbackInfo ci) {
        if (!Modules.get().isActive(AntiHumanBypass.class)) {
            return;
        }

        this.x = CoordinateRounder.roundedDown(x);
        this.z = CoordinateRounder.roundedDown(z);

    }
}
