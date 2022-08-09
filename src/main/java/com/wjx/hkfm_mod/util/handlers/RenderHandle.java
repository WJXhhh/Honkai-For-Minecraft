package com.wjx.hkfm_mod.util.handlers;

import com.wjx.hkfm_mod.entity.Render.*;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityDutifulNinjaDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityFreezySickleDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityRangerDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.throwEntity.EntityFreezySickleMob;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import com.wjx.hkfm_mod.objects.tools.specialtool.basic_bow;

import javax.annotation.Nullable;
import javax.swing.text.html.parser.Entity;

public class RenderHandle {
    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntitySickleDeader.class, new IRenderFactory<EntitySickleDeader>() {
            @Override
            public Render<? super EntitySickleDeader> createRenderFor(RenderManager manager) {
                return new RenderSickleDeader(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityRangerDeader.class, new IRenderFactory<EntityRangerDeader>() {
            @Override
            public Render<? super EntityRangerDeader> createRenderFor(RenderManager manager) {
                return new RenderRangerDeader(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityFreezySickleDeader.class, new IRenderFactory<EntityFreezySickleDeader>() {
            @Override
            public Render<? super EntityFreezySickleDeader> createRenderFor(RenderManager manager) {
                return new RenderFreezySickleDeader(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityFreezySickleMob.class, new IRenderFactory<EntityFreezySickleMob>() {
            @Override
            public Render<? super EntityFreezySickleMob> createRenderFor(RenderManager manager) {
                return new RenderEntityFreezySickleMob(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityDutifulNinjaDeader.class, new IRenderFactory<EntityDutifulNinjaDeader>() {
            @Override
            public Render<? super EntityDutifulNinjaDeader> createRenderFor(RenderManager manager) {
                return new RenderDutifulNinjaDeader(manager);
            }
        });
        new regplayer<EntityFreezySickleDeader>(EntityFreezySickleDeader.class,new ResourceLocation(Reference.MODID + ":textures/entity/freezy_sickle_deader.png"));

    }
    private static class regplayer<T1 extends EntityLiving>{
        Class c;
        public static ResourceLocation TEXTURE;
        public regplayer(Class<? extends EntityLiving> c,ResourceLocation res){
            this.c = c;
            TEXTURE = res;
        }
        {
            RenderingRegistry.registerEntityRenderingHandler(c, new IRenderFactory<T1>() {
                @Override
                public Render<? super T1> createRenderFor(RenderManager manager) {
                    return new RenderHandlerHelper.RenderLivingPlayerModHeldItem<>(manager, TEXTURE);
                    }
                });
            };
        }

}
