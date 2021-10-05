package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.entity.NautilusEntity;
import malek.terrafabricraft.common.config.ModuleConfig;
import malek.terrafabricraft.common.entity.CrabEntity;
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
    public static final EntityType<NautilusEntity> NAUTILUS = create("nautilus", FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, NautilusEntity::new).dimensions(EntityDimensions.changing(0.5f, 1.75f)).build());

    private static <T extends LivingEntity> EntityType<T> create(String name, DefaultAttributeContainer.Builder attributes, EntityType<T> type) {
        FabricDefaultAttributeRegistry.register(type, attributes);
        ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, name));
        return type;
    }

    public static final EntityType<RoosterEntity> ROOSTER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(TerraFabriCraft.MODID, "rooster"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RoosterEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<CrabEntity> CRAB = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(TerraFabriCraft.MODID, "crab"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrabEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    private static <T extends Entity> EntityType<T> create(String name, EntityType<T> type) {
        ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, name));
        return type;
    }

    public static void init() {
        if (ModuleConfig.getValue("husbandry")) {
            ENTITY_TYPES.keySet().forEach(entityType -> Registry.register(Registry.ENTITY_TYPE, ENTITY_TYPES.get(entityType), entityType));
            FabricDefaultAttributeRegistry.register(ROOSTER, RoosterEntity.createMobAttributes());
            FabricDefaultAttributeRegistry.register(NAUTILUS, NautilusEntity.createMobAttributes());
            FabricDefaultAttributeRegistry.register(CRAB, CrabEntity.createCrabAttributes());
        }

    }
}
