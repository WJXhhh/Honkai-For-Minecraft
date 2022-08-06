package com.wjx.hkfm_mod.util.handlers;

import com.wjx.hkfm_mod.entity.Render.RenderSickleDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandle {
    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntitySickleDeader.class, new IRenderFactory<EntitySickleDeader>() {
            @Override
            public Render<? super EntitySickleDeader> createRenderFor(RenderManager manager) {
                return new RenderSickleDeader(manager);
            }
        });
    }
}
