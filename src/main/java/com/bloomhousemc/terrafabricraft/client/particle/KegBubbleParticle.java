package com.bloomhousemc.terrafabricraft.client.particle;

import com.bloomhousemc.terrafabricraft.common.block.keg.Keg;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class KegBubbleParticle extends SpriteBillboardParticle {
    public KegBubbleParticle(ClientWorld clientWorld, double posX, double posY, double posZ, double velocityX, double velocityY, double velocityZ) {
        super(clientWorld, posX, posY, posZ, velocityX, velocityY, velocityZ);
        setBoundingBoxSpacing(0.02f, 0.02f);
        scale *= random.nextFloat() * 0.3 + 0.3;
        this.velocityX *= 0.1;
        this.velocityY *= 0.1;
        this.velocityZ *= 0.1;
        colorRed = (float) velocityX;
        colorGreen = (float) velocityY;
        colorBlue = (float) velocityZ;
        maxAge = (int) (4 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        prevPosX = x;
        prevPosY = y;
        prevPosZ = z;
        if (maxAge-- <= 0) {
            markDead();
        }
        else {
            velocityX *= 0;
            velocityZ *= 0;
            move(velocityX, velocityY, velocityZ);
            velocityY *= 0.5;
            if (!(world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof Keg)) {
                markDead();
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double posX, double posY, double posZ, double velocityX, double velocityY, double velocityZ) {
            KegBubbleParticle particle = new KegBubbleParticle(clientWorld, posX, posY, posZ, velocityX, velocityY, velocityZ);
            particle.setSprite(spriteProvider);
            return particle;
        }
    }
}