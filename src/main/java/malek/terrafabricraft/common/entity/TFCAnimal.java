package malek.terrafabricraft.common.entity;

import malek.terrafabricraft.common.api.entity.IAnimal;
import malek.terrafabricraft.common.calendar.Calendars;
import malek.terrafabricraft.common.calendar.ICalendar;
import malek.terrafabricraft.common.util.HelperUtil;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import java.util.List;

public abstract class TFCAnimal extends Animal implements IAnimal {
    public static final long MATING_COOLDOWN_DEFAULT_TICKS = ICalendar.TICKS_IN_HOUR * 2;

    //Values that has a visual effect on client
    private static final EntityDataAccessor<Boolean> GENDER = SynchedEntityData.defineId(TFCAnimal.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> BIRTHDAY = SynchedEntityData.defineId(TFCAnimal.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> FAMILIARITY = SynchedEntityData.defineId(TFCAnimal.class, EntityDataSerializers.FLOAT);
    //Is this female fertilized? (in oviparous, the egg laying is fertilized, for mammals this is pregnancy)
    private static final EntityDataAccessor<Boolean> FERTILIZED = SynchedEntityData.defineId(TFCAnimal.class, EntityDataSerializers.BOOLEAN);

    public TFCAnimal(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
    }

    public static int getAge(int daysToAdult, int daysToElder) {
        int randomFactor = daysToElder > 0 ? (int) (daysToElder * 1.25f) : daysToAdult * 4;
        int lifeTimeDays = daysToAdult + HelperUtil.RNG.nextInt(randomFactor);
        return (int) (Calendars.SERVER.getTotalDays() - lifeTimeDays);
    }

  /*  public static <T extends AnimalEntity & IAnimal> void findFemaleMate(T maleAnimal) {
        List<AnimalEntity> list = maleAnimal.world.getEntitiesByClass(maleAnimal.getClass(), maleAnimal.getBoundingBox().expand(8.0D), (male) -> {
            return true;
        });
    } */
}
