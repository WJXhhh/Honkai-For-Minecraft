package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.objects.item.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.wjx.hkfm_mod.hkfm_mod.honkai_tab;

public class Iteminit {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item HK_Fragment = new ItemBase("honkai_fragment",honkai_tab);
    public static final Item HKE_WIRE = new ItemBase("honkai_energy_wire",honkai_tab);


}
