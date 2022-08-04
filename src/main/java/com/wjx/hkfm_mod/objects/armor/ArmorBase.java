package com.wjx.hkfm_mod.objects.armor;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.util.interfaces.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import static com.wjx.hkfm_mod.hkfm_mod.honkai_tab;

public class ArmorBase extends ItemArmor implements IHasModel {
    public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn){
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(honkai_tab);

        Iteminit.ITEMS.add(this);

    }

    @Override
    public void registerModels(){
        hkfm_mod.proxy.registerItemRenderer(this,0,"inventory");

    }

}
