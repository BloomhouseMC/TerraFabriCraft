package com.bloomhousemc.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import com.bloomhousemc.terrafabricraft.common.registry.TFCComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

import java.util.Optional;

public class ProficiencyComponent implements AutoSyncedComponent, ServerTickingComponent {
    //Agriculture
    public static int AGRI_MAX_LEVEL,AGRI_MAX_XP,BUTCH_MAX_LEVEL,BUTCH_MAX_XP,COOK_MAX_LEVEL,COOK_MAX_XP,PROS_MAX_LEVEL,PROS_MAX_XP,SMITH_MAX_LEVEL,SMITH_MAX_XP = 100;
    public int agri_level = 0;
    public int agri_xp = 0;
    public int butch_level = 0;
    public int butch_xp = 0;
    public int cook_level = 0;
    public int cook_xp = 0;
    public int pros_level = 0;
    public int pros_xp = 0;
    public int smith_level = 0;
    public int smith_xp = 0;

    private final PlayerEntity playerEntity;
    public ProficiencyComponent(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
    //Agriculture
    public int getAgriLevel() {return agri_level;}
    public int getAgriMaxLevel() {return AGRI_MAX_LEVEL;}
    public void setAgriLevel(int agri_level) {
        this.agri_level = agri_level;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public int getAgriXp() {return agri_xp;}
    public int getAgriMaxXp() {return AGRI_MAX_XP;}
    public void setAgriXp(int agri_xp) {
        this.agri_xp = agri_xp;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public void increaseAgriXp(int add) {
        if (getAgriXp() + add <= getAgriMaxXp()) {
            setAgriXp(getAgriXp() + add);
            TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
        }
    }


    //Butchering
    public int getButchLevel() {return butch_level;}
    public int getButchMaxLevel() {return BUTCH_MAX_LEVEL;}
    public void setButchLevel(int butch_level) {
        this.butch_level = butch_level;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public int getButchXp() {return butch_xp;}
    public int getButchMaxXp() {return BUTCH_MAX_XP;}
    public void setButchXp(int butch_xp) {
        this.butch_xp = butch_xp;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public void increaseButchXp(int add) {
        if (getButchXp() + add <= getButchMaxXp()) {
            setButchXp(getButchXp() + add);
            TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
        }
    }


    //Cooking
    public int getCookLevel() {return cook_level;}
    public int getCookMaxLevel() {return COOK_MAX_LEVEL;}
    public void setCookLevel(int cook_level) {
        this.cook_level = cook_level;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public int getCookXp() {return cook_xp;}
    public int getCookMaxXp() {return COOK_MAX_XP;}
    public void setCookXp(int cook_xp) {
        this.cook_xp = cook_xp;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public void increaseCookXp(int add) {
        if (getCookXp() + add <= getCookMaxXp()) {
            setCookXp(getCookXp() + add);
            TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
        }
    }


    //Prospecting
    public int getProsLevel() {return pros_level;}
    public int getProsMaxLevel() {return PROS_MAX_LEVEL;}
    public void setProsLevel(int pros_level) {
        this.pros_level = pros_level;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public int getProsXp() {return pros_xp;}
    public int getProsMaxXp() {return PROS_MAX_XP;}
    public void setProsXp(int pros_xp) {
        this.pros_xp = pros_xp;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public void increaseProsXp(int add) {
        if (getProsXp() + add <= getProsMaxXp()) {
            setProsXp(getProsXp() + add);
            TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
        }
    }


    //Smithing
    public int getSmithLevel() {return smith_level;}
    public int getSmithMaxLevel() {return SMITH_MAX_LEVEL;}
    public void setSmithLevel(int smith_level) {
        this.smith_level = smith_level;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public int getSmithXp() {return smith_xp;}
    public int getSmithMaxXp() {return SMITH_MAX_XP;}
    public void setSmithXp(int smith_xp) {
        this.smith_xp = smith_xp;
        TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
    }
    public void increaseSmithXp(int add) {
        if (getSmithXp() + add <= getSmithMaxXp()) {
            setSmithXp(getSmithXp() + add);
            TFCComponents.PROFICIENCY_COMPONENT.sync(playerEntity);
        }
    }


    @Override
    public void serverTick() {
        if(getAgriXp() >= getAgriMaxXp() && getAgriLevel() < getAgriMaxLevel()){
            setAgriXp(0);
            setAgriLevel(getAgriLevel()+1);
        }
        if(getButchXp() >= getButchMaxXp() && getButchLevel() < getButchMaxLevel()){
            setButchXp(0);
            setButchLevel(getButchLevel()+1);
        }
        if(getCookXp() >= getCookMaxXp() && getCookLevel() < getCookMaxLevel()){
            setCookXp(0);
            setCookLevel(getCookLevel()+1);
        }
        if(getProsXp() >= getProsMaxXp() && getProsLevel() < getProsMaxLevel()){
            setProsXp(0);
            setProsLevel(getProsLevel()+1);
        }
        if(getSmithXp() >= getSmithMaxXp() && getSmithLevel() < getSmithMaxLevel()){
            setSmithXp(0);
            setSmithLevel(getSmithLevel()+1);
        }

    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        setAgriLevel(tag.getInt("agriculture_lvl"));
        setAgriXp(tag.getInt("agriculture_xp"));

        setButchLevel(tag.getInt("butchering_lvl"));
        setButchXp(tag.getInt("butchering_xp"));

        setCookLevel(tag.getInt("cooking_lvl"));
        setCookXp(tag.getInt("cooking_xp"));

        setProsLevel(tag.getInt("prospecting_lvl"));
        setProsXp(tag.getInt("prospecting_xp"));

        setSmithLevel(tag.getInt("smithing_lvl"));
        setSmithXp(tag.getInt("smithing_xp"));
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("agriculture_lvl", getAgriLevel());
        tag.putInt("agriculture_xp", getAgriXp());

        tag.putInt("butchering_lvl", getButchLevel());
        tag.putInt("butchering_xp", getButchXp());

        tag.putInt("cooking_lvl", getCookLevel());
        tag.putInt("cooking_xp", getCookXp());

        tag.putInt("prospecting_lvl", getProsLevel());
        tag.putInt("prospecting_xp", getProsXp());

        tag.putInt("smithing_lvl", getSmithLevel());
        tag.putInt("smithing_xp", getSmithXp());
    }
    public static ProficiencyComponent get(PlayerEntity obj) {
        return TFCComponents.PROFICIENCY_COMPONENT.get(obj);
    }

    public static Optional<ProficiencyComponent> maybeGet(PlayerEntity obj) {
        return TFCComponents.PROFICIENCY_COMPONENT.maybeGet(obj);
    }
}
