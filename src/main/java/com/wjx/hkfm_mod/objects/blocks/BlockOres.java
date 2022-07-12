package com.wjx.hkfm_mod.objects.blocks;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.BlockInit;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.objects.blocks.item.ItemBlockVariants;
import com.wjx.hkfm_mod.util.handlers.EnumHandler;
import com.wjx.hkfm_mod.util.interfaces.IHasModel;
import com.wjx.hkfm_mod.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockOres extends Block implements IHasModel, IMetaName {
    public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant",EnumHandler.EnumType.class);

    private String name,dimension;
    public BlockOres(String name, String dimension, CreativeTabs tabs){
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tabs);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT,EnumHandler.EnumType.STONE_FOR_HONKAI));

        this.name=name;
        this.dimension=dimension;

        BlockInit.Blocks.add(this);
        Iteminit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int damageDropped(IBlockState state){
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(VARIANT,EnumHandler.EnumType.byMetaData(meta));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
        return new ItemStack(Item.getItemFromBlock(this),1,getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{VARIANT});
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items){
        for (EnumHandler.EnumType variant : EnumHandler.EnumType.values()){
            items.add(new ItemStack(this,1,variant.getMeta()));
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels(){
        for (int i =0;i<EnumHandler.EnumType.values().length;i++){
            hkfm_mod.proxy.registerVariantRenderer(Item.getItemFromBlock(this),i,"ore_"+this.dimension+"_"+EnumHandler.EnumType.values()[i].getName(),"inventory");

        }

    }

}
