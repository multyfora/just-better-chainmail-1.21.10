package net.multyfora.justbetterchainmail.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.multyfora.justbetterchainmail.JustBetterChainmail;

public class ModTags {


    public static class Items {
//        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> COPPER_CHAINS = createTag("copper_chains");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(JustBetterChainmail.MOD_ID, name));
        }
    }
}