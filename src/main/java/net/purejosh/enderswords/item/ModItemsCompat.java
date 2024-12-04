package net.purejosh.enderswords.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purejosh.enderswords.Enderswords;

import java.util.HashSet;
import java.util.Set;

public class ModItemsCompat {
    // Static fields for the items.
    // Pure Copper Tools
    public static Item COPPER_ENDERSWORD;
    public static Item EXPOSED_COPPER_ENDERSWORD;
    public static Item WEATHERED_COPPER_ENDERSWORD;
    public static Item OXIDIZED_COPPER_ENDERSWORD;

    // Pure Quartz Tools
    public static Item QUARTZ_ENDERSWORD;

    // Pure Amethyst Tools
    public static Item AMETHYST_ENDERSWORD;
    public static Item PURE_AMETHYST_ENDERSWORD;

    // Pure Emerald Tools
    public static Item EMERALD_ENDERSWORD;
    public static Item PURE_EMERALD_ENDERSWORD;
    public static Item PURE_EMERALD_NETHERITE_ENDERSWORD;

    // Pure Ores
    public static Item MOONSTONE_ENDERSWORD;
    public static Item FIRE_OPAL_ENDERSWORD;
    public static Item JADEITE_ENDERSWORD;
    public static Item AMETRINE_ENDERSWORD;
    public static Item CHRYSOBERYL_ENDERSWORD;
    public static Item SAPPHIRE_ENDERSWORD;
    public static Item BLACK_DIAMOND_ENDERSWORD;
    public static Item LONSDALEITE_ENDERSWORD;

    // Set to keep track of processed mods
    private static final Set<String> processedMods = new HashSet<>();

    // Helper method for registering an item.
    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Enderswords.MOD_ID, id), item);
    }

    // Helper method for loading compatibility items.
    private static void loadCompatItem(String modId, String materialClass, String materialField, String itemId, int atk, float spd, Item registerAfter) {
        boolean logModFound = !processedMods.contains(modId);
        if (FabricLoader.getInstance().isModLoaded(modId)) {
            try {
                if (logModFound) {
                    Enderswords.LOGGER.info("   {} found! Attempting to register items...", modId);
                }
                Class<?> toolMaterialsClass = Class.forName(materialClass);
                ToolMaterial toolMaterial = (ToolMaterial) toolMaterialsClass.getField(materialField).get(null);

                // Register the item
                Item registeredItem = register(itemId, new EnderswordItem(toolMaterial, new Item.Settings()
                        .attributeModifiers(SwordItem.createAttributeModifiers(toolMaterial, atk, spd))));

                // Modify the item group to add the item after NETHERITE_ENDERSWORD
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.addAfter(
                        registerAfter.getDefaultStack(), registeredItem.getDefaultStack()));

                if (logModFound) {
                    Enderswords.LOGGER.info("   Variants for {} have been registered!", modId);
                    processedMods.add(modId);
                }
            } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
                Enderswords.LOGGER.info("   Could not load {} compatibility: {}", modId, e.getMessage());
            }
        }
    }

    // Class initializer called from the entrypoint.
    public static void init() {
        Enderswords.LOGGER.info(Enderswords.MOD_NAME + " is checking for compatible mods...");

        // Loading compatibility with mods, if present. This order is important, least to most durable.
        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "LONSDALEITE", "lonsdaleite_endersword", 2, -2.2f, ModItems.NETHERITE_ENDERSWORD);
        loadCompatItem("pureemeraldtools", "net.purejosh.pureemeraldtools.item.ModToolMaterials", "PURE_EMERALD_NETHERITE", "pure_emerald_netherite_endersword", 4, -2.2f, ModItems.NETHERITE_ENDERSWORD);

        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "BLACK_DIAMOND", "black_diamond_endersword", 2, -2.2f, ModItems.DIAMOND_ENDERSWORD);
        loadCompatItem("pureemeraldtools", "net.purejosh.pureemeraldtools.item.ModToolMaterials", "PURE_EMERALD", "pure_emerald_endersword", 3, -2.2f, ModItems.DIAMOND_ENDERSWORD);

        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "SAPPHIRE", "sapphire_endersword", 2, -2.2f, ModItems.IRON_ENDERSWORD);
        loadCompatItem("pureamethysttools", "net.purejosh.pureamethysttools.item.ModToolMaterials", "PURE_AMETHYST", "pure_amethyst_endersword", 3, -2.2f, ModItems.IRON_ENDERSWORD);
        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "CHRYSOBERYL", "chrysoberyl_endersword", 2, -2.2f, ModItems.IRON_ENDERSWORD);
        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "AMETRINE", "ametrine_endersword", 2, -2.2f, ModItems.IRON_ENDERSWORD);
        loadCompatItem("pureemeraldtools", "net.purejosh.pureemeraldtools.item.ModToolMaterials", "EMERALD", "emerald_endersword", 2, -2.2f, ModItems.IRON_ENDERSWORD);
        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "JADEITE", "jadeite_endersword", 2, -2.2f, ModItems.IRON_ENDERSWORD);
        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "FIRE_OPAL", "fire_opal_endersword", 2, -2.2f, ModItems.IRON_ENDERSWORD);
        loadCompatItem("pureores", "net.purejosh.pureores.item.ModToolMaterials", "MOONSTONE", "moonstone_endersword", 2, -2.2f, ModItems.IRON_ENDERSWORD);

        loadCompatItem("purecoppertools", "net.purejosh.purecoppertools.item.ModToolMaterials", "OXIDIZED_COPPER", "oxidized_copper_endersword", 2, -2.2f, ModItems.STONE_ENDERSWORD);
        loadCompatItem("purecoppertools", "net.purejosh.purecoppertools.item.ModToolMaterials", "WEATHERED_COPPER", "weathered_copper_endersword", 2, -2.2f, ModItems.STONE_ENDERSWORD);
        loadCompatItem("pureamethysttools", "net.purejosh.pureamethysttools.item.ModToolMaterials", "AMETHYST", "amethyst_endersword", 3, -2.2f, ModItems.STONE_ENDERSWORD);
        loadCompatItem("purequartztools", "net.purejosh.purequartztools.item.ModToolMaterials", "QUARTZ", "quartz_endersword", 2, -2.2f, ModItems.STONE_ENDERSWORD);
        loadCompatItem("purecoppertools", "net.purejosh.purecoppertools.item.ModToolMaterials", "EXPOSED_COPPER", "exposed_copper_endersword", 2, -2.2f, ModItems.STONE_ENDERSWORD);
        loadCompatItem("purecoppertools", "net.purejosh.purecoppertools.item.ModToolMaterials", "COPPER", "copper_endersword", 2, -2.2f, ModItems.STONE_ENDERSWORD);
    }
}