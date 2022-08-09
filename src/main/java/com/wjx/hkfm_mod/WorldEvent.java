package com.wjx.hkfm_mod;

import com.wjx.hkfm_mod.entity.honkaiEnemy.EntityFreezySickleDeader;
import com.wjx.hkfm_mod.init.PotionInit;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class WorldEvent {
    @SubscribeEvent
    public static void Honkai_Freeze(LivingEvent.LivingUpdateEvent event){
        if (event.getEntityLiving() != null){
            double x = event.getEntityLiving().posX;
            double y = event.getEntityLiving().posY;
            double z = event.getEntityLiving().posZ;
            World world = event.getEntityLiving().world;
            if (event.getEntityLiving().getEntityData().getDouble("honkai_freeze") >= 0 && event.getEntityLiving().getEntityData().getDouble("honkai_freeze") < 5){
                event.getEntityLiving().getEntityData().setDouble("honkai_freeze",0);
            }
            else if (event.getEntityLiving().getEntityData().getDouble("honkai_freeze") >= 400){
                event.getEntityLiving().getEntityData().setDouble("honkai_freeze",0);
                event.getEntityLiving().motionX = 0;
                event.getEntityLiving().motionY = 0;
                event.getEntityLiving().motionZ = 0;
                int xI = new Double(Math.floor(x)).intValue();
                int yI = new Double(Math.floor(y)).intValue();
                int zI = new Double(Math.floor(z)).intValue();
                world.setBlockState(new BlockPos(xI, yI, zI), Blocks.ICE.getDefaultState());
                world.setBlockState(new BlockPos(xI, yI +1, zI), Blocks.ICE.getDefaultState());
                if (!(world.getBlockState(new BlockPos(xI,yI,zI)) == Blocks.ICE.getDefaultState())){
                    world.setBlockState(new BlockPos(xI, yI, zI), Blocks.ICE.getDefaultState());
                    world.setBlockState(new BlockPos(xI, yI +1, zI), Blocks.ICE.getDefaultState());
                }
            }
            else if (!(event.getEntityLiving().getEntityData().getDouble("honkai_freeze") < 5)){
                event.getEntityLiving().getEntityData().setDouble("honkai_freeze",event.getEntityLiving().getEntityData().getDouble("honkai_freeze")-5);
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerHurt(LivingEvent.LivingUpdateEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer){
            if (entity.getEntityData().getDouble("honkai_freeze") > 0){
                ((EntityPlayer) entity).sendStatusMessage(new TextComponentString(I18n.format("nbt.honkai_freeze" )+ ":"+String.valueOf((int)((entity.getEntityData().getDouble("honkai_freeze"))/4))+"%"), (true));
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerBeAttacked(LivingAttackEvent event){
        Entity entity = event.getEntity();
        Entity sourceentity = event.getSource().getTrueSource();
        Entity immediateentity = event.getSource().getImmediateSource();
        if (entity instanceof EntityPlayer){
            if (sourceentity instanceof EntityFreezySickleDeader){
                ((EntityPlayer)entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,60,2));

                if (entity.getEntityData().getDouble("honkai_freeze") < 0){
                    entity.getEntityData().setDouble("honkai_freeze",0);
                }
                else if (entity.getEntityData().getDouble("honkai_freeze") + 250 >= 400){
                    entity.getEntityData().setDouble("honkai_freeze",500);
                }
                else{
                    entity.getEntityData().setDouble("honkai_freeze",entity.getEntityData().getDouble("honkai_freeze") + 250);
                }
            }
        }
    }
}
