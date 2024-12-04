package net.purejosh.enderswords.world;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {

    public static final GameRules.Key<GameRules.IntRule> ENDERSWORD_COOLDOWN = GameRuleRegistry.register(
            "enderswordCooldownPercentage", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(100));
    public static final GameRules.Key<GameRules.IntRule> ENDERSWORD_DURACOST = GameRuleRegistry.register(
            "enderswordDuraCostMultiplier", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(1));

    public static void init() {
    }
}
