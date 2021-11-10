package io.github.bloomhousemc.terrafabricraft.common.util.damage;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.ZombieEntity;

public class DamageTypeUtil {

    public static boolean isWeakToCrushing(LivingEntity target) {
        return target instanceof AbstractSkeletonEntity || target instanceof EndermanEntity;
    }

    public static boolean isStrongAgainstCrushing(LivingEntity target) {
        return target instanceof CreeperEntity || target instanceof ZombieEntity;
    }
}
