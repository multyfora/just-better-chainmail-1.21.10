package net.multyfora.justbetterchainmail.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.multyfora.justbetterchainmail.item.ModItems;
import net.multyfora.justbetterchainmail.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.COPPER_CHAINS)
                .add(Blocks.COPPER_CHAINS.unaffected().asItem())
                .add(Blocks.COPPER_CHAINS.exposed().asItem())
                .add(Blocks.COPPER_CHAINS.weathered().asItem())
                .add(Blocks.COPPER_CHAINS.oxidized().asItem())
                .add(Blocks.COPPER_CHAINS.waxed().asItem())
                .add(Blocks.COPPER_CHAINS.waxedExposed().asItem())
                .add(Blocks.COPPER_CHAINS.waxedWeathered().asItem())
                .add(Blocks.COPPER_CHAINS.waxedOxidized().asItem());

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_CHAINMAIL_HELMET)
                .add(ModItems.COPPER_CHAINMAIL_CHESTPLATE)
                .add(ModItems.COPPER_CHAINMAIL_LEGGINGS)
                .add(ModItems.COPPER_CHAINMAIL_BOOTS);
    }
}
