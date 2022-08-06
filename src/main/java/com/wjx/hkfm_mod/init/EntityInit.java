package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities(){
        registerEntity("sickle_deader", EntitySickleDeader.class,Reference.ENTITY_SICKLE_DEADER,50,34122243,34122242);
    }

    //range ：追踪范围
    private static void registerEntity(String name, Class<? extends Entity> entity, int id,int range,int color1,int color2){
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name),entity,name,id, hkfm_mod.instance,range,1,true,color1,color2);
    }
}
