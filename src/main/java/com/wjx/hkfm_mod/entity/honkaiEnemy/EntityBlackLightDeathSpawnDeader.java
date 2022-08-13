package com.wjx.hkfm_mod.entity.honkaiEnemy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityBlackLightDeathSpawnDeader extends EntityMob {
    public EntityBlackLightDeathSpawnDeader(World worldIn) {
        super(worldIn);
        this.getEntityData().setInteger("alive_time",0);
        setNoGravity(true);
        setSize(1f,1f);
    }
    @Override
    public boolean attackable() {
        return false;
    }


    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    @Override
    public EnumHandSide getPrimaryHand() {
        return null;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {
        super.onCollideWithPlayer(entityIn);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return false;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        NBTTagCompound data = this.getEntityData();
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
        if (data.getInteger("alive_time") >= 160){
            this.setDead();
        }
        else {
             this.getEntityData().setInteger("alive_time",data.getInteger("alive_time") + 1);
        }
    }

    @Override
    public void faceEntity(Entity entityIn, float maxYawIncrease, float maxPitchIncrease) {

    }

    @Override
    public void setPosition(double x, double y, double z) {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        if (this.isAddedToWorld() && !this.world.isRemote) this.world.updateEntityWithOptionalForce(this, false); // Forge - Process chunk registration after moving.
        float f = this.width / 2.0F;
        float f1 = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(x - (double)f, y, z-8, x + (double)f, y + (double)f1, z + 8));
    }
}
