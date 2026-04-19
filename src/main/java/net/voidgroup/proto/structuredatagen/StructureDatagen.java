package net.voidgroup.proto.structuredatagen;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StructureDatagen {
	public static final ResourceKey<Structure> CREEPY_STRUCTURE =
			ResourceKey.create(Registries.STRUCTURE, id("creepy"));
	public static final ResourceKey<StructureTemplatePool> CREEPY_POOL =
			ResourceKey.create(Registries.TEMPLATE_POOL, id("creepy"));

	public static final ResourceKey<StructureSet> CREEPY_SET =
			ResourceKey.create(Registries.STRUCTURE_SET, id("creepy"));
	public static final Identifier HEROBRINE_ELEMENT = id("herobrine");
	public static final TagKey<Biome> CAN_GENERATE_CREEPY = TagKey.create(Registries.BIOME, id("can_generate_creepy"));
	public static final String MOD_ID = "structure-datagen";

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}