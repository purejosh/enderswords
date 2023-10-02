/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.enderswords.init;

import net.purejosh.enderswords.item.WoodenEnderswordItem;
import net.purejosh.enderswords.item.StoneEnderswordItem;
import net.purejosh.enderswords.item.PureAmethystEnderswordItem;
import net.purejosh.enderswords.item.NetheriteEnderswordItem;
import net.purejosh.enderswords.item.IronEnderswordItem;
import net.purejosh.enderswords.item.GoldenEnderswordItem;
import net.purejosh.enderswords.item.EnderswordHiltItem;
import net.purejosh.enderswords.item.EmeraldEnderswordItem;
import net.purejosh.enderswords.item.DiamondEnderswordItem;
import net.purejosh.enderswords.item.CopperEnderswordItem;
import net.purejosh.enderswords.item.AmethystEnderswordItem;
import net.purejosh.enderswords.EnderswordsMod;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class EnderswordsModItems {
	public static Item ENDERSWORD_HILT;
	public static Item WOODEN_ENDERSWORD;
	public static Item STONE_ENDERSWORD;
	public static Item GOLDEN_ENDERSWORD;
	public static Item IRON_ENDERSWORD;
	public static Item DIAMOND_ENDERSWORD;
	public static Item NETHERITE_ENDERSWORD;
	public static Item COPPER_ENDERSWORD;
	public static Item AMETHYST_ENDERSWORD;
	public static Item PURE_AMETHYST_ENDERSWORD;
	public static Item EMERALD_ENDERSWORD;

	public static void load() {
		ENDERSWORD_HILT = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "endersword_hilt"), new EnderswordHiltItem());
		WOODEN_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "wooden_endersword"), new WoodenEnderswordItem());
		STONE_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "stone_endersword"), new StoneEnderswordItem());
		GOLDEN_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "golden_endersword"), new GoldenEnderswordItem());
		IRON_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "iron_endersword"), new IronEnderswordItem());
		DIAMOND_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "diamond_endersword"), new DiamondEnderswordItem());
		NETHERITE_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "netherite_endersword"), new NetheriteEnderswordItem());
		COPPER_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "copper_endersword"), new CopperEnderswordItem());
		AMETHYST_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "amethyst_endersword"), new AmethystEnderswordItem());
		PURE_AMETHYST_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "pure_amethyst_endersword"), new PureAmethystEnderswordItem());
		EMERALD_ENDERSWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(EnderswordsMod.MODID, "emerald_endersword"), new EmeraldEnderswordItem());
	}

	public static void clientLoad() {
	}
}
