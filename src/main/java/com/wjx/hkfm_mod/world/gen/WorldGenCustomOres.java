package com.wjx.hkfm_mod.world.gen;

import com.wjx.hkfm_mod.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator {


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
if(world.provider.getDimension() == 0){runWorldGenerator(BlockInit.BLOCKS_STONE_FOR_HONKAI.getDefaultState(),world,random,chunkX,chunkZ,80,40,80,4);}



    }

    private void runWorldGenerator(IBlockState ore, World world, Random rand, int chunkX, int chuckZ, int chance, int minHeight, int maxHeight,int size){
        if (minHeight>maxHeight||minHeight<0||maxHeight>256) throw new IllegalArgumentException("矿石生成超出边界");

        int heightDiff = maxHeight - minHeight +1;

        for (int i =0;i<chance;i++){
            int x =chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z =chunkX * 16 + rand.nextInt(16);
            WorldGenMinable gen = new WorldGenMinable(ore, size);

            gen.generate(world,rand,new BlockPos(x,y,z));

        }

    }
}
