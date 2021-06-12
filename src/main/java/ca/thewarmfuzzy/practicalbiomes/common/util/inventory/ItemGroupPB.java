package ca.thewarmfuzzy.practicalbiomes.common.util.inventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupPB extends ItemGroup {

    public static final ItemGroupPB instance = new ItemGroupPB(ItemGroup.GROUPS.length, "practicalbiomes");

    private ItemGroupPB(int index, String label){
        super(index,label);
    }

    @Override
    public ItemStack createIcon()
    {
        //TODO Add creative tab icon
        return new ItemStack(null);
    }

}
