package com.wjx.hkfm_mod;

import com.wjx.hkfm_mod.proxy.CommonProxy;
import com.wjx.hkfm_mod.tabs.honkai_tab;
import com.wjx.hkfm_mod.util.Reference;
import com.wjx.hkfm_mod.util.handlers.RegistryHandler;
import com.wjx.hkfm_mod.world.gen.WorldGenCustomOres1;
import com.wjx.hkfm_mod.world.gen.Worldgenore2;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new Worldgenore2(), 5);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){}
}
