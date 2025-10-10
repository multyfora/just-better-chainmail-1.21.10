package net.multyfora.justbetterchainmail.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.ItemStack;


import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.multyfora.justbetterchainmail.item.custom.ModArmorItem;
import net.multyfora.justbetterchainmail.util.ModCriteria;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "damage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)Z",
            at = @At("HEAD"), cancellable = true)
    private void onDamage(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (!((Object) this instanceof PlayerEntity player)) return;

        // Only handle arrow damage
        if (!isProtectedDamageType(source)) return;


        int chainmailPieces = countChainmailPieces(player);

        // No protection at all
        if (chainmailPieces == 0) return;

        // Full set = full immunity
        if (chainmailPieces == 4) {
            if (source.isOf(DamageTypes.ARROW)) {
                ModCriteria.NULLIFY_DAMAGE_FROM_ARROW.trigger((ServerPlayerEntity) player);
            }
            cir.setReturnValue(false);
            cir.cancel();
            return;
        }

//        // Partial set = reduce arrow damage by 25% per piece
//        float reduction = 0.25F * chainmailPieces;
//        float reducedDamage = amount * (1.0F - reduction);
//
//        // Apply reduced damage manually
//        LivingEntity self = (LivingEntity) (Object) this;
//
//        System.out.println(reducedDamage + ": pieces: " + chainmailPieces);
//        self.damage(world, source, reducedDamage);
//
//        cir.setReturnValue(true);
//        cir.cancel();
    }


    private boolean isProtectedDamageType(DamageSource source) {
        // Covers arrows, cactus, and stalagmites
        return source.isOf(DamageTypes.ARROW)
                || source.isOf(DamageTypes.CACTUS)
                || source.isOf(DamageTypes.STALAGMITE)
                || source.isOf(DamageTypes.FALLING_STALACTITE);
    }

    private int countChainmailPieces(PlayerEntity player) {
        int count = 0;
        if (isChainmailPiece(player, EquipmentSlot.HEAD)) count++;
        if (isChainmailPiece(player, EquipmentSlot.CHEST)) count++;
        if (isChainmailPiece(player, EquipmentSlot.LEGS)) count++;
        if (isChainmailPiece(player, EquipmentSlot.FEET)) count++;
        return count;
    }

    private boolean isChainmailPiece(PlayerEntity player, EquipmentSlot slot) {
        ItemStack stack = player.getEquippedStack(slot);
        return stack != null && (stack.getItem() instanceof ModArmorItem
                || stack.getItem() == Items.CHAINMAIL_BOOTS
                || stack.getItem() == Items.CHAINMAIL_LEGGINGS
                || stack.getItem() == Items.CHAINMAIL_CHESTPLATE
                || stack.getItem() == Items.CHAINMAIL_HELMET);

    }
}
