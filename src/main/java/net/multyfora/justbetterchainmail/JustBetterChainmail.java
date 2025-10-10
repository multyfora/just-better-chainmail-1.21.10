package net.multyfora.justbetterchainmail;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.multyfora.justbetterchainmail.item.ModItemGroups;
import net.multyfora.justbetterchainmail.item.ModItems;
import net.multyfora.justbetterchainmail.util.ModCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class JustBetterChainmail implements ModInitializer {
	public static final String MOD_ID = "just-better-chainmail";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModCriteria.init();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.CHAINMAIL_BOOTS, ModItems.COPPER_CHAINMAIL_HELMET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(ModItems.COPPER_CHAINMAIL_HELMET, ModItems.COPPER_CHAINMAIL_CHESTPLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(ModItems.COPPER_CHAINMAIL_CHESTPLATE, ModItems.COPPER_CHAINMAIL_LEGGINGS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(ModItems.COPPER_CHAINMAIL_LEGGINGS, ModItems.COPPER_CHAINMAIL_BOOTS);
        });





    }
}