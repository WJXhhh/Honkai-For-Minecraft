package com.wjx.hkfm_mod.tabs;

import com.wjx.hkfm_mod.init.Iteminit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class honkai_tab extends CreativeTabs {
    public honkai_tab(String label) {
        super("honkai_tab");
    }

    public ItemStack getTabIconItem(){
        return new ItemStack(Iteminit.HK_Fragment);
    }
}
