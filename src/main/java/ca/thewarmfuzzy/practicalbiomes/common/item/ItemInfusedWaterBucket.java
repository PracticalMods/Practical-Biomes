package ca.thewarmfuzzy.practicalbiomes.common.item;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class ItemInfusedWaterBucket extends BucketItem {

    public ItemInfusedWaterBucket(Supplier<? extends Fluid> supplier, Item.Properties builder) {
        super(supplier, builder);
    }

}
