package com.wjx.hkfm_mod.objects.blocks.special_block;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.BlockInit;
import com.wjx.hkfm_mod.objects.blocks.BlockBase;
import com.wjx.hkfm_mod.util.Reference;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class HK_machines {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public static class hk_basic_grinder extends BlockBase implements ITileEntityProvider{
        public hk_basic_grinder(String name, CreativeTabs tabs){
            super(name,Material.IRON,tabs);
            setSoundType(SoundType.METAL);
            setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        }

        @Override
        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Item.getItemFromBlock(BlockInit.HK_B_GRINDER);
        }

        @Override
        public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
            return new ItemStack(Item.getItemFromBlock(BlockInit.HK_B_GRINDER));
        }

        @Override
        public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            if(!worldIn.isRemote){
                playerIn.openGui(hkfm_mod.instance, Reference.GUI_HKB_GRINDER,worldIn,pos.getX(),pos.getY(),pos.getZ());
            }
            return true;
        }

        @Override
        public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = (EnumFacing) state.getValue(FACING);
            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
            else if(face ==EnumFacing.SOUTH &&south.isFullBlock()&&!north.isFullBlock()) face = EnumFacing.NORTH;
            else if(face ==EnumFacing.WEST &&west.isFullBlock()&&!east.isFullBlock()) face = EnumFacing.EAST;
            else if(face ==EnumFacing.EAST &&east.isFullBlock()&&!west.isFullBlock()) face = EnumFacing.WEST;

            worldIn.setBlockState(pos,state.withProperty(FACING,face),2);
        }

        public static void setState(boolean active, World worldIn, BlockPos pos)
        {
            IBlockState state = worldIn.getBlockState(pos);
            TileEntity tileentity = worldIn.getTileEntity(pos);

            //if(active) worldIn.setBlockState(pos, BlockInit.SINTERING_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3);
            //else worldIn.setBlockState(pos, BlockInit.SINTERING_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, false), 3);

            if(tileentity != null)
            {
                tileentity.validate();
                worldIn.setTileEntity(pos, tileentity);
            }
        }

        @Nullable
        @Override
        public TileEntity createNewTileEntity(World worldIn, int meta) {
            return new HK_TileEntities.TileEntity_hk_basic_grinder();
        }

        @Override
        public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
            HK_TileEntities.TileEntity_hk_basic_grinder tileEntity;
        }

        @Override
        public boolean hasTileEntity(IBlockState state)
        {
            return true;
        }

        @Override
        public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
            return this.getDefaultState().withProperty(FACING,placer.getHorizontalFacing().getOpposite());
        }

        @Override
        public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
        {
            worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
        }

        @Override
        public EnumBlockRenderType getRenderType(IBlockState state)
        {
            return EnumBlockRenderType.MODEL;
        }

        @Override
        public IBlockState withRotation(IBlockState state, Rotation rot)
        {
            return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
        }

        @Override
        public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
        {
            return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
        }

        @Override
        protected BlockStateContainer createBlockState()
        {
            return new BlockStateContainer(this, new IProperty[] {FACING});
        }

        @Override
        public IBlockState getStateFromMeta(int meta)
        {
            EnumFacing facing = EnumFacing.getFront(meta);
            if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
            return this.getDefaultState().withProperty(FACING, facing);
        }

        @Override
        public int getMetaFromState(IBlockState state)
        {
            return ((EnumFacing)state.getValue(FACING)).getIndex();
        }
    }
    public static class mt_b_injector extends BlockBase implements ITileEntityProvider{
        public mt_b_injector(String name, CreativeTabs tabs){
            super(name,Material.IRON,tabs);
            setSoundType(SoundType.METAL);
            setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        }

        @Override
        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Item.getItemFromBlock(BlockInit.MT_B_INJECTOR);
        }

        @Override
        public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
            return new ItemStack(Item.getItemFromBlock(BlockInit.MT_B_INJECTOR));
        }

        @Override
        public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            if(!worldIn.isRemote){
                playerIn.openGui(hkfm_mod.instance, Reference.GUI_MT_INJECTOR,worldIn,pos.getX(),pos.getY(),pos.getZ());
            }
            return true;
        }

        @Override
        public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = state.getValue(FACING);
            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
            else if(face ==EnumFacing.SOUTH &&south.isFullBlock()&&!north.isFullBlock()) face = EnumFacing.NORTH;
            else if(face ==EnumFacing.WEST &&west.isFullBlock()&&!east.isFullBlock()) face = EnumFacing.EAST;
            else if(face ==EnumFacing.EAST &&east.isFullBlock()&&!west.isFullBlock()) face = EnumFacing.WEST;

            worldIn.setBlockState(pos,state.withProperty(FACING,face),2);
        }

        public static void setState(boolean active, World worldIn, BlockPos pos)
        {
            IBlockState state = worldIn.getBlockState(pos);
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if(tileentity != null)
            {
                tileentity.validate();
                worldIn.setTileEntity(pos, tileentity);
            }
        }

        @Nullable
        @Override
        public TileEntity createNewTileEntity(World worldIn, int meta) {
            return new HK_TileEntities.TileEntity_mt_b_injector();
        }

        @Override
        public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
            HK_TileEntities.TileEntity_mt_b_injector tileEntity;
        }

        @Override
        public boolean hasTileEntity(IBlockState state)
        {
            return true;
        }

        @Override
        public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
            return this.getDefaultState().withProperty(FACING,placer.getHorizontalFacing().getOpposite());
        }

        @Override
        public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
        {
            worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
        }

        @Override
        public EnumBlockRenderType getRenderType(IBlockState state)
        {
            return EnumBlockRenderType.MODEL;
        }

        @Override
        public IBlockState withRotation(IBlockState state, Rotation rot)
        {
            return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
        }

        @Override
        public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
        {
            return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
        }

        @Override
        protected BlockStateContainer createBlockState()
        {
            return new BlockStateContainer(this, new IProperty[] {FACING});
        }

        @Override
        public IBlockState getStateFromMeta(int meta)
        {
            EnumFacing facing = EnumFacing.getFront(meta);
            if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
            return this.getDefaultState().withProperty(FACING, facing);
        }

        @Override
        public int getMetaFromState(IBlockState state)
        {
            return state.getValue(FACING).getIndex();
        }
    }


}
