package com.wjx.hkfm_mod.entity.Render;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityRangerDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderRangerDeader extends RenderLiving<EntityRangerDeader> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/ranger_deader.png");

    public RenderRangerDeader(RenderManager manager){
        super(manager,new ModelPlayer(0.5f,true),0.5f);
        this.addLayer(new LayerHeldItem(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRangerDeader entity) {
        return TEXTURE;
    }

    @Override
    protected void applyRotations(EntityRangerDeader entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
