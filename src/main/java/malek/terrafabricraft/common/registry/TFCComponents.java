package malek.terrafabricraft.common.registry;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.component.HungerComponent;
import malek.terrafabricraft.common.component.ThirstComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class TFCComponents implements EntityComponentInitializer, WorldComponentInitializer, ItemComponentInitializer {
    public static final ComponentKey<HealthComponent> HEALTH_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "health"), HealthComponent.class);
    public static final ComponentKey<HungerComponent> HUNGER_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "hunger"), HungerComponent.class);
    public static final ComponentKey<ThirstComponent> THIRST_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "thirst"), ThirstComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(LivingEntity.class, HEALTH_COMPONENT).impl(HealthComponent.class).respawnStrategy(RespawnCopyStrategy.LOSSLESS_ONLY).end(HealthComponent::new);
        registry.beginRegistration(PlayerEntity.class, HUNGER_COMPONENT).impl(HungerComponent.class).respawnStrategy(RespawnCopyStrategy.LOSSLESS_ONLY).end(HungerComponent::new);
        registry.beginRegistration(LivingEntity.class, THIRST_COMPONENT).impl(ThirstComponent.class).respawnStrategy(RespawnCopyStrategy.LOSSLESS_ONLY).end(ThirstComponent::new);

    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {

    }

    @Override
    public void registerItemComponentFactories(ItemComponentFactoryRegistry registry) {

    }
}
