package com.wjx.hkfm_mod.entity.honkaiEnemy;

import com.wjx.hkfm_mod.entity.honkaiEnemy.throwEntity.EntityFreezySickleMob;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.init.PotionInit;
import com.wjx.hkfm_mod.util.handlers.LootTableHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityFreezySickleDeader extends EntityMob {
    public EntityFreezySickleDeader(World worldIn){
        super(worldIn);
        setSize(0.6f, 1.8f);
        setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Iteminit.BASIC_SICKLE,1));
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Iteminit.FREEZY_SICKLE, (int) (1)));
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
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2D);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.6, false));
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
        return LootTableHandler.FREEZY_SICKLE_DEADER;
    }

    {
        this.getEntityData().setDouble("skill",0);
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        NBTTagCompound data = this.getEntityData();
        if (this.getActivePotionEffect(PotionInit.EROSION) != null){
            this.removePotionEffect(PotionInit.EROSION);
        }
        if (data.getDouble("skill") >= 200){
            data.setDouble("skill",0);
            if (this.getAttackTarget() != null){
                EntityFreezySickleMob entityarrow = new EntityFreezySickleMob(this.world, this);
                entityarrow.shoot(this.getLookVec().x, this.getLookVec().y, this.getLookVec().z, 1.6F, 12.0F);
                entityarrow.setDamage(3);
                this.world.spawnEntity(entityarrow);
            }
        }
        else {
            data.setDouble("skill",data.getDouble("skill")+1);
        }
    }
}
