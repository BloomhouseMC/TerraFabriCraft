package malek.terrafabricraft.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public class RoosterEntity extends PathfinderMob {

    public RoosterEntity(EntityType<? extends PathfinderMob> entityType, Level world) {
        super(entityType, world);
    }
}
