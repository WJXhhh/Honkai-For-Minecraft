package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities(){
        Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("plains")),
                Biome.REGISTRY.getObject(new ResourceLocation("extreme_hills")), Biome.REGISTRY.getObject(new ResourceLocation("forest")),
                Biome.REGISTRY.getObject(new ResourceLocation("taiga")), Biome.REGISTRY.getObject(new ResourceLocation("river")),
                Biome.REGISTRY.getObject(new ResourceLocation("beaches")), Biome.REGISTRY.getObject(new ResourceLocation("jungle")),};
        registerEntity("sickle_deader", EntitySickleDeader.class,Reference.ENTITY_SICKLE_DEADER,50,34122243,34122242);
        registerEntitySpawn(EntitySickleDeader.class,13,1,2,EnumCreatureType.MONSTER,spawnBiomes);

    }

    //range ：追踪范围
    private static void registerEntity(String name, Class<? extends Entity> entity, int id,int range,int color1,int color2){
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name),entity,name,id, hkfm_mod.instance,range,1,true,color1,color2);
    }

    private static void registerEntitySpawn(Class<? extends Entity> entityClass, int spawnWeight, int min, int max, EnumCreatureType typeOfCreature, Biome... biomes)
    {
        if (EntityLiving.class.isAssignableFrom(entityClass))
        {
            Class<? extends EntityLiving> entityLivingClass = entityClass.asSubclass(EntityLiving.class);
            EntityRegistry.addSpawn(entityLivingClass, spawnWeight, min, max, typeOfCreature, biomes);
        }
    }
}
