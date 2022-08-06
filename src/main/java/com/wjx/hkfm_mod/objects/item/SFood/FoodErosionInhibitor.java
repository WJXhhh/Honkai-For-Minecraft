package com.wjx.hkfm_mod.objects.item.SFood;

import com.wjx.hkfm_mod.init.PotionInit;
import com.wjx.hkfm_mod.objects.item.FoodBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FoodErosionInhibitor extends FoodBase {
    public FoodErosionInhibitor(String name, CreativeTabs tabs, int amount, float saturation, boolean isWolfFood) {
        super(name, tabs, amount, saturation, isWolfFood);
        setAlwaysEdible();
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 10;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.EAT;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack,worldIn,player);
        if (player.getActivePotionEffect(PotionInit.EROSION)!= null){
            player.removePotionEffect(PotionInit.EROSION);
            player.removeActivePotionEffect(PotionInit.EROSION);
        }
    }


}
