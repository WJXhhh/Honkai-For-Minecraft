package com.wjx.hkfm_mod.entity.Render;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSickleDeader extends RenderLiving<EntitySickleDeader> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/sickle_deader.png");

    public RenderSickleDeader(RenderManager manager){
        super(manager,new ModelPlayer(0.5f,true),0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySickleDeader entity) {
        return TEXTURE;
    }

    @Override
    protected void applyRotations(EntitySickleDeader entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
