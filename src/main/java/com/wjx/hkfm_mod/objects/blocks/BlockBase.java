package com.wjx.hkfm_mod.objects.blocks;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.BlockInit;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material, CreativeTabs tabs){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tabs);
        BlockInit.Blocks.add(this);
        Iteminit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels(){
        hkfm_mod.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");

    }
}
