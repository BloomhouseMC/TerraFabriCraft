package malek.terrafabricraft.common.entity;

import malek.terrafabricraft.common.registry.TFCEntityTypes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CrabEntity extends AnimalEntity {

    public CrabEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.LAVA, -1.0F);
    }

    public static boolean canSpawn(EntityType<HuskEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos).isIn(BlockTags.SAND) && world.getLightLevel(pos) >= 8;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.2D, Ingredient.fromTag(ItemTags.FISHES), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return new CrabEntity(TFCEntityTypes.CRAB, world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return !stack.isEmpty() && isCrabFood(stack);
    }

    private boolean isCrabFood(ItemStack stack) {
        return stack.isOf(Items.KELP) || stack.isIn(ItemTags.FISHES);
    }


    public static DefaultAttributeContainer.Builder createCrabAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22D).add(EntityAttributes.GENERIC_ARMOR, 3.0D).add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 2.0D);
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isIn(BlockTags.SAND) ? 10.0F : world.getLightLevel(pos) - 0.5F;
    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }

    @Override
    public float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.2f * dimensions.height;
    }

    @Override
    public void tick() {
        if (this.isSubmergedInWater()) {
            this.stepHeight = 1F;
        } else {
            this.stepHeight = 0.6F;
        }
        super.tick();
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public int getNextAirUnderwater(int air) {
        return air;
    }
}
