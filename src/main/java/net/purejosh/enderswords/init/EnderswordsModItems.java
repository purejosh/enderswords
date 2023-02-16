
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.enderswords.init;

import net.purejosh.enderswords.item.WoodenEnderswordItem;
import net.purejosh.enderswords.item.StoneEnderswordItem;
import net.purejosh.enderswords.item.NetheriteEnderswordItem;
import net.purejosh.enderswords.item.IronEnderswordItem;
import net.purejosh.enderswords.item.GoldenEnderswordItem;
import net.purejosh.enderswords.item.EnderbladeHiltItem;
import net.purejosh.enderswords.item.DiamondEnderswordItem;
import net.purejosh.enderswords.EnderswordsMod;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class EnderswordsModItems {
	public static Item ENDERBLADE_HILT;
	public static Item WOODEN_ENDERSWORD;
	public static Item STONE_ENDERSWORD;
	public static Item GOLDEN_ENDERSWORD;
	public static Item IRON_ENDERSWORD;
	public static Item DIAMOND_ENDERSWORD;
	public static Item NETHERITE_ENDERSWORD;

	public static void load() {
		ENDERBLADE_HILT = Registry.register(Registry.ITEM, new ResourceLocation(EnderswordsMod.MODID, "enderblade_hilt"), new EnderbladeHiltItem());
		WOODEN_ENDERSWORD = Registry.register(Registry.ITEM, new ResourceLocation(EnderswordsMod.MODID, "wooden_endersword"),
				new WoodenEnderswordItem());
		STONE_ENDERSWORD = Registry.register(Registry.ITEM, new ResourceLocation(EnderswordsMod.MODID, "stone_endersword"),
				new StoneEnderswordItem());
		GOLDEN_ENDERSWORD = Registry.register(Registry.ITEM, new ResourceLocation(EnderswordsMod.MODID, "golden_endersword"),
				new GoldenEnderswordItem());
		IRON_ENDERSWORD = Registry.register(Registry.ITEM, new ResourceLocation(EnderswordsMod.MODID, "iron_endersword"), new IronEnderswordItem());
		DIAMOND_ENDERSWORD = Registry.register(Registry.ITEM, new ResourceLocation(EnderswordsMod.MODID, "diamond_endersword"),
				new DiamondEnderswordItem());
		NETHERITE_ENDERSWORD = Registry.register(Registry.ITEM, new ResourceLocation(EnderswordsMod.MODID, "netherite_endersword"),
				new NetheriteEnderswordItem());
	}
}
