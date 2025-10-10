package net.multyfora.justbetterchainmail.item.custom;


import net.minecraft.item.Item;

public class ModArmorItem extends Item {


    public ModArmorItem(Settings settings) {
        super(settings);
    }

    // optional helpers if you want item-specific code
    public static boolean isChainmailItem(net.minecraft.item.ItemStack stack) {
        return stack.getItem() instanceof ModArmorItem;
    }
}
