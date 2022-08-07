package com.wjx.hkfm_mod.objects.tools;

import com.google.common.collect.Multimap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.common.util.EnumHelper;

public class MeleeWeaponBase extends normalTools.ToolSword{
    private final double attackSpeed;
    public MeleeWeaponBase(String name,int maxUse,float damage, CreativeTabs tabs, int enchant,double attackSpeed) {
        super(name, EnumHelper.addToolMaterial(name,3,maxUse,4,damage - 4f,enchant), tabs);
        this.attackSpeed = attackSpeed - 4;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.remove(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.attackSpeed, 0));
        }
        return multimap;
    }
}
