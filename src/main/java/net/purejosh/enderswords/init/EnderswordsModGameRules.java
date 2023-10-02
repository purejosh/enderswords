
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.enderswords.init;

import net.minecraft.world.level.GameRules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;

public class EnderswordsModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> ENDERSWORDS_DURABILITY_USE_MULTIPLIER;
	public static GameRules.Key<GameRules.IntegerValue> ENDERSWORDS_ABILITY_COOLDOWN_PERCENTAGE;

	public static void load() {
		ENDERSWORDS_DURABILITY_USE_MULTIPLIER = GameRuleRegistry.register("enderswords_durability_use_multiplier", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(1));
		ENDERSWORDS_ABILITY_COOLDOWN_PERCENTAGE = GameRuleRegistry.register("enderswords_ability_cooldown_percentage", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(100));
	}
}
