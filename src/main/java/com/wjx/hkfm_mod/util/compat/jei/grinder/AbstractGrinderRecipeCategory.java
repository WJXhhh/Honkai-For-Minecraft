package com.wjx.hkfm_mod.util.compat.jei.grinder;

import com.wjx.hkfm_mod.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractGrinderRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/hk_basic_grinder.png");
    protected static final int input = 0;
    protected static final int output = 1;

    protected final IDrawableAnimated animatedArrow;


    protected AbstractGrinderRecipeCategory(IGuiHelper helper) {
            IDrawableStatic staticArrow = helper.createDrawable(TEXTURES,177,1,24,17);
        animatedArrow = helper.createAnimatedDrawable(staticArrow,100,IDrawableAnimated.StartDirection.LEFT,false);

    }
}
