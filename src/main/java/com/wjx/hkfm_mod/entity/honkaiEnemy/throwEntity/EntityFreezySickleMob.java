package com.wjx.hkfm_mod.entity.honkaiEnemy.throwEntity;

import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class EntityFreezySickleMob extends EntityTippedArrow {
    public EntityFreezySickleMob(World a) {
        super(a);
    }

    public EntityFreezySickleMob(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityFreezySickleMob(World worldIn, EntityLivingBase shooter) {
        super(worldIn, shooter);
    }

    @Override
    protected void arrowHit(EntityLivingBase entity) {
        super.arrowHit(entity);
        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,60,2));
        double m =  entity.getEntityData().getDouble("honkai_freeze");

        if (entity.getEntityData().getDouble("honkai_freeze") < 0){
            entity.getEntityData().setDouble("honkai_freeze",0);
        }
        else if (entity.getEntityData().getDouble("honkai_freeze") + 100 >= 400){
            entity.getEntityData().setDouble("honkai_freeze",500);
        }
        else{
            entity.getEntityData().setDouble("honkai_freeze",entity.getEntityData().getDouble("honkai_freeze") + 100);
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        int x = (int) this.posX;
        int y = (int) this.posY;
        int z = (int) this.posZ;
        World world = this.world;
        Entity entity = (Entity) shootingEntity;
        if (this.inGround) {
            this.world.removeEntity(this);
        }
    }
}
