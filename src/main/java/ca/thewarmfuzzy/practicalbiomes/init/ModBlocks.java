package ca.thewarmfuzzy.practicalbiomes.init;

import ca.thewarmfuzzy.practicalbiomes.common.block.BlockObsidianStone;
import ca.thewarmfuzzy.practicalbiomes.common.block.BlockInfusedWater;
import ca.thewarmfuzzy.practicalbiomes.common.util.inventory.ItemGroupPB;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;

import ca.thewarmfuzzy.practicalbiomes.common.lib.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        //Blocks
        BlocksPB.OBSIDIAN_STONE = registerBlock(ModIDs.ID_BLOCK_OBSIDIAN_STONE, new BlockObsidianStone(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 1100.0f)));

        //Fluid Blocks
        BlocksPB.BLOCK_INFUSED_WATER = registerBlockNoItem(ModIDs.ID_BLOCK_INFUSED_WATER, new BlockInfusedWater(() -> FluidsPB.FLUID_INFUSED_WATER_SOURCE, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().setLightLevel(state -> 15).hardnessAndResistance(100.0F).noDrops()));

        //Check if client to add rendering data
        if (FMLEnvironment.dist == Dist.CLIENT) {

        }

    }

    // Registers a solid block with Minecraft
    public static <T extends Block> T registerBlock(String name, T block) {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(ItemGroupPB.instance));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }

    // Registers an item-based block with Minecraft
    public static <T extends Block> T registerBlock(String name, T block, BlockItem itemBlock) {
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);

        if (itemBlock != null) {
            itemBlock.setRegistryName(name);
            ForgeRegistries.ITEMS.register(itemBlock);
        }

        return block;
    }

    // Registers a solid block with Minecraft without a creative tab
    public static <T extends Block> T registerBlockNoGroup(String name, T block) {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(null));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }

    // Registers a solid block with Minecraft without an associated item
    public static <T extends Block> T registerBlockNoItem(String name, T block) {
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }

}
