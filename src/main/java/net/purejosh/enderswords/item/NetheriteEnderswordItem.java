
package net.purejosh.enderswords.item;

import net.purejosh.enderswords.procedures.NetheriteEnderBladeRightClickProcedure;

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

public class NetheriteEnderswordItem extends SwordItem {
	public NetheriteEnderswordItem() {
		super(new Tier() {
			public int getUses() {
				return 2031;
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
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_SCRAP));
			}
		}, 3, -2.1f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		NetheriteEnderBladeRightClickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", entity.getX())
				.put("y", entity.getY()).put("z", entity.getZ()).put("world", world).put("entity", entity).build());
		return ar;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Ender Pearl \u00A7eRIGHT CLICK"));
		list.add(Component.literal("\u00A78Shoots an ender pearl"));
		list.add(Component.literal("\u00A78Durability cost: \u00A734"));
		list.add(Component.literal("\u00A78Cooldown: \u00A7a3s"));
	}
}
