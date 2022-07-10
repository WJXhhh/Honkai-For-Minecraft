package com.wjx.hkfm_mod.objects.item;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.util.IHasModel;
import com.wjx.hkfm_mod.init.Iteminit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);

        Iteminit.ITEMS.add(this);
    }

    @Override
    public void registerModels(){
        hkfm_mod.proxy.registerItemRenderer(this,0,"inventory");

    }
}
