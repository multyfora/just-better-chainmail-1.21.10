package net.multyfora.justbetterchainmail.mixin;

import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.DynamicTexture;
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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    //this line took more then all the other code combined :)
    @Inject(method = "damage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)Z",
            at = @At("HEAD"), cancellable = true)
    private void onDamage(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (!((Object) this instanceof PlayerEntity player)) return;

        // if its only arrows
        if (!source.isOf(DamageTypes.ARROW)) return;

        int chainmailPieces = countChainmailPieces(player);
        if (chainmailPieces < 4) return;

        // Trigger advancement
        ModCriteria.NULLIFY_DAMAGE_FROM_ARROW.trigger((ServerPlayerEntity) player);

        // Prevent all real effects
        player.timeUntilRegen = 0;
        player.hurtTime = 0;
        player.limbAnimator.setSpeed(0.0F);
        player.setVelocity(0, 0, 0);


        cir.setReturnValue(true);
        cir.cancel();
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
