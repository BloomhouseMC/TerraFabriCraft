//package com.bloomhousemc.terrafabricraft.common.entity;
//
//import com.bloomhousemc.terrafabricraft.common.api.entity.IAnimal;
//import com.bloomhousemc.terrafabricraft.common.util.HelperUtil;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.data.DataTracker;
//import net.minecraft.entity.data.TrackedData;
//import net.minecraft.entity.data.TrackedDataHandlerRegistry;
//import net.minecraft.entity.passive.AnimalEntity;
//import net.minecraft.world.World;
//
//public abstract class TFCAnimal extends AnimalEntity implements IAnimal {
//    public static final long MATING_COOLDOWN_DEFAULT_TICKS = ICalendar.TICKS_IN_HOUR * 2;
//
//    //Values that has a visual effect on client
//    private static final TrackedData<Boolean> GENDER = DataTracker.registerData(TFCAnimal.class, TrackedDataHandlerRegistry.BOOLEAN);
//    private static final TrackedData<Integer> BIRTHDAY = DataTracker.registerData(TFCAnimal.class, TrackedDataHandlerRegistry.INTEGER);
//    private static final TrackedData<Float> FAMILIARITY = DataTracker.registerData(TFCAnimal.class, TrackedDataHandlerRegistry.FLOAT);
//    //Is this female fertilized? (in oviparous, the egg laying is fertilized, for mammals this is pregnancy)
//    private static final TrackedData<Boolean> FERTILIZED = DataTracker.registerData(TFCAnimal.class, TrackedDataHandlerRegistry.BOOLEAN);
//
//    public TFCAnimal(EntityType<? extends AnimalEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    public static int getRandomGrowth(int daysToAdult, int daysToElder) {
//        int randomFactor = daysToElder > 0 ? (int) (daysToElder * 1.25f) : daysToAdult * 4;
//        int lifeTimeDays = daysToAdult + HelperUtil.RNG.nextInt(randomFactor);
//        return (int) (Calendars.SERVER.getTotalDays() - lifeTimeDays);
//    }
//
//  /*  public static <T extends AnimalEntity & IAnimal> void findFemaleMate(T maleAnimal) {
//        List<AnimalEntity> list = maleAnimal.world.getEntitiesByClass(maleAnimal.getClass(), maleAnimal.getBoundingBox().expand(8.0D), (male) -> {
//            return true;
//        });
//    } */
//}
