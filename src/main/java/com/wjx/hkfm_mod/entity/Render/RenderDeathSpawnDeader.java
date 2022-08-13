package com.wjx.hkfm_mod.entity.Render;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityDeathSpawnDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import com.wjx.hkfm_mod.entityModel.death_spawn_deader;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDeathSpawnDeader extends RenderLiving<EntityDeathSpawnDeader> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/deathspwndeader_mob.png");

    public RenderDeathSpawnDeader(RenderManager manager){
        super(manager,new death_spawn_deader(),0.5f);
        this.addLayer(new LayerHeldItem(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDeathSpawnDeader entity) {
        return TEXTURE;
    }

    @Override
    protected void applyRotations(EntityDeathSpawnDeader entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
