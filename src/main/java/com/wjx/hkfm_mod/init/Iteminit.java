package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.objects.item.ItemBase;
import static com.wjx.hkfm_mod.objects.tools.normalTools.*;

import com.wjx.hkfm_mod.objects.item.SFood.FoodErosionInhibitor;
import com.wjx.hkfm_mod.objects.tools.specialtool.hks_axe;
import com.wjx.hkfm_mod.objects.tools.specialtool.hks_sword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

import static com.wjx.hkfm_mod.hkfm_mod.honkai_tab;

public class Iteminit {
    public static List<Item> ITEMS = new ArrayList<>();

    public static final Item.ToolMaterial TOOL_HONKAI_STEEL = EnumHelper.addToolMaterial("tool_honkai_steel",3,500,8.0f,2.5f,14);

    public static final Item HK_Fragment = new ItemBase("honkai_fragment",honkai_tab);
    public static final Item HK_DUST = new ItemBase("honkai_dust",honkai_tab);
    public static final Item HK_STEEL_INGOT = new ItemBase("honkai_steel_ingot",honkai_tab);
    public static final Item HKE_WIRE = new ItemBase("honkai_energy_wire",honkai_tab);
    public static final Item HKB_MODULE = new ItemBase("honkai_basic_module",honkai_tab);
    public static final Item B_GRINDER_MODULE = new ItemBase("basic_grinder_module",honkai_tab);
    public static final Item B_MT_INJECTOR = new ItemBase("basic_mt_injector_module",honkai_tab);
    public static final Item FLOUR = new ItemBase("flour",honkai_tab);
    public static final Item FLOUR_PLACE = new ItemBase("flour_place",honkai_tab);
    public static final Item HOLY_BLOOD = new ItemBase("holy_blood",honkai_tab);

    public static final Item HKS_HOE = new ToolHoe("honkai_steel_hoe",TOOL_HONKAI_STEEL,honkai_tab);
    public static final Item HKS_PICKAXE = new ToolPickaxe("honkai_steel_pickaxe",TOOL_HONKAI_STEEL,honkai_tab);
    public static final Item HKS_SHOVEL = new ToolShovel("honkai_steel_shovel",TOOL_HONKAI_STEEL,honkai_tab);
    public static final Item HKS_SWORD = new hks_sword(TOOL_HONKAI_STEEL,honkai_tab);
    public static final Item HKS_AXE = new hks_axe(TOOL_HONKAI_STEEL,honkai_tab);

    public static final ItemFood EROSION_INHIBITOR = new FoodErosionInhibitor("erosion_inhibitor",honkai_tab,1,1,false);

}
