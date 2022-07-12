package com.wjx.hkfm_mod.util.handlers;

import com.wjx.hkfm_mod.init.BlockInit;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(Iteminit.ITEMS.toArray(new Item[0]));

    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(BlockInit.Blocks.toArray(new Block[0]));

    }


    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for (Item item : Iteminit.ITEMS){
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModels();

            }
        }

        for (Block block : BlockInit.Blocks){

            if (block instanceof IHasModel){
                ((IHasModel)block).registerModels();

            }
        }

    }
}
