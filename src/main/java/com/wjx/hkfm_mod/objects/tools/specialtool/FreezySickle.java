package com.wjx.hkfm_mod.objects.tools.specialtool;

import com.wjx.hkfm_mod.objects.tools.MeleeWeaponBase;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class FreezySickle extends MeleeWeaponBase {
    public FreezySickle(String name, int maxUse, float damage, CreativeTabs tabs, int enchant, double attackSpeed) {
        super(name, maxUse, damage, tabs, enchant, attackSpeed);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,60,2));
        double m =  target.getEntityData().getDouble("honkai_freeze");
        MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (mcserv != null)
        mcserv.getPlayerList().sendMessage(new TextComponentString(String.valueOf(m)));

        if (target.getEntityData().getDouble("honkai_freeze") < 0){
            target.getEntityData().setDouble("honkai_freeze",0);
        }
        else if (target.getEntityData().getDouble("honkai_freeze") + 100 >= 400){
            target.getEntityData().setDouble("honkai_freeze",500);
        }
        else{
            target.getEntityData().setDouble("honkai_freeze",target.getEntityData().getDouble("honkai_freeze") + 100);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
