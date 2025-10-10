package net.multyfora.justbetterchainmail.item;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.multyfora.justbetterchainmail.JustBetterChainmail;
import net.multyfora.justbetterchainmail.item.custom.ModArmorItem;

import java.util.function.Function;

public class ModItems {

    public static final Item COPPER_CHAINMAIL_HELMET = registerItem("copper_chainmail_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.COPPER_CHAINMAIL_ARMOR_MATERIAL, EquipmentType.HELMET)));
  public static final Item COPPER_CHAINMAIL_CHESTPLATE = registerItem("copper_chainmail_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.COPPER_CHAINMAIL_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
  public static final Item COPPER_CHAINMAIL_LEGGINGS = registerItem("copper_chainmail_leggings",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.COPPER_CHAINMAIL_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
  public static final Item COPPER_CHAINMAIL_BOOTS = registerItem("copper_chainmail_boots",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.COPPER_CHAINMAIL_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(JustBetterChainmail.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JustBetterChainmail.MOD_ID, name)))));
    }

    public static void registerModItems() {
        JustBetterChainmail.LOGGER.info("Registering Mod Items for " + JustBetterChainmail.MOD_ID);

    }
}