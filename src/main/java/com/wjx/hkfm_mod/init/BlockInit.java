package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.objects.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

import static com.wjx.hkfm_mod.hkfm_mod.honkai_tab;

public class BlockInit {
    public static final List<Block> Blocks = new ArrayList<>();

    public static final Block BLOCKS_STONE_FOR_HONKAI = new BlockBase("stone_for_honkai", Material.ROCK,honkai_tab);
}
