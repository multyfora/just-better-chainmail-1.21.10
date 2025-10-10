package net.multyfora.justbetterchainmail.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.multyfora.justbetterchainmail.JustBetterChainmail;
import net.multyfora.justbetterchainmail.criterion.NullifyDammageFromArrowCriterion;
import net.multyfora.justbetterchainmail.util.ModCriteria;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        AdvancementEntry bulletproof = Advancement.Builder.create()
                .parent(new AdvancementEntry(Identifier.of("minecraft", "adventure/root"),null))
                .display(
                        Items.ARROW,
                        Text.literal("Bulletproof"),
                        Text.literal("get shot at while wearing full chainmail armor"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_shot_at_wearing_chainmail", ModCriteria.NULLIFY_DAMAGE_FROM_ARROW.create(new NullifyDammageFromArrowCriterion.Conditions(Optional.empty())))
                .build(consumer, JustBetterChainmail.MOD_ID + ":get_shot_at_wearing_chainmail");
    }
}