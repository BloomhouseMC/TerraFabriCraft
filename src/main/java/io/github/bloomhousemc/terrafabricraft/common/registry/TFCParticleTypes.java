package io.github.bloomhousemc.terrafabricraft.common.registry;

import io.github.bloomhousemc.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class TFCParticleTypes {
    private static final Map<ParticleType<?>, Identifier> PARTICLE_TYPES = new LinkedHashMap<>();

    public static final ParticleType<DefaultParticleType> KEG_BUBBLE = create("keg_bubble", FabricParticleTypes.simple());

    private static <T extends ParticleEffect> ParticleType<T> create(String name, ParticleType<T> type) {
        PARTICLE_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, name));
        return type;
    }

    public static void init() {
        PARTICLE_TYPES.keySet().forEach(particleType -> Registry.register(Registry.PARTICLE_TYPE, PARTICLE_TYPES.get(particleType), particleType));
    }
}