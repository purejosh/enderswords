package net.purejosh.enderswords.procedures;

import net.purejosh.enderswords.init.EnderswordsModGameRules;

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
import net.minecraft.util.RandomSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class EnderswordRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, new ResourceLocation("enderswords:endersword")))) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANT, x, (y + 1.5), z, 40, 0.2, 0.2, 0.2, 1);
			if (entity.getXRot() > 70) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
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
			} else {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
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
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.ender_pearl.throw")), SoundSource.PLAYERS, (float) 0.8, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.ender_pearl.throw")), SoundSource.PLAYERS, (float) 0.8, (float) 0.5, false);
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, new ResourceLocation("enderswords:tier_6")))) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(),
							(int) (0.6 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_ABILITY_COOLDOWN_PERCENTAGE))));
				if (!world.isClientSide()) {
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt((int) (1 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_DURABILITY_USE_MULTIPLIER))), RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, new ResourceLocation("enderswords:tier_5")))) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(),
							(int) (0.5 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_ABILITY_COOLDOWN_PERCENTAGE))));
				if (!world.isClientSide()) {
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt((int) (2 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_DURABILITY_USE_MULTIPLIER))), RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, new ResourceLocation("enderswords:tier_4")))) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(),
							(int) (0.4 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_ABILITY_COOLDOWN_PERCENTAGE))));
				if (!world.isClientSide()) {
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt((int) (3 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_DURABILITY_USE_MULTIPLIER))), RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, new ResourceLocation("enderswords:tier_3")))) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(),
							(int) (0.3 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_ABILITY_COOLDOWN_PERCENTAGE))));
				if (!world.isClientSide()) {
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt((int) (4 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_DURABILITY_USE_MULTIPLIER))), RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, new ResourceLocation("enderswords:tier_2")))) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(),
							(int) (0.2 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_ABILITY_COOLDOWN_PERCENTAGE))));
				if (!world.isClientSide()) {
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt((int) (5 * (world.getLevelData().getGameRules().getInt(EnderswordsModGameRules.ENDERSWORDS_DURABILITY_USE_MULTIPLIER))), RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
	}
}
