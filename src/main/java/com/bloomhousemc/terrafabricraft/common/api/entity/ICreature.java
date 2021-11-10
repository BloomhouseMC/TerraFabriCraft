package com.bloomhousemc.terrafabricraft.common.api.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.biome.Biome;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public interface ICreature {

    int getSpawnWeight(Biome biome, float temperature, float rainfall, float floraDensity, float floraDiversity);

    /**
     * Returns the grouping rules (one or more) for spawn
     * Override this if you want your groups to have some form of rules applied to them
     * (ie for animals: Mother and children, one male and all female)
     *
     * @return Consumer method to apply rules to all individuals at once
     */
    default BiConsumer<List<LivingEntity>, Random> getGroupingRules()
    {
        return (creatures, random) -> {}; // Default, no special rules
    }

    /**
     * Returns the minimum group size (if not solo) this creature spawns in
     *
     * @return minimum number of individuals in one group spawn
     */
    default int getMinGroupSize()
    {
        return 1;
    }

    /**
     * Returns the maximum group size this creature spawns in
     *
     * @return maximum number of individuals in one group spawn
     */
    default int getMaxGroupSize()
    {
        return 1;
    }

    /**
     * Returns this creature type
     *
     * @return CreatureType of this entity
     */
    CreatureType getCreatureType();

    enum CreatureType
    {
        PREDATOR, HUNTABLE, LIVESTOCK
    }
}
