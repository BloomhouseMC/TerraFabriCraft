package malek.terrafabricraft.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class NautilusEntity extends WaterCreatureEntity implements IAnimatable {
    AnimationFactory factory = new AnimationFactory(this);
    private float swimX;
    private float swimY;
    private float swimZ;

    public NautilusEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return LivingEntity.createLivingAttributes()
        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 5.0D)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D)
        .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.nautilus.idle", true));
        return PlayState.CONTINUE;
    }
    private <E extends IAnimatable> PlayState predicate1(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.nautilus.move", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<NautilusEntity>(this, "controller", 0, this::predicate));
        data.addAnimationController(new AnimationController<NautilusEntity>(this, "controller1", 0, this::predicate1));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeAttackerGoal());
        super.initGoals();
    }
    
    public void setSwimmingVector(float x, float y, float z) {
        this.swimX = x;
        this.swimY = y;
        this.swimZ = z;
    }

    public boolean hasSwimmingVector() {
        return this.swimX != 0.0F || this.swimY != 0.0F || this.swimZ != 0.0F;
    }



    class SwimGoal extends Goal {
        private final NautilusEntity nautilus;

        public SwimGoal(NautilusEntity nautilusEntity2) {
            this.nautilus = nautilusEntity2;
        }

        public boolean canStart() {
            return true;
        }

        public void tick() {
            int i = this.nautilus.getDespawnCounter();
            if (i > 100) {
                this.nautilus.setSwimmingVector(0.0F, 0.0F, 0.0F);
            } else if (this.nautilus.getRandom().nextInt(50) == 0 || !this.nautilus.touchingWater || !this.nautilus.hasSwimmingVector()) {
                float f = this.nautilus.getRandom().nextFloat() * 6.2831855F;
                float g = MathHelper.cos(f) * 0.2F;
                float h = -0.1F + this.nautilus.getRandom().nextFloat() * 0.2F;
                float j = MathHelper.sin(f) * 0.2F;
                this.nautilus.setSwimmingVector(g, h, j);
            }

        }
    }
    class EscapeAttackerGoal extends Goal {
        private static final float field_30375 = 3.0F;
        private static final float field_30376 = 5.0F;
        private static final float field_30377 = 10.0F;
        private int timer;

        EscapeAttackerGoal() {
        }

        public boolean canStart() {
            LivingEntity livingEntity = NautilusEntity.this.getAttacker();
            if (NautilusEntity.this.isTouchingWater() && livingEntity != null) {
                return NautilusEntity.this.squaredDistanceTo(livingEntity) < 100.0D;
            } else {
                return false;
            }
        }

        public void start() {
            this.timer = 0;
        }

        public void tick() {
            ++this.timer;
            LivingEntity livingEntity = NautilusEntity.this.getAttacker();
            if (livingEntity != null) {
                Vec3d vec3d = new Vec3d(NautilusEntity.this.getX() - livingEntity.getX(), NautilusEntity.this.getY() - livingEntity.getY(), NautilusEntity.this.getZ() - livingEntity.getZ());
                BlockState blockState = NautilusEntity.this.world.getBlockState(new BlockPos(NautilusEntity.this.getX() + vec3d.x, NautilusEntity.this.getY() + vec3d.y, NautilusEntity.this.getZ() + vec3d.z));
                FluidState fluidState = NautilusEntity.this.world.getFluidState(new BlockPos(NautilusEntity.this.getX() + vec3d.x, NautilusEntity.this.getY() + vec3d.y, NautilusEntity.this.getZ() + vec3d.z));
                if (fluidState.isIn(FluidTags.WATER) || blockState.isAir()) {
                    double d = vec3d.length();
                    if (d > 0.0D) {
                        vec3d.normalize();
                        float f = 3.0F;
                        if (d > 5.0D) {
                            f = (float)((double)f - (d - 5.0D) / 5.0D);
                        }

                        if (f > 0.0F) {
                            vec3d = vec3d.multiply((double)f);
                        }
                    }

                    if (blockState.isAir()) {
                        vec3d = vec3d.subtract(0.0D, vec3d.y, 0.0D);
                    }

                    NautilusEntity.this.setSwimmingVector((float)vec3d.x / 20.0F, (float)vec3d.y / 20.0F, (float)vec3d.z / 20.0F);
                }

                if (this.timer % 10 == 5) {
                    NautilusEntity.this.world.addParticle(ParticleTypes.BUBBLE, NautilusEntity.this.getX(), NautilusEntity.this.getY(), NautilusEntity.this.getZ(), 0.0D, 0.0D, 0.0D);
                }

            }
        }
    }
}
