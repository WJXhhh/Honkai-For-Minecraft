package com.wjx.hkfm_mod.world.gen;

import com.wjx.hkfm_mod.init.BlockInit;
import net.minecraft.block.Block;
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
    private WorldGenerator stone_for_honkai;

    public WorldGenCustomOres(){
        stone_for_honkai = new WorldGenMinable(BlockInit.BLOCKS_STONE_FOR_HONKAI.getDefaultState(),4, BlockMatcher.forBlock(Blocks.GRASS));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()){
            case  0:
                runWorldGenerator(stone_for_honkai,world,random,chunkX,chunkZ,40,40,80);
                break;
        }
    }

    private void runWorldGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chuckZ, int chance, int minHeight, int maxHeight){
        if (minHeight>maxHeight||minHeight<0||maxHeight>256) throw new IllegalArgumentException("矿石生成超出边界");

        int heightDiff = maxHeight - minHeight +1;

        for (int i =0;i<chance;i++){
            int x =chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z =chunkX * 16 + rand.nextInt(16);

            gen.generate(world,rand,new BlockPos(x,y,z));

        }

    }
}
