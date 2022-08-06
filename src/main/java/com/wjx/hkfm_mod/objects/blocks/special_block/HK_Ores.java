package com.wjx.hkfm_mod.objects.blocks.special_block;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.objects.blocks.BlockBase;
import com.wjx.hkfm_mod.util.interfaces.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;
import java.util.Random;

public class HK_Ores {
    public static class HK_ORE_stone_for_honkai extends BlockBase implements IHasModel {

        public HK_ORE_stone_for_honkai(String name, Material material, CreativeTabs tabs) {
            super(name, material, tabs);
            this.setHardness(2.5F);
            this.setHarvestLevel("pickaxe", 1);
        }

        @Nonnull
        @Override
        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Iteminit.HK_Fragment;
        }

        // SRG func_149745_a，用于决定掉落的物品数量
        @Override
        public int quantityDropped(Random random) {
            return 1;
        }

        // SRG func_149679_a，用于决定受时运影响时掉落的物品数量
        @Override
        public int quantityDroppedWithBonus(int fortune, Random random) {
            if (fortune > 0) {
                int bonusFactor = Math.max(random.nextInt(fortune + 2) - 1, 0);
                return this.quantityDropped(random) * (bonusFactor + 1);
            } else {
                return this.quantityDropped(random);
            }
        }

        @Override
        public void registerModels(){
            hkfm_mod.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");

        }
    }
    public static class HK_ORE_HolyBloodOre extends BlockBase implements IHasModel {
        public HK_ORE_HolyBloodOre(String name, Material material, CreativeTabs tabs) {
            super(name, material, tabs);
            this.setHardness(2.5F);
            this.setHarvestLevel("pickaxe", 1);
        }

        @Nonnull
        @Override
        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Iteminit.HOLY_BLOOD;
        }

        // SRG func_149745_a，用于决定掉落的物品数量
        @Override
        public int quantityDropped(Random random) {
            return 1;
        }

        // SRG func_149679_a，用于决定受时运影响时掉落的物品数量
        @Override
        public int quantityDroppedWithBonus(int fortune, Random random) {
            if (fortune > 0) {
                int bonusFactor = Math.max(random.nextInt(fortune + 2) - 1, 0);
                return this.quantityDropped(random) * (bonusFactor + 1);
            } else {
                return this.quantityDropped(random);
            }
        }
    }
}
