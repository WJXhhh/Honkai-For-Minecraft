package com.wjx.hkfm_mod.init;

import com.wjx.hkfm_mod.potion.PotionErosion;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionInit {
    public static Potion EROSION = new PotionErosion();

    public static void registerPotion(){
        ForgeRegistries.POTIONS.register(EROSION);
    }
}
