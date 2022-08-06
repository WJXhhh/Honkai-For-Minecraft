package com.wjx.hkfm_mod.potion;

import com.wjx.hkfm_mod.Honkai_DamageSource;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static com.wjx.hkfm_mod.hkfm_mod.logger;

public class PotionErosion extends Potion {
    public PotionErosion(){
        super(true,16726428);
        setPotionName("effect.erosion");
        setIconIndex(0,0);
        setRegistryName(new ResourceLocation(Reference.MODID+":erosion"));
    }

    @Override
    public boolean hasStatusIcon() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/potion/erosion.png"));
        return true;
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        super.performEffect(entityLivingBaseIn,amplifier);
        entityLivingBaseIn.attackEntityFrom(Honkai_DamageSource.Erosion,1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
        if (mc.currentScreen != null) {
            mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/potion/erosion.png"));
            Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
        mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/potion/erosion.png"));
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
