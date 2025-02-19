package com.github.spaceman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SecretRooms implements ModInitializer {
	public static Map<Block, OneWayGlassBlock> glassCopyBlockMap = new HashMap<Block, OneWayGlassBlock>();
	public static Map<Block, CamoDoorBlock> doorCopyBlockMap = new HashMap<Block, CamoDoorBlock>();
	public static Map<Block, Block> ghostCopyBlockMap = new HashMap<Block, Block>();
	public static Map<Block, CamoTrapdoorBlock> trapdoorCopyBlockMap = new HashMap<Block, CamoTrapdoorBlock>();
	public static List<Block> copyBlockList = new ArrayList<Block>();
	public static final Map<Block, BlockState> wailaOverrides = new HashMap<>();
	public static final Item CAMO_PASTE = new Item(new Item.Settings().group(SecretRooms.MAIN_GROUP).recipeRemainder(Items.BUCKET).maxCount(16));
	public static final TorchLeverBlock TORCH_LEVER_BLOCK = new TorchLeverBlock(AbstractBlock.Settings.copy(Blocks.TORCH).luminance(createLightLevelFromBlockState(14)));
	public static final TorchLeverBlock SOUL_TORCH_LEVER_BLOCK = new SoulTorchLeverBlock(AbstractBlock.Settings.copy(Blocks.SOUL_TORCH).luminance(createLightLevelFromBlockState(10)));
	public static final SolidAirBlock SOLID_AIR_BLOCK = new SolidAirBlock(FabricBlockSettings.of(Material.GLASS).hardness(.45f).nonOpaque());
	public static final LanternButtonBlock LANTERN_BUTTON_BLOCK = new LanternButtonBlock(AbstractBlock.Settings.copy(Blocks.LANTERN).luminance(createLightLevelFromBlockState(15)));
	public static final LanternButtonBlock SOUL_LANTERN_BUTTON_BLOCK = new LanternButtonBlock(AbstractBlock.Settings.copy(Blocks.SOUL_LANTERN).luminance(createLightLevelFromBlockState(10)));
	public static final RedstoneChainBlock REDSTONE_CHAIN = new RedstoneChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN));
	public static final String MOD_ID = "secretrooms";


	public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
		new Identifier(MOD_ID, "general"))
		.icon(() -> new ItemStack(SecretRooms.CAMO_PASTE))
		.appendItems(stacks ->
		{
			stacks.add(new ItemStack(SecretRooms.CAMO_PASTE));
			stacks.add(new ItemStack(SecretRooms.SOLID_AIR_BLOCK));
			stacks.add(new ItemStack(SecretRooms.TORCH_LEVER_BLOCK));
			stacks.add(new ItemStack(SecretRooms.SOUL_TORCH_LEVER_BLOCK));
			stacks.add(new ItemStack(SecretRooms.LANTERN_BUTTON_BLOCK));
			stacks.add(new ItemStack(SecretRooms.SOUL_LANTERN_BUTTON_BLOCK));
			stacks.add(new ItemStack(SecretRooms.REDSTONE_CHAIN));
			for (int i = 0; i < copyBlockList.size(); i++){
				Block block = copyBlockList.get(i);
				OneWayGlassBlock oneWayGlassBlock = glassCopyBlockMap.get(block);
				stacks.add(new ItemStack(oneWayGlassBlock));
			}
			for (int i = 0; i < copyBlockList.size(); i++){
				Block block = copyBlockList.get(i);
				CamoDoorBlock camoDoorBlock = doorCopyBlockMap.get(block);
				stacks.add(new ItemStack(camoDoorBlock));
			}
			for (int i = 0; i < copyBlockList.size(); i++){
				Block block = copyBlockList.get(i);
				Block ghostBlock = ghostCopyBlockMap.get(block);
				stacks.add(new ItemStack(ghostBlock));
			}
			for (int i = 0; i < copyBlockList.size(); i++){
				Block block = copyBlockList.get(i);
				Block trapdoorBlock = trapdoorCopyBlockMap.get(block);
				stacks.add(new ItemStack(trapdoorBlock));
			}
		}).build();

	private void registerOneWayGlassBlocks() {
		for (int i = 0; i < copyBlockList.size(); i++){
			Block block = copyBlockList.get(i);
			glassCopyBlockMap.put(block, new OneWayGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)));
			wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.", "")+"_glass"), glassCopyBlockMap.get(block)),
					block.getDefaultState());
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.", "")+"_glass"), new BlockItem(glassCopyBlockMap.get(block), new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		}
	}

	private void registerCamoDoorBlocks() {
		for (int i = 0; i < copyBlockList.size(); i++){
			Block block = copyBlockList.get(i);
			doorCopyBlockMap.put(block, new CamoDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR)));
			wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.", "")+"_camo_door"), doorCopyBlockMap.get(block)),
					block.getDefaultState());
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.", "")+"_camo_door"), new BlockItem(doorCopyBlockMap.get(block), new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		}
	}

	private void registerGhostBlocks() {
		for (int i = 0; i < copyBlockList.size(); i++){
			Block block = copyBlockList.get(i);
			ghostCopyBlockMap.put(block, new Block(FabricBlockSettings.copyOf(Blocks.SCAFFOLDING).noCollision()));
			wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.", "")+"_ghost_block"), ghostCopyBlockMap.get(block)),
					block.getDefaultState());
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.", "")+"_ghost_block"), new BlockItem(ghostCopyBlockMap.get(block), new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		}
	}

	private void registerCamoTrapdoorBlocks() {
		for (int i = 0; i < copyBlockList.size(); i++){
			Block block = copyBlockList.get(i);
			trapdoorCopyBlockMap.put(block, new CamoTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)));
			wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID, block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.", "")+"_camo_trapdoor"), trapdoorCopyBlockMap.get(block)),
					block.getDefaultState());
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, block.getTranslationKey().replaceAll("block\\.(minecraft|blockus)\\.","")+"_camo_trapdoor"), new BlockItem(trapdoorCopyBlockMap.get(block), new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		}
	}

	private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
		return (blockState) -> {
			return !(Boolean)blockState.get(Properties.POWERED) ? litLevel : 0;
		};
	}
				
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_paste"), CAMO_PASTE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "torch_lever"), new BlockItem(TORCH_LEVER_BLOCK, new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "soul_torch_lever"), new BlockItem(SOUL_TORCH_LEVER_BLOCK, new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "solid_air"), new BlockItem(SOLID_AIR_BLOCK, new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lantern_button"), new BlockItem(LANTERN_BUTTON_BLOCK, new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "soul_lantern_button"), new BlockItem(SOUL_LANTERN_BUTTON_BLOCK, new Item.Settings().group(SecretRooms.MAIN_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "redstone_chain"), new BlockItem(REDSTONE_CHAIN, new Item.Settings().group(SecretRooms.MAIN_GROUP)));

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID , "solid_air"), SOLID_AIR_BLOCK);

		wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , "torch_lever"), TORCH_LEVER_BLOCK),
				Blocks.TORCH.getDefaultState());
		wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , "soul_torch_lever"), SOUL_TORCH_LEVER_BLOCK),
				Blocks.SOUL_TORCH.getDefaultState());
		wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , "lantern_button"), LANTERN_BUTTON_BLOCK),
				Blocks.LANTERN.getDefaultState());
		wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , "soul_lantern_button"), SOUL_LANTERN_BUTTON_BLOCK),
				Blocks.SOUL_LANTERN.getDefaultState());
		wailaOverrides.put(Registry.register(Registry.BLOCK, new Identifier(MOD_ID , "redstone_chain"), REDSTONE_CHAIN),
				Blocks.CHAIN.getDefaultState());

		VanillaList.addBlocks();
		registerOneWayGlassBlocks();
		registerGhostBlocks();
		registerCamoDoorBlocks();
		registerCamoTrapdoorBlocks();

		RegisterData.register();	
		
	}
}	
