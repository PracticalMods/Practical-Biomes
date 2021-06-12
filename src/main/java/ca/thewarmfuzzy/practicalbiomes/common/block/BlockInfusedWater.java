package ca.thewarmfuzzy.practicalbiomes.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;


import java.util.function.Supplier;

public class BlockInfusedWater extends FlowingFluidBlock {

    public BlockInfusedWater(Supplier<? extends FlowingFluid> fluidSupplier, AbstractBlock.Properties properties) {
        super(fluidSupplier, properties);
    }

}
