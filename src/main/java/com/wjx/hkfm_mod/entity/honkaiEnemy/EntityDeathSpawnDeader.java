package com.wjx.hkfm_mod.entity.honkaiEnemy;

import com.wjx.hkfm_mod.init.EntityInit;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.init.PotionInit;
import com.wjx.hkfm_mod.util.handlers.LootTableHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;

public class EntityDeathSpawnDeader extends EntityMob {
    public EntityDeathSpawnDeader(World worldIn){
        super(worldIn);
        setNBT("skill_sum_dead",false);
        setNBT("skill_shooting",false);
        setNBT("skill_black_light",0);
        setSize(0.6f, 1.8f);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
    }

    @Override
    protected void initEntityAI() {
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, false));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.6, false));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.tasks.addTask(4, new EntityAIWander(this, 0.5));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.tasks.addTask(6, new EntityAISwimming(this));
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.DUTIFUL_NINJA_DEADER;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        World world = this.getEntityWorld();
        if (!world.isRemote){
            NBTTagCompound data = this.getEntityData();
            boolean getSkillSumDead = data.getBoolean("skill_sum_dead");
            boolean getSkillShooting = data.getBoolean("skill_shooting");
            int getSkillBlackLight = data.getInteger("skill_black_light");
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
            if (this.getActivePotionEffect(PotionInit.EROSION) != null){
                this.removePotionEffect(PotionInit.EROSION);
            }
            if (this.getAttackTarget() != null && !getSkillSumDead){
                Entity spawn = new EntitySickleDeader(world);
                Entity spawn1 = new EntitySickleDeader(world);
                spawn.setPosition(this.posX+0.5d,this.posY+1d,this.posZ+0.5d);
                spawn1.setPosition(this.posX+0.5d,this.posY+1d,this.posZ+0.5d);
                setNBT("skill_sum_dead",true);
                server.getPlayerList().sendMessage(new TextComponentString("It has been Target"));
                world.spawnEntity(spawn);
                world.spawnEntity(spawn1);
            }
            if (this.getAttackTarget() != null ){
                if (getSkillBlackLight >= 200){
                    setNBT("skill_shooting",true);
                }
                else setNBT("skill_black_light",getSkillBlackLight + 1);
            }
        }
    }

    private void setNBT(String key,Object value){
        if (HeFa(value)){
            if (PanDuan(value).equals("D")){
                this.getEntityData().setDouble(key,(double)value);
            }
            if (PanDuan(value).equals("B")){
                this.getEntityData().setBoolean(key,(boolean)value);
            }
            if (PanDuan(value).equals("S")){
                this.getEntityData().setString(key,(String) value);
            }
            if (PanDuan(value).equals("I")){
                this.getEntityData().setInteger(key,(Integer) value);
            }
        }

    }

    private String PanDuan(Object obj){
        if (obj instanceof Double){
            return "D";
        }
        else if (obj instanceof Boolean){
            return "B";
        }
        else if (obj instanceof Integer){
            return "I";
        }
        return "S";

    }

    private boolean HeFa(Object obj){
        if (obj instanceof Double || obj instanceof Boolean || obj instanceof String){
            return true;
        }
        return false;
    }
}
