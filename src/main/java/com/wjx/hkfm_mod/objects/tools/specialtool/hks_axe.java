package com.wjx.hkfm_mod.objects.tools.specialtool;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.init.PotionInit;
import com.wjx.hkfm_mod.util.interfaces.IHasModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class hks_axe extends ItemAxe implements IHasModel {
    public hks_axe(Item.ToolMaterial material, CreativeTabs tabs){
        super(material,8,-3.0f);
        setUnlocalizedName("honkai_steel_axe");
        setRegistryName("honkai_steel_axe");
        setCreativeTab(tabs);

        Iteminit.ITEMS.add(this);
    }
    @Override
    public void registerModels(){
        hkfm_mod.proxy.registerItemRenderer(this,0,"inventory");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("info.hks_sword"));
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        target.addPotionEffect(new PotionEffect(PotionInit.EROSION,100));
        return super.hitEntity(stack,target,attacker);
    }
}
