package net.multyfora.justbetterchainmail.util;

import net.minecraft.advancement.criterion.Criteria;
import net.multyfora.justbetterchainmail.JustBetterChainmail;
import net.multyfora.justbetterchainmail.criterion.NullifyDammageFromArrowCriterion;

public class ModCriteria {
    public static final NullifyDammageFromArrowCriterion NULLIFY_DAMAGE_FROM_ARROW = Criteria.register(JustBetterChainmail.MOD_ID + ":nullify_damage_from_arrow", new NullifyDammageFromArrowCriterion());


    public static void init(){
        JustBetterChainmail.LOGGER.info("Initializing criteria for " + JustBetterChainmail.MOD_ID);
    }
}