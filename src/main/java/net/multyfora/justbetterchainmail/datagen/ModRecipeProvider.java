package net.multyfora.justbetterchainmail.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryWrapper;
import net.multyfora.justbetterchainmail.item.ModItems;
import net.multyfora.justbetterchainmail.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {

                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_CHAINMAIL_HELMET)
                        .pattern("XXX")
                        .pattern("X X")
                        .input('X', ModTags.Items.COPPER_CHAINS)
                        .criterion(hasItem(Blocks.COPPER_CHAINS.unaffected()), conditionsFromItem(Blocks.COPPER_CHAINS.unaffected()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_CHAINMAIL_CHESTPLATE)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .input('X', ModTags.Items.COPPER_CHAINS)
                        .criterion(hasItem(Blocks.COPPER_CHAINS.unaffected()), conditionsFromItem(Blocks.COPPER_CHAINS.unaffected()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_CHAINMAIL_LEGGINGS)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .input('X', ModTags.Items.COPPER_CHAINS)
                        .criterion(hasItem(Blocks.COPPER_CHAINS.unaffected()), conditionsFromItem(Blocks.COPPER_CHAINS.unaffected()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_CHAINMAIL_BOOTS)
                        .pattern("X X")
                        .pattern("X X")
                        .input('X', ModTags.Items.COPPER_CHAINS)
                        .criterion(hasItem(Blocks.COPPER_CHAINS.unaffected()), conditionsFromItem(Blocks.COPPER_CHAINS.unaffected()))
                        .offerTo(exporter);



                //regular chainmail

                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                        .pattern("XXX")
                        .pattern("X X")
                        .input('X', Items.IRON_CHAIN)
                        .criterion(hasItem(Items.IRON_CHAIN), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .input('X', Items.IRON_CHAIN)
                        .criterion(hasItem(Items.IRON_CHAIN), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .input('X', Items.IRON_CHAIN)
                        .criterion(hasItem(Items.IRON_CHAIN), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                        .pattern("X X")
                        .pattern("X X")
                        .input('X', Items.IRON_CHAIN)
                        .criterion(hasItem(Items.IRON_CHAIN), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
