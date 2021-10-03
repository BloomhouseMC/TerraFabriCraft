package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.entity.RoosterEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class TFCEntityTypes {
    private static final Map<EntityType<?>, Identifier> ENTITY_TYPES = new LinkedHashMap<>();
    //Oh, Deer.
    //public static final EntityType<DeerEntity> DEER = create("deer", DeerEntity.createAttributes(), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DeerEntity::new).dimensions(EntityDimensions.changing(0.5f, 1.75f)).build());

//    public static final EntityType<RoosterEntity> ROOSTER = create("rooster", RoosterEntity.createMobAttributes(), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RoosterEntity::new).dimensions(EntityDimensions.changing(0.5f, 1.75f)).build());


    private static <T extends LivingEntity> EntityType<T> create(String name, DefaultAttributeContainer.Builder attributes, EntityType<T> type) {
        FabricDefaultAttributeRegistry.register(type, attributes);
        ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MOD_ID, name));
        return type;
    }

    public static final EntityType<RoosterEntity> ROOSTER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(TerraFabriCraft.MOD_ID, "rooster"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RoosterEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    private static <T extends Entity> EntityType<T> create(String name, EntityType<T> type) {
        ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MOD_ID, name));
        return type;
    }

    public static void init() {
        FabricDefaultAttributeRegistry.register(ROOSTER, RoosterEntity.createMobAttributes());
        ENTITY_TYPES.keySet().forEach(entityType -> Registry.register(Registry.ENTITY_TYPE, ENTITY_TYPES.get(entityType), entityType));
    }
}
