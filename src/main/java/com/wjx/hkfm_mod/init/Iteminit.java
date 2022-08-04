package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.objects.item.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.wjx.hkfm_mod.hkfm_mod.honkai_tab;

public class Iteminit {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item HK_Fragment = new ItemBase("honkai_fragment",honkai_tab);
    public static final Item HK_DUST = new ItemBase("honkai_dust",honkai_tab);
    public static final Item HK_STEEL_INGOT = new ItemBase("honkai_steel_ingot",honkai_tab);
    public static final Item HKE_WIRE = new ItemBase("honkai_energy_wire",honkai_tab);
    public static final Item HKB_MODULE = new ItemBase("honkai_basic_module",honkai_tab);
    public static final Item B_GRINDER_MODULE = new ItemBase("basic_grinder_module",honkai_tab);
    public static final Item B_MT_INJECTOR = new ItemBase("basic_mt_injector_module",honkai_tab);


}
