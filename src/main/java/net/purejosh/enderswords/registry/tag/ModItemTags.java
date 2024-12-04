package net.purejosh.enderswords.registry.tag;

import net.purejosh.enderswords.Enderswords;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {

    public static final TagKey<Item> ENDERSWORD_TIER_1 = of("endersword_tier_1");
    public static final TagKey<Item> ENDERSWORD_TIER_2 = of("endersword_tier_2");
    public static final TagKey<Item> ENDERSWORD_TIER_3 = of("endersword_tier_3");
    public static final TagKey<Item> ENDERSWORD_TIER_4 = of("endersword_tier_4");
    public static final TagKey<Item> ENDERSWORD_TIER_5 = of("endersword_tier_5");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Enderswords.MOD_ID, id));
    }
}
