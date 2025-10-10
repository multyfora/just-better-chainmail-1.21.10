package net.multyfora.justbetterchainmail.item;

import net.multyfora.justbetterchainmail.JustBetterChainmail;

public class ModItemGroups {

//    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
//            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
//            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
//                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
//                    .entries((displayContext, entries) -> {
//                        entries.add(ModItems.PINK_GARNET);
//                        entries.add(ModItems.RAW_PINK_GARNET);
//                    }).build());



    public static void registerItemGroups() {
        JustBetterChainmail.LOGGER.info("Registering Item Groups for " + JustBetterChainmail.MOD_ID);

    }
}