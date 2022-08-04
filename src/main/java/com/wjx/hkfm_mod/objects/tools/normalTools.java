package com.wjx.hkfm_mod.objects.tools;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;

public class normalTools {
    public static class ToolHoe extends ItemHoe implements IHasModel{
        public ToolHoe(String name, ToolMaterial material, CreativeTabs tabs){
            super(material);
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
    public static class ToolAxe extends ItemAxe implements IHasModel{
        public ToolAxe(String name, ToolMaterial material, CreativeTabs tabs){
            super(material);
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
    public static class ToolPickaxe extends ItemPickaxe implements IHasModel{
        public ToolPickaxe(String name, ToolMaterial material, CreativeTabs tabs){
            super(material);
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
    public static class ToolSword extends ItemSword implements IHasModel{
        public ToolSword(String name, ToolMaterial material, CreativeTabs tabs){
            super(material);
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

    public static class ToolShovel extends ItemSpade implements IHasModel{
        public ToolShovel(String name, ToolMaterial material, CreativeTabs tabs){
            super(material);
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

}
