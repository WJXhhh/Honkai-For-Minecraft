package com.wjx.hkfm_mod.util.handlers;

import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHandlerHelper {
    public static class RenderLivingPlayerModHeldItem<T extends EntityLiving> extends RenderLiving<T> {
        public static ResourceLocation TEXTURE;


        public RenderLivingPlayerModHeldItem(RenderManager manager,ResourceLocation res){
            super(manager,new ModelPlayer(0,true),0.5f);
            TEXTURE = res;
            this.addLayer(new LayerHeldItem(this));
        }

        @Nullable
        @Override
        protected ResourceLocation getEntityTexture(T entity) {
            return TEXTURE;
        }

        @Override
        protected void applyRotations(T entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
            super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        }
    }
}

