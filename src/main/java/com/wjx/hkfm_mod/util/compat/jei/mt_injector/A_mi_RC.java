package com.wjx.hkfm_mod.util.compat.jei.mt_injector;

import com.wjx.hkfm_mod.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class A_mi_RC<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/mt_injector.png");
    protected static final int input1 = 0;
    protected static final int input2 = 1;
    protected static final int output = 2;

    protected final IDrawableAnimated animatedArrow;


    protected A_mi_RC(IGuiHelper helper) {
        IDrawableStatic staticArrow = helper.createDrawable(TEXTURES,177,1,24,17);
        animatedArrow = helper.createAnimatedDrawable(staticArrow,100,IDrawableAnimated.StartDirection.LEFT,false);

    }
}
