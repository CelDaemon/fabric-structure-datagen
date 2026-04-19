package net.voidgroup.proto.structuredatagen.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class StructureDatagenPrototypeDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		final var pack = fabricDataGenerator.createPack();
		pack.addProvider(StructuresProvider::new);
		pack.addProvider(StructureSetsProvider::new);
		pack.addProvider(StructureTemplatePoolsProvider::new);
		pack.addProvider(BiomeTagsProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.TEMPLATE_POOL, StructureTemplatePoolsProvider::bootstrap);
		registryBuilder.add(Registries.STRUCTURE, StructuresProvider::bootstrap);
		registryBuilder.add(Registries.STRUCTURE_SET, StructureSetsProvider::bootstrap);
	}
}
