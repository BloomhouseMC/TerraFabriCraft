package com.bloomhousemc.terrafabricraft.common.api.entity;

public interface ILivestock extends ICreature {

    @Override
    default CreatureType getCreatureType() { return CreatureType.LIVESTOCK; }
}
