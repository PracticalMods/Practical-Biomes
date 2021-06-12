package ca.thewarmfuzzy.practicalbiomes.init;

import ca.thewarmfuzzy.practicalbiomes.common.fluid.*;
import ca.thewarmfuzzy.practicalbiomes.common.lib.*;
import ca.thewarmfuzzy.practicalbiomes.core.PracticalBiomes;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFluids {

    @SubscribeEvent
    public static void registerFluids(RegistryEvent.Register<Fluid> event) {

        //Create Properties
        ForgeFlowingFluid.Properties INFUSED_WATER_PROPERTIES = createProperties(ModIDs.ID_FLUID_INFUSED_WATER, FluidInfusedWater::addAttributes, () -> FluidsPB.FLUID_INFUSED_WATER_SOURCE, () -> FluidsPB.FLUID_INFUSED_WATER_FLOWING).bucket(() -> ItemsPB.INFUSED_WATER_BUCKET).block(() -> BlocksPB.BLOCK_INFUSED_WATER);

        //Create Fluids
        FluidsPB.FLUID_INFUSED_WATER_SOURCE = registerFluid(ModIDs.ID_FLUID_INFUSED_WATER_STILL, new FluidInfusedWater.Source(INFUSED_WATER_PROPERTIES));
        FluidsPB.FLUID_INFUSED_WATER_FLOWING = registerFluid(ModIDs.ID_FLUID_INFUSED_WATER_FLOW, new FluidInfusedWater.Flowing(INFUSED_WATER_PROPERTIES));

        //Set Rendering
        setRenderLayer(FluidsPB.FLUID_INFUSED_WATER_SOURCE, RenderType.getTranslucent());
        setRenderLayer(FluidsPB.FLUID_INFUSED_WATER_FLOWING, RenderType.getTranslucent());
    }

    private static void setRenderLayer(Fluid fluid, RenderType... types) {
        List<RenderType> typeList = Arrays.asList(types);
        RenderTypeLookup.setRenderLayer(fluid, typeList::contains);
    }

    //All credits go to Astral Sorcery
    private static ForgeFlowingFluid.Properties createProperties(String name, Function<FluidAttributes.Builder, FluidAttributes.Builder> postProcess, Supplier<ForgeFlowingFluid> still, Supplier<ForgeFlowingFluid> flowing) {
        return new ForgeFlowingFluid.Properties(still, flowing, postProcess.apply(builderFor(name)));
    }

    //Seriously, their code was a huge help
    private static FluidAttributes.Builder builderFor(String fluidName) {
        ResourceLocation still = new ResourceLocation(PracticalBiomes.MOD_ID, "fluid/" + fluidName + "_still");
        ResourceLocation flowing = new ResourceLocation(PracticalBiomes.MOD_ID, "fluid/" + fluidName + "_flow");
        return FluidAttributes.builder(still, flowing);
    }

    public static <T extends Fluid> T registerFluid(String name, T fluid) {
        fluid.setRegistryName(name);
        ForgeRegistries.FLUIDS.register(fluid);
        return fluid;
    }

}
