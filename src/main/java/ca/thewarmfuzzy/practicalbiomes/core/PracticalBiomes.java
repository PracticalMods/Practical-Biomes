package ca.thewarmfuzzy.practicalbiomes.core;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = PracticalBiomes.MOD_ID)
public class PracticalBiomes {

    public static final String MOD_ID = "practicalbiomes";
    public static PracticalBiomes instance;

    public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    public static final Logger LOGGER = LogManager.getLogger();

    public PracticalBiomes()
    {

        //TODO Add compatibility listeners

        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("COMMON SETUP");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        LOGGER.info("CLIENT SETUP");
    }

    private void loadComplete(final FMLLoadCompleteEvent event) // PostRegistrationEven
    {
        LOGGER.info("LOAD COMPLETE");
    }
}
