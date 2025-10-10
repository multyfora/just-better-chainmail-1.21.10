package net.multyfora.justbetterchainmail.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.multyfora.justbetterchainmail.item.ModArmorMaterials;
import net.multyfora.justbetterchainmail.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(ModItems.COPPER_CHAINMAIL_HELMET, Models.GENERATED);
//        itemModelGenerator.register(ModItems.COPPER_CHAINMAIL_CHESTPLATE, Models.GENERATED);
//        itemModelGenerator.register(ModItems.COPPER_CHAINMAIL_LEGGINGS, Models.GENERATED);
//        itemModelGenerator.register(ModItems.COPPER_CHAINMAIL_BOOTS, Models.GENERATED);


        itemModelGenerator.registerArmor(ModItems.COPPER_CHAINMAIL_HELMET, ModArmorMaterials.COPPER_CHAIN_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.COPPER_CHAINMAIL_CHESTPLATE, ModArmorMaterials.COPPER_CHAIN_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.COPPER_CHAINMAIL_LEGGINGS, ModArmorMaterials.COPPER_CHAIN_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.COPPER_CHAINMAIL_BOOTS, ModArmorMaterials.COPPER_CHAIN_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

    }
}
