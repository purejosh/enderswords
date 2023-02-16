
package net.purejosh.enderswords.item;

import net.purejosh.enderswords.procedures.DiamondEnderBladeRightClickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;

public class DiamondEnderswordItem extends SwordItem {
	public DiamondEnderswordItem() {
		super(new Tier() {
			public int getUses() {
				return 1561;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.DIAMOND));
			}
		}, 3, -2.0999999999999999f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		DiamondEnderBladeRightClickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", entity.getX())
				.put("y", entity.getY()).put("z", entity.getZ()).put("world", world).put("entity", entity).build());
		return ar;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Ender Pearl \u00A7eRIGHT CLICK"));
		list.add(Component.literal("\u00A78Shoots an ender pearl"));
		list.add(Component.literal("\u00A78Durability cost: \u00A733"));
		list.add(Component.literal("\u00A78Cooldown: \u00A7a2.5s"));
	}
}
