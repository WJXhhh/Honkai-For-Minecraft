package com.wjx.hkfm_mod.util.handlers;

import com.wjx.hkfm_mod.objects.blocks.special_block.HK_TileEntities;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntity(){
        GameRegistry.registerTileEntity(HK_TileEntities.TileEntity_hk_basic_grinder.class,"hk_basic_grinder");
        GameRegistry.registerTileEntity(HK_TileEntities.TileEntity_mt_b_injector.class,"mt_b_injector");
    }
}
