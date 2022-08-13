package com.wjx.hkfm_mod.entity.Render;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityBlackLightDeathSpawnDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityDeathSpawnDeader;
import com.wjx.hkfm_mod.entityModel.blacklight_death_spawn_deader;
import com.wjx.hkfm_mod.entityModel.death_spawn_deader;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBlackLightDeathSpawnDeader extends RenderLiving<EntityBlackLightDeathSpawnDeader> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/custom/colour/black_purple.png");

    public RenderBlackLightDeathSpawnDeader(RenderManager manager){
        super(manager,new blacklight_death_spawn_deader(),0.5f);
        this.addLayer(new LayerHeldItem(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBlackLightDeathSpawnDeader entity) {
        return TEXTURE;
    }

    @Override
    protected void applyRotations(EntityBlackLightDeathSpawnDeader entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityBlackLightDeathSpawnDeader entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(4, 4, 16);
    }
}
