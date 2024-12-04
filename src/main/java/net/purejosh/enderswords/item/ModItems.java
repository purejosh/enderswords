package net.purejosh.enderswords.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.purejosh.enderswords.Enderswords;

import java.util.List;

public class ModItems {
    // Swords
    public static final Item WOODEN_ENDERSWORD = register("wooden_endersword", new EnderswordItem(ToolMaterials.WOOD, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD,2, -2.2f))));
    public static final Item STONE_ENDERSWORD = register("stone_endersword", new EnderswordItem(ToolMaterials.STONE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE,2, -2.2f))));
    public static final Item IRON_ENDERSWORD = register("iron_endersword", new EnderswordItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON,2, -2.2f))));
    public static final Item GOLDEN_ENDERSWORD = register("golden_endersword", new EnderswordItem(ToolMaterials.GOLD, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD,2, -2.2f))));
    public static final Item DIAMOND_ENDERSWORD = register("diamond_endersword", new EnderswordItem(ToolMaterials.DIAMOND, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND,2, -2.2f))));
    public static final Item NETHERITE_ENDERSWORD = register("netherite_endersword", new EnderswordItem(ToolMaterials.NETHERITE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE,2, -2.2f))));

    // Misc
    public static final Item ENDERSWORD_HILT = register("endersword_hilt", new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("item.enderswords.endersword_hilt.desc_1"));
            tooltip.add(Text.translatable("item.enderswords.endersword_hilt.desc_2"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item ENDERSWORD_UPGRADE_SMITHING_TEMPLATE = register("endersword_upgrade_smithing_template", new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("item.enderswords.endersword_upgrade_smithing_template.desc_1"));
            tooltip.add(Text.translatable("item.enderswords.endersword_upgrade_smithing_template.desc_2"));
            tooltip.add(Text.translatable("item.enderswords.endersword_upgrade_smithing_template.desc_3"));
            tooltip.add(Text.translatable("item.enderswords.endersword_upgrade_smithing_template.desc_4"));
            tooltip.add(Text.translatable("item.enderswords.endersword_upgrade_smithing_template.desc_5"));
            tooltip.add(Text.translatable("item.enderswords.endersword_upgrade_smithing_template.desc_6"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    
    // Helper method for registering an item.
    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Enderswords.MOD_ID, id), item);
    }

    // Class initializer called from the entrypoint.
    public static void init() {
    }
}
