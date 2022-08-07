package com.wjx.hkfm_mod;

import com.wjx.hkfm_mod.init.EntityInit;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.init.PotionInit;
import com.wjx.hkfm_mod.proxy.CommonProxy;
import com.wjx.hkfm_mod.tabs.honkai_tab;
import com.wjx.hkfm_mod.util.Reference;
import com.wjx.hkfm_mod.util.handlers.GuiHandler;
import com.wjx.hkfm_mod.util.handlers.RegistryHandler;
import com.wjx.hkfm_mod.util.handlers.RenderHandle;
import com.wjx.hkfm_mod.world.gen.Worldgenore2;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class hkfm_mod
{
    @Instance
    public static hkfm_mod instance;

    public static final CreativeTabs honkai_tab = new honkai_tab("honkai_tab");

    @SidedProxy(clientSide = Reference.CLIENT,serverSide = Reference.COMMON)
    public static CommonProxy proxy;
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        GameRegistry.registerWorldGenerator(new Worldgenore2(), 5);
        GameRegistry.addSmelting(new ItemStack(Iteminit.FLOUR,1),new ItemStack(Iteminit.FLOUR_PLACE,1),5);
        PotionInit.registerPotion();
        EntityInit.registerEntities();
        RenderHandle.registerEntityRenders();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(hkfm_mod.instance,new GuiHandler());


    }
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){}
}
