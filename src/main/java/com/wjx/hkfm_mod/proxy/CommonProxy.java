package com.wjx.hkfm_mod.proxy;

import com.wjx.hkfm_mod.WorldEvent;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id){

    }
    public void registerVariantRenderer(Item item,int meta,String filename,String id){}

    public void init(FMLInitializationEvent event){
        new WorldEvent();
    }
}
