package com.wjx.hkfm_mod.util.handlers;

import com.wjx.hkfm_mod.objects.blocks.special_block.HK_Container;
import com.wjx.hkfm_mod.objects.blocks.special_block.HK_TileEntities;
import com.wjx.hkfm_mod.objects.gui.HK_gui;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {


    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID== Reference.GUI_HKB_GRINDER) return new HK_Container.ContainerHk_basic_grinder(player.inventory,(HK_TileEntities.TileEntity_hk_basic_grinder) world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID== Reference.GUI_HKB_GRINDER) return new HK_gui.GuiHk_basic_grinder(player.inventory,(HK_TileEntities.TileEntity_hk_basic_grinder) world.getTileEntity(new BlockPos(x,y,z)));

        return null;
    }
}
