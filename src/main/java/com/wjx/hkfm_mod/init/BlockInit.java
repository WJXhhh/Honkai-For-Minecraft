package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.objects.blocks.BlockBase;
import com.wjx.hkfm_mod.objects.blocks.BlockOres;
import com.wjx.hkfm_mod.objects.blocks.special_block.HK_Ores;
import com.wjx.hkfm_mod.objects.blocks.special_block.HK_machines;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

import static com.wjx.hkfm_mod.hkfm_mod.honkai_tab;

public class BlockInit {
    public static final List<Block> Blocks = new ArrayList<>();

    public static final Block BLOCKS_STONE_FOR_HONKAI = new HK_Ores.HK_ORE_stone_for_honkai("stone_for_honkai", Material.ROCK,honkai_tab);
    public static final Block HOLY_BLOOD_ORE = new HK_Ores.HK_ORE_HolyBloodOre("holy_blood_ore",Material.ROCK,honkai_tab);

    public static final Block HK_B_GRINDER = new HK_machines.hk_basic_grinder("hk_basic_grinder",honkai_tab);

    public static final Block MT_B_INJECTOR = new HK_machines.mt_b_injector("mt_b_injector",honkai_tab);


}
