package net.multyfora.justbetterchainmail.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.multyfora.justbetterchainmail.JustBetterChainmail;
import net.multyfora.justbetterchainmail.util.ModTags;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> COPPER_CHAIN_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(JustBetterChainmail.MOD_ID, "copper_chain"));

    public static final ArmorMaterial COPPER_CHAINMAIL_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 1);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 5);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 4);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,0,0, ModTags.Items.COPPER_CHAINS, COPPER_CHAIN_KEY);
}