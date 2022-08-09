package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityDutifulNinjaDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityFreezySickleDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityRangerDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.EntitySickleDeader;
import com.wjx.hkfm_mod.entity.honkaiEnemy.throwEntity.EntityFreezySickleMob;
import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.objects.tools.specialtool.basic_bow;
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
        Biome[] spawnBiomes1 = {Biome.REGISTRY.getObject(new ResourceLocation("plains")),
                Biome.REGISTRY.getObject(new ResourceLocation("extreme_hills")), Biome.REGISTRY.getObject(new ResourceLocation("forest")),
                Biome.REGISTRY.getObject(new ResourceLocation("taiga")), Biome.REGISTRY.getObject(new ResourceLocation("river")),
                Biome.REGISTRY.getObject(new ResourceLocation("beaches")), Biome.REGISTRY.getObject(new ResourceLocation("jungle")),};
        Biome[] spawnBiomesIce = {Biome.REGISTRY.getObject(new ResourceLocation("ice_flats")),
                Biome.REGISTRY.getObject(new ResourceLocation("ice_mountains")),};
        registerEntity("sickle_deader", EntitySickleDeader.class,Reference.ENTITY_SICKLE_DEADER,50,34122243,34122242);
        registerEntity("ranger_deader", EntityRangerDeader.class,Reference.ENTITY_RANGER_DEADER,50,34122243,34122242);
        registerEntity("freezy_sickle_deader", EntityFreezySickleDeader.class,Reference.ENTITY_FREEZY_SICKLE_DEADER,50,34122243,34122242);
        registerEntity("freezy_sickle_mob", EntityFreezySickleMob.class,Reference.ENTITY_FREEZY_SICKLE_MOB,50);
        registerEntity("dutiful_ninja_deader", EntityDutifulNinjaDeader.class,Reference.ENTITY_DUTIFUL_NINJA_DEADER,50,34122243,34122242);
        registerEntitySpawn(EntitySickleDeader.class,13,1,2,EnumCreatureType.MONSTER,spawnBiomes1);
        registerEntitySpawn(EntityRangerDeader.class,13,1,2,EnumCreatureType.MONSTER,spawnBiomes1);
        registerEntitySpawn(EntityDutifulNinjaDeader.class,13,1,2,EnumCreatureType.MONSTER,spawnBiomes1);
        registerEntitySpawn(EntityFreezySickleDeader.class,13,1,2,EnumCreatureType.MONSTER,spawnBiomesIce);

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
    private static void registerEntity(String name, Class<? extends Entity> entity, int id,int range){
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name),entity,name,id, hkfm_mod.instance,range,1,true);
    }


}
