package ca.thewarmfuzzy.practicalbiomes.init;

import ca.thewarmfuzzy.practicalbiomes.common.item.*;
import ca.thewarmfuzzy.practicalbiomes.common.lib.FluidsPB;
import ca.thewarmfuzzy.practicalbiomes.common.lib.ItemsPB;
import ca.thewarmfuzzy.practicalbiomes.common.util.inventory.ItemGroupPB;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //Fluids
        ItemsPB.INFUSED_WATER_BUCKET = registerItem(ModIDs.ID_ITEM_INFUSED_WATER_BUCKET, new ItemInfusedWaterBucket(() -> FluidsPB.FLUID_INFUSED_WATER_SOURCE, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroupPB.instance)));

    }

    public static <T extends Item> T registerItem(String name, T item) {
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

}
