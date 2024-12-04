package net.purejosh.enderswords.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

// This is used to arrange items in creative tabs.
public class ModItemGroups {
    public static void init() {
        // ModItems sorting
        // Combat
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addBefore(
                Items.WOODEN_AXE.getDefaultStack(), ModItems.ENDERSWORD_HILT.getDefaultStack()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addAfter(
                ModItems.ENDERSWORD_HILT.getDefaultStack(), ModItems.WOODEN_ENDERSWORD.getDefaultStack()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addAfter(
                ModItems.WOODEN_ENDERSWORD.getDefaultStack(), ModItems.STONE_ENDERSWORD.getDefaultStack()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addAfter(
                ModItems.STONE_ENDERSWORD.getDefaultStack(), ModItems.IRON_ENDERSWORD.getDefaultStack()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addAfter(
                ModItems.IRON_ENDERSWORD.getDefaultStack(), ModItems.GOLDEN_ENDERSWORD.getDefaultStack()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addAfter(
                ModItems.GOLDEN_ENDERSWORD.getDefaultStack(), ModItems.DIAMOND_ENDERSWORD.getDefaultStack()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addAfter(
                ModItems.DIAMOND_ENDERSWORD.getDefaultStack(), ModItems.NETHERITE_ENDERSWORD.getDefaultStack()));
        // Ingredients
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.addBefore(
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE.getDefaultStack(), ModItems.ENDERSWORD_UPGRADE_SMITHING_TEMPLATE.getDefaultStack()));
    }
}
