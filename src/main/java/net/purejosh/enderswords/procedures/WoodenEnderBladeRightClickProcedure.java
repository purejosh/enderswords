package net.purejosh.enderswords.procedures;

import net.purejosh.enderswords.init.EnderswordsModItems;
import net.purejosh.enderswords.EnderswordsMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class WoodenEnderBladeRightClickProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EnderswordsMod.LOGGER.warn("Failed to load dependency world for procedure WoodenEnderBladeRightClick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EnderswordsMod.LOGGER.warn("Failed to load dependency x for procedure WoodenEnderBladeRightClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EnderswordsMod.LOGGER.warn("Failed to load dependency y for procedure WoodenEnderBladeRightClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EnderswordsMod.LOGGER.warn("Failed to load dependency z for procedure WoodenEnderBladeRightClick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EnderswordsMod.LOGGER.warn("Failed to load dependency entity for procedure WoodenEnderBladeRightClick!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getItem() == EnderswordsModItems.WOODEN_ENDERSWORD) {
			if (world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), SoundEvents.ENDER_PEARL_THROW, SoundSource.PLAYERS, (float) 0.7, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, SoundEvents.ENDER_PEARL_THROW, SoundSource.PLAYERS, (float) 0.7, (float) 0.5, false);
					}
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(),
						20);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (entity.getXRot() < 70) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getProjectile(Level level, Entity shooter) {
								Projectile entityToSpawn = new ThrownEnderpearl(EntityType.ENDER_PEARL, level);
								entityToSpawn.setOwner(shooter);
								return entityToSpawn;
							}
						}.getProjectile(projectileLevel, entity);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.7, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
			if (entity.getXRot() > 70) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getProjectile(Level level, Entity shooter) {
								Projectile entityToSpawn = new ThrownEnderpearl(EntityType.ENDER_PEARL, level);
								entityToSpawn.setOwner(shooter);
								return entityToSpawn;
							}
						}.getProjectile(projectileLevel, entity);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
	}
}
