package io.github.bloomhousemc.terrafabricraft.common.block.keg;

import io.github.bloomhousemc.terrafabricraft.common.recipes.KegRecipe;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCRecipeTypes;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static io.github.bloomhousemc.terrafabricraft.common.block.keg.Keg.WORKING;

public class KegEntity extends BlockEntity implements Inventory, IAnimatable, BlockEntityClientSerializable {
    private final AnimationFactory manager = new AnimationFactory(this);
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public int processTimer = 0;
    public int color = 0x3f76e4;
    public int time = 0;
    private boolean loaded = false;
    public Mode mode = Mode.NORMAL;
    public KegRecipe kegRecipe = null;
    private Box box;

    public KegEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.KEG_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void fromClientTag(NbtCompound tag) {
        Inventories.readNbt(tag, inventory);
        mode = Mode.valueOf(tag.getString("Mode"));
        if (tag.contains("Color")) {
            color = tag.getInt("Color");
        }
        if (tag.contains("Time")) {
            time = tag.getInt("Time");
        }
        processTimer = tag.getInt("ProcessTimer");
    }

    @Override
    public NbtCompound toClientTag(NbtCompound tag) {
        Inventories.writeNbt(tag, inventory);
        tag.putInt("Color", color);
        tag.putInt("Time", time);
        tag.putString("Mode", mode.name);
        tag.putInt("ProcessTimer", processTimer);
        return tag;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        fromClientTag(nbt);
        super.readNbt(nbt);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        return super.writeNbt(toClientTag(nbt));
    }

    public void setTime(int time) {
        if (world != null) {
            this.time = time;
        }
    }

    public void setColor(int color) {
        if (world != null) {
            this.color = color;
        }
    }
    private int getFirstEmptySlot() {
        for (int i = 0; i < size(); i++) {
            if (getStack(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    public static void tick(World world, BlockPos pos, BlockState state, KegEntity blockEntity) {
        if (world != null) {
            if(!blockEntity.loaded){
                blockEntity.markDirty();
                blockEntity.box = new Box(pos).contract(0.75);
                blockEntity.kegRecipe = world.getRecipeManager().listAllOfType(TFCRecipeTypes.KEG_RECIPE_TYPE).stream().filter(recipe -> recipe.matches(blockEntity, world)).findFirst().orElse(null);
                blockEntity.loaded = true;
            }
            if (!world.isClient) {

                if (state.get(Keg.LEVEL) > 0) {
                    if(state.get(WORKING)){
                        blockEntity.processTimer++;
                        if(blockEntity.processTimer >= blockEntity.time){
                            world.setBlockState(pos, state.with(WORKING, false));
                            blockEntity.processTimer=0;
                        }
                        if (world.random.nextFloat() <= 0.05f) {
                            world.playSound(null, pos, SoundEvents.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT, SoundCategory.BLOCKS, 1 / 3f, 1);
                        }
                    }
                    if (world.getTime() % 5 == 0) {
                        world.getEntitiesByType(EntityType.ITEM, blockEntity.box, entity -> true).forEach(itemEntity -> {
                            if (state.get(Keg.LEVEL) == 3) {
                                world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1 / 3f, 1);
                                ItemStack stack = itemEntity.getStack();
                                if (stack.getItem().hasRecipeRemainder()) {
                                    ItemEntity remainder = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(stack.getItem().getRecipeRemainder()));
                                    remainder.setVelocity(Vec3d.ZERO);
                                    remainder.setNoGravity(true);
                                    world.spawnEntity(remainder);
                                }
                                blockEntity.mode = blockEntity.insertStack(stack.split(1));
                                blockEntity.syncKeg();
                            }
                        });
                    }
                }
            }
        }
    }

    private Mode insertStack(ItemStack stack) {
        if (world != null) {
            if (stack.getItem() == TFCObjects.STRAW) {
                Mode reset = reset();
                syncKeg();
                return reset;
            }
            else if (mode != Mode.FAILED) {
                int firstEmpty = getFirstEmptySlot();
                if (firstEmpty != -1) {
                    setStack(firstEmpty, stack);
                    kegRecipe = world.getRecipeManager().listAllOfType(TFCRecipeTypes.KEG_RECIPE_TYPE).stream().filter(recipe -> recipe.matches(this, world)).findFirst().orElse(null);
                    if (kegRecipe != null) {
                        setColor(kegRecipe.color);
                        setTime(kegRecipe.time);
                        this.getWorld().setBlockState(this.pos, this.getCachedState().with(WORKING, true));
                        return Mode.BREWING;
                    }
                    setColor(0xd6c291);
                    return Mode.BREWING;
                }
            }
        }
        return fail();
    }

    public void syncKeg() {
        sync();
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController<?> controller = event.getController();
        controller.transitionLengthTicks = 0;
        if(world.getBlockState(pos).get(WORKING)){
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.keg.process", true));
        }else{
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.keg.idle", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<KegEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.manager;
    }

    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            if (getStack(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        inventory.set(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return player.squaredDistanceTo(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) < 16;
    }

    @Override
    public void clear() {
        inventory.clear();
    }
    public Mode fail() {
        setColor(0x505050);
        return Mode.FAILED;
    }


    public Mode reset() {
        if (world != null) {
            setColor(0x3f76e4);
            clear();
            world.setBlockState(pos, getCachedState().with(Keg.LEVEL, 0));
        }
        return Mode.NORMAL;
    }

    public int getTargetLevel(ItemStack stack) {
        Item item = stack.getItem();
        int level = getCachedState().get(Keg.LEVEL);
        if (mode == Mode.NORMAL) {
            if (item == Items.BUCKET && level == 3) {
                return 0;
            }
            else if (item == Items.WATER_BUCKET && level == 0) {
                return 3;
            }
            else if (item == Items.GLASS_BOTTLE) {
                return level - 1;
            }
        }
        else if (mode == Mode.BREWING) {
            if (kegRecipe != null && item == Items.GLASS_BOTTLE) {
                return level - 1;
            }
        }
        return -1;
    }

    public enum Mode {
        NORMAL("NORMAL"),
        BREWING("BREWING"),
        FAILED("FAILED");

        public final String name;

        Mode(String name) {
            this.name = name;
        }
    }
}
