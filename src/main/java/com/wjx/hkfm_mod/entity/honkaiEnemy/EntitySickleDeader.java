package com.wjx.hkfm_mod.entity.honkaiEnemy;

import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.init.PotionInit;
import com.wjx.hkfm_mod.util.Reference;
import com.wjx.hkfm_mod.util.handlers.LootTableHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntitySickleDeader extends EntityMob {
    public EntitySickleDeader(World worldIn){
        super(worldIn);
        setSize(0.6f, 1.8f);
        setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Iteminit.BASIC_SICKLE,1));
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Iteminit.BASIC_SICKLE, (int) (1)));
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
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(-6D);
    }

    @Override
    protected void initEntityAI() {
        /*super.initEntityAI();
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.7f, false));
        this.tasks.addTask(2,new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, false));
        this.tasks.addTask(3, new EntityAIWander(this, 0.7f));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAISwimming(this));*/
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.5, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, false));
        this.tasks.addTask(4, new EntityAIWander(this, 0.5));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
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
        return LootTableHandler.SICKLE_DEADER;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (this.getActivePotionEffect(PotionInit.EROSION) != null){
            this.removePotionEffect(PotionInit.EROSION);
        }
    }


}
