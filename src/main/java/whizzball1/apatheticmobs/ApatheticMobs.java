package whizzball1.apatheticmobs;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.event.RegistryEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import whizzball1.apatheticmobs.capability.IRevengeCap;
import whizzball1.apatheticmobs.capability.RevengeCapFactory;
import whizzball1.apatheticmobs.capability.RevengeStorage;
import whizzball1.apatheticmobs.handlers.ApatheticHandler;

import java.util.Random;

@Mod(
        modid = ApatheticMobs.MOD_ID,
        name = ApatheticMobs.MOD_NAME,
        version = ApatheticMobs.VERSION
)
public class ApatheticMobs {

    public static final String MOD_ID = "apatheticmobs";
    public static final String MOD_NAME = "ApatheticMobs";
    public static final String VERSION = "1.4";

    public static final Logger logger = LogManager.getLogger(MOD_NAME);
    public static final Random random = new Random();

    @CapabilityInject(IRevengeCap.class)
    public static final Capability<IRevengeCap> REVENGE_CAPABILITY = null;


    @Mod.Instance(MOD_ID)
    public static ApatheticMobs INSTANCE;


    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        //DoWhatYouWant.makeTheFile();
        CapabilityManager.INSTANCE.register(IRevengeCap.class, RevengeStorage.STORAGE, new RevengeCapFactory());
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ApatheticHandler());
    }


    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
