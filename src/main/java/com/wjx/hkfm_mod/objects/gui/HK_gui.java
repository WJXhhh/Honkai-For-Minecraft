package com.wjx.hkfm_mod.objects.gui;

import com.wjx.hkfm_mod.objects.blocks.special_block.HK_Container;
import com.wjx.hkfm_mod.objects.blocks.special_block.HK_TileEntities;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class HK_gui{

    public static class GuiHk_basic_grinder extends GuiContainer {
        private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/hk_basic_grinder.png");
        private final InventoryPlayer player;
        private final HK_TileEntities.TileEntity_hk_basic_grinder tileentity;

        public GuiHk_basic_grinder(InventoryPlayer player, HK_TileEntities.TileEntity_hk_basic_grinder tileentity) {
            super(new HK_Container.ContainerHk_basic_grinder(player,tileentity));
            this.player = player;
            this.tileentity = tileentity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
            String tileName =this.tileentity.getDisplayName().getUnformattedComponentText();
            this.fontRenderer.drawString(tileName,((this.xSize/2 -this.fontRenderer.getStringWidth(tileName)/2)+3),8,4210752);
            this.renderHoveredToolTip(mouseX,mouseY);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
            GlStateManager.color(1.0f,1.0f,1.0f);
            this.mc.getTextureManager().bindTexture(TEXTURES);
            this.drawTexturedModalRect(this.guiLeft,this.guiTop,0,0,this.xSize,this.ySize);

            int l =this.getCookProgressScaled(24);
            this.drawTexturedModalRect(this.guiLeft + 65,this.guiTop + 42,176,1,l+1,16);

        }

        private int getCookProgressScaled(int pixels){
            int i = this.tileentity.getField(0);
            int j = this.tileentity.getField(1);
            return j != 0 && i != 0? i * pixels / j : 0;
        }
    }



}
