package com.wjx.hkfm_mod.objects.item;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood implements IHasModel {
    public FoodBase(String name, CreativeTabs tabs,int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tabs);
        Iteminit.ITEMS.add(this);
    }

    @Override
    public void registerModels(){
        hkfm_mod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
