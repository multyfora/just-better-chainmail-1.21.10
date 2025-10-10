package net.multyfora.justbetterchainmail;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.multyfora.justbetterchainmail.datagen.ModItemTagProvider;
import net.multyfora.justbetterchainmail.datagen.ModModelProvider;
import net.multyfora.justbetterchainmail.datagen.ModRecipeProvider;

public class JustBetterChainmailDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
	}
}
