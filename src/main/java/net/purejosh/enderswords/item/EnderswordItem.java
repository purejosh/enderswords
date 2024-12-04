package net.purejosh.enderswords.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.purejosh.enderswords.registry.tag.ModItemTags;
import net.purejosh.enderswords.world.ModGameRules;

import java.util.List;

public class EnderswordItem extends SwordItem {

    public EnderswordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.enderswords.endersword.right_click"));
        tooltip.add(Text.translatable("item.enderswords.endersword.shoots_pearl"));
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (hand != Hand.MAIN_HAND) {
            return TypedActionResult.fail(player.getStackInHand(hand));
        }

        // Ensuring that all future checks are based on the item in the player's main hand
        ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);

        // Defaulting values to 0 for quick identification of successful ItemTag matching
        int baseCooldown = 0;
        int baseDuraCost = 0;

        // Check the Endersword's tier via tags to determine cooldown and durability cost
        if (itemStack.isIn(ModItemTags.ENDERSWORD_TIER_1)) {
            baseCooldown = 120;
            baseDuraCost = 1;
        } else if (itemStack.isIn(ModItemTags.ENDERSWORD_TIER_2)) {
            baseCooldown = 100;
            baseDuraCost = 2;
        } else if (itemStack.isIn(ModItemTags.ENDERSWORD_TIER_3)) {
            baseCooldown = 80;
            baseDuraCost = 3;
        } else if (itemStack.isIn(ModItemTags.ENDERSWORD_TIER_4)) {
            baseCooldown = 60;
            baseDuraCost = 6;
        } else if (itemStack.isIn(ModItemTags.ENDERSWORD_TIER_5)) {
            baseCooldown = 40;
            baseDuraCost = 7;
        }

        // Get the gamerule values
        int cooldownPercentage = world.getGameRules().getInt(ModGameRules.ENDERSWORD_COOLDOWN);
        int duraCostMultiplier = world.getGameRules().getInt(ModGameRules.ENDERSWORD_DURACOST);

        // Calculate the cooldown and durability cost
        int cooldown = (baseCooldown * cooldownPercentage) / 100;
        int duraCost = baseDuraCost * duraCostMultiplier;

        // Play the enderpearl sound
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

        // Check if player is in creative mode before applying cooldown and durability cost
        if (!player.isCreative()) {
            itemStack.damage(duraCost, player, EquipmentSlot.MAINHAND);
            player.getItemCooldownManager().set(this, cooldown);
        }

        // Finally, throwing the enderpearl
        if (!world.isClient) {
            EnderPearlEntity thrownPearl = new EnderPearlEntity(world, player);
            thrownPearl.setItem(Items.ENDER_PEARL.getDefaultStack());
            thrownPearl.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(thrownPearl);
        }

        // Adding the particle effect
        Random random = Random.create();
        for(int i = 0; i < 40; ++i) {
            double yOffset = 0.2 + random.nextDouble() * 1.6;
            double xVelocity = (random.nextDouble() - 0.5);
            double yVelocity = (random.nextDouble() - 0.5);
            double zVelocity = (random.nextDouble() - 0.5);
            world.addParticle(ParticleTypes.REVERSE_PORTAL, player.getX(), player.getY() + yOffset, player.getZ(), xVelocity, yVelocity, zVelocity);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
