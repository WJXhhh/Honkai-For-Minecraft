package com.wjx.hkfm_mod.entity.honkaiEnemy;

import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.init.PotionInit;
import com.wjx.hkfm_mod.util.handlers.LootTableHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityRangerDeader extends EntityMob implements IRangedAttackMob {
    public EntityRangerDeader(World worldIn){
        super(worldIn);
        setSize(0.6f, 1.8f);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Iteminit.BASIC_BOW, (int) (1)));
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
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, (float) 10));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 0.5, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
        this.tasks.addTask(5, new EntityAIWander(this, 0.5));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackRanged(this, 0.6, 60, 10.0F));
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.RANGER_DEADER;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (this.getActivePotionEffect(PotionInit.EROSION) != null){
            this.removePotionEffect(PotionInit.EROSION);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        EntityTippedArrow entityarrow = new EntityTippedArrow(this.world, this);
        double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
        double d1 = target.posX - this.posX;
        double d3 = target.posZ - this.posZ;
        entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
        entityarrow.setDamage(3);
        this.world.spawnEntity(entityarrow);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {

    }
}
