package com.github.spaceman;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class RegisterData {
    public static final RuntimeResourcePack DATA_PACK = RuntimeResourcePack.create(new Identifier(SecretRooms.MOD_ID, "secret_rooms_data"));

    public static void register() {
        for (int i = 0; i < SecretRooms.copyBlockList.size(); i++) {
            String glassTranslationKey = SecretRooms.copyBlockList.get(i).getTranslationKey()
                .replaceAll("block\\.minecraft\\.", "") + "_glass";
            String camoDoorTranslationKey = SecretRooms.copyBlockList.get(i).getTranslationKey()
                    .replaceAll("block\\.minecraft\\.", "") + "_camo_door";
            String ghostBlockTranslationKey = SecretRooms.copyBlockList.get(i).getTranslationKey()
                    .replaceAll("block\\.minecraft\\.", "") + "_ghost_block";
            String camoTrapdoorTranslationKey = SecretRooms.copyBlockList.get(i).getTranslationKey()
                    .replaceAll("block\\.minecraft\\.", "") + "_camo_trapdoor";
            String baseTranslationKey = SecretRooms.copyBlockList.get(i).getTranslationKey()
                    .replaceAll("block\\.minecraft\\.", "");


            DATA_PACK.addRecipe(
                new Identifier(SecretRooms.MOD_ID, glassTranslationKey), 
                JRecipe.shapeless(JIngredients.ingredients()
                    .add(JIngredient.ingredient().item("minecraft:" + baseTranslationKey))
                    .add(JIngredient.ingredient().item(Items.GLASS))
                    .add(JIngredient.ingredient().item(SecretRooms.CAMO_PASTE)), 
                JResult.result(SecretRooms.MOD_ID + ":" + glassTranslationKey))
            );

            DATA_PACK.addRecipe(
                new Identifier(SecretRooms.MOD_ID, ghostBlockTranslationKey), 
                JRecipe.shapeless(JIngredients.ingredients()
                    .add(JIngredient.ingredient().item("minecraft:" + baseTranslationKey))
                    .add(JIngredient.ingredient().item(Items.SCAFFOLDING))
                    .add(JIngredient.ingredient().item(SecretRooms.CAMO_PASTE)), 
                JResult.result(SecretRooms.MOD_ID + ":" + ghostBlockTranslationKey))
            );

            DATA_PACK.addRecipe(
                new Identifier(SecretRooms.MOD_ID, camoDoorTranslationKey), 
                JRecipe.shapeless(JIngredients.ingredients()
                    .add(JIngredient.ingredient().item("minecraft:" + baseTranslationKey))
                    .add(JIngredient.ingredient()
                        .item(Items.OAK_DOOR)
                        .item(Items.BIRCH_DOOR)
                        .item(Items.SPRUCE_DOOR)
                        .item(Items.ACACIA_DOOR)
                        .item(Items.JUNGLE_DOOR)
                        .item(Items.DARK_OAK_DOOR)
                        .item(Items.CRIMSON_DOOR)
                        .item(Items.WARPED_DOOR)
                    )
                    .add(JIngredient.ingredient().item(SecretRooms.CAMO_PASTE)), 
                JResult.result(SecretRooms.MOD_ID + ":" + camoDoorTranslationKey))
            );

            DATA_PACK.addRecipe(
                new Identifier(SecretRooms.MOD_ID, camoTrapdoorTranslationKey), 
                JRecipe.shapeless(JIngredients.ingredients()
                    .add(JIngredient.ingredient().item("minecraft:" + baseTranslationKey))
                    .add(JIngredient.ingredient()
                        .item(Items.OAK_TRAPDOOR)
                        .item(Items.BIRCH_TRAPDOOR)
                        .item(Items.SPRUCE_TRAPDOOR)
                        .item(Items.ACACIA_TRAPDOOR)
                        .item(Items.JUNGLE_TRAPDOOR)
                        .item(Items.DARK_OAK_TRAPDOOR)
                        .item(Items.CRIMSON_TRAPDOOR)
                        .item(Items.WARPED_TRAPDOOR)
                    )
                    .add(JIngredient.ingredient().item(SecretRooms.CAMO_PASTE)), 
                JResult.result(SecretRooms.MOD_ID + ":" + camoTrapdoorTranslationKey))
            );

            DATA_PACK.addLootTable(
                new Identifier(SecretRooms.MOD_ID, "blocks/"+ghostBlockTranslationKey), 
                JLootTable.loot("minecraft:block").pool(
                    JLootTable.pool()
                        .rolls(1)
                        .entry(JLootTable.entry()
                            .type("minecraft:item")
                            .name(SecretRooms.MOD_ID+":"+ghostBlockTranslationKey)))
            );
            DATA_PACK.addLootTable(
                new Identifier(SecretRooms.MOD_ID, "blocks/"+camoTrapdoorTranslationKey), 
                JLootTable.loot("minecraft:block").pool(
                    JLootTable.pool()
                        .rolls(1)
                        .entry(JLootTable.entry()
                            .type("minecraft:item")
                            .name(SecretRooms.MOD_ID+":"+camoTrapdoorTranslationKey)))
            );
        }
        RRPCallback.AFTER_VANILLA.register(a -> a.add(DATA_PACK));
    }
}