package com.wjx.hkfm_mod.util.compat.jei;

import com.wjx.hkfm_mod.objects.blocks.special_block.HK_Container;
import com.wjx.hkfm_mod.objects.gui.HK_gui;
import com.wjx.hkfm_mod.util.compat.jei.grinder.GrinderRecipeCategory;
import com.wjx.hkfm_mod.util.compat.jei.grinder.GrinderRecipeMaker;
import com.wjx.hkfm_mod.util.compat.jei.mt_injector.mi_RC;
import com.wjx.hkfm_mod.util.compat.jei.mt_injector.mi_RM;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.client.resources.I18n;

import java.util.IllegalFormatException;

import static net.minecraft.util.text.translation.I18n.canTranslate;
import static net.minecraft.util.text.translation.I18n.translateToFallback;

@JEIPlugin
public class JEICompat implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers helpers = registry.getJeiHelpers();
        final IGuiHelper gui = helpers.getGuiHelper();

        registry.addRecipeCategories(new GrinderRecipeCategory(gui));
        registry.addRecipeCategories(new mi_RC(gui));
    }

    @Override
    public void register(IModRegistry registry) {
        final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();

        registry.addRecipes(GrinderRecipeMaker.getRecipes(jeiHelpers),RecipesCategories.GRINDER);
        registry.addRecipes(mi_RM.getRecipes(jeiHelpers),RecipesCategories.MT_INJECTOR);
        recipeTransfer.addRecipeTransferHandler(HK_Container.ContainerHk_basic_grinder.class,RecipesCategories.GRINDER,0,1,3,36);
        recipeTransfer.addRecipeTransferHandler(HK_Container.ContainerMtInjector.class,RecipesCategories.MT_INJECTOR,0,1,3,36);
    }

    public static String translateToLocal(String key){
        if(canTranslate(key)) return translateToLocal(key);
        else return translateToFallback(key);
    }

    public static String translateToLocalFormatted(String key,Object... format){
        String s = translateToLocal(key);
        try {
            return String.format(s,format);
        }catch (IllegalFormatException e){
            return "Format Error:"+s ;
        }
    }
}
