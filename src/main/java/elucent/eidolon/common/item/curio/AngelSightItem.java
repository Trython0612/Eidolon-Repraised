package elucent.eidolon.common.item.curio;

import elucent.eidolon.common.entity.AngelArrowEntity;
import elucent.eidolon.registries.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;

import java.util.Random;
import java.util.function.Predicate;

public class AngelSightItem extends EidolonCurio {
    static final Random random = new Random();

    public AngelSightItem(Properties properties) {
        super(properties);
        MinecraftForge.EVENT_BUS.addListener(AngelSightItem::onLoose);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return !slotContext.entity().isShiftKeyDown();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if (pPlayer.isShiftKeyDown() && !pLevel.isClientSide) {
            ItemStack stack = pPlayer.getItemInHand(pUsedHand);
            CompoundTag tag = stack.getOrCreateTag();
            int mode = tag.getInt("mode");
            mode = (mode + 1) % 3;
            tag.putInt("mode", mode);
            stack.setTag(tag);
            pPlayer.sendSystemMessage(Component.translatable("eidolon.angels_sight.mode." + mode));
            return InteractionResultHolder.success(stack);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @SubscribeEvent
    public static void onLoose(ArrowLooseEvent event) {
        Player player = event.getEntity();
        ItemStack stack = event.getBow(), ammo = player.getProjectile(stack);
        Level world = event.getLevel();

        if (!event.hasAmmo()) return;

        if (ammo.isEmpty()) {
            ammo = new ItemStack(Items.ARROW);
        }

        var ring = CuriosApi.getCuriosHelper().findFirstCurio(event.getEntity(), Registry.ANGELS_SIGHT.get());

        Predicate<Entity> mode = null;

        if (ring.isEmpty()) return;
        else {
            CompoundTag ringTag = ring.get().stack().getTag();
            if (ringTag != null) {
                mode = switch (ringTag.getInt("mode")) {
                    case 1 -> target -> target instanceof LivingEntity && !(target instanceof Player);
                    case 2 -> target -> target instanceof Enemy;
                    default -> target -> target instanceof LivingEntity;
                };
            }
        }

        float f = event.getBow().getItem() instanceof BowItem ? BowItem.getPowerForTime(event.getCharge()) : 1.0F;
        if (!(f < 0.1F)) {
            boolean flag1 = player.getAbilities().instabuild || (ammo.getItem() instanceof ArrowItem && ((ArrowItem) ammo.getItem()).isInfinite(ammo, stack, player));
            if (!world.isClientSide) {
                ArrowItem arrowitem = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
                AbstractArrow innerarrow = arrowitem.createArrow(world, ammo, player);
                if (stack.getItem() instanceof BowItem bow) innerarrow = bow.customArrow(innerarrow);
                AngelArrowEntity abstractarrowentity = new AngelArrowEntity(world, player);
                if (mode != null) {
                    abstractarrowentity.mode = mode;
                }
                abstractarrowentity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                if (f == 1.0F) {
                    innerarrow.setCritArrow(true);
                    abstractarrowentity.setCritArrow(true);
                }

                int j = stack.getEnchantmentLevel(Enchantments.POWER_ARROWS);
                if (j > 0) {
                    innerarrow.setBaseDamage(innerarrow.getBaseDamage() + (double) j * 0.5D + 0.5D);
                }

                int k = stack.getEnchantmentLevel(Enchantments.PUNCH_ARROWS);
                if (k > 0) {
                    innerarrow.setKnockback(k);
                }

                if (stack.getEnchantmentLevel(Enchantments.FLAMING_ARROWS) > 0) {
                    innerarrow.setSecondsOnFire(100);
                }
                abstractarrowentity.setArrow(innerarrow);

                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
                if (flag1 || player.getAbilities().instabuild && (stack.getItem() == Items.SPECTRAL_ARROW || stack.getItem() == Items.TIPPED_ARROW)) {
                    abstractarrowentity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                world.addFreshEntity(abstractarrowentity);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            if (!flag1 && !player.getAbilities().instabuild) {
                ammo.shrink(1);
                if (ammo.isEmpty()) {
                    player.getInventory().removeItem(ammo);
                }
            }

            player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        }
        event.setCanceled(true);
    }

}
