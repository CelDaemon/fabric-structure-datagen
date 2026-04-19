package net.voidgroup.proto.structuredatagen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.voidgroup.proto.structuredatagen.StructureDatagen;

import java.util.concurrent.CompletableFuture;

public class StructureSetsProvider extends FabricDynamicRegistryProvider {
    public StructureSetsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.STRUCTURE_SET));
    }

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        final var structureLookup = context.lookup(Registries.STRUCTURE);
        context.register(
                StructureDatagen.CREEPY_SET,
                new StructureSet(
                        structureLookup.getOrThrow(StructureDatagen.CREEPY_STRUCTURE),
                        new RandomSpreadStructurePlacement(25, 20, RandomSpreadType.TRIANGULAR, 49264810)
                )
        );
    }

    @Override
    public String getName() {
        return "Structure Sets";
    }
}
