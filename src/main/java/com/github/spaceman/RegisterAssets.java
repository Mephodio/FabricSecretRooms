package com.github.spaceman;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.models.JModel;

import net.minecraft.util.Identifier;

public class RegisterAssets {
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack
            .create(new Identifier(SecretRooms.MOD_ID, "client_pack"));

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
            String textureTranslationKey = SecretRooms.copyBlockList.get(i).getTranslationKey()
                    .replaceAll("block\\.minecraft\\.", "");

            // Add Glass Blockstates
            RESOURCE_PACK.addBlockState(
                JState.state().add(JState.variant()
                        .put("facing", "up", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).x(270).uvlock())
                        .put("facing", "down", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).x(90).uvlock())
                        .put("facing", "north", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).uvlock())
                        .put("facing", "east", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).y(90).uvlock())
                        .put("facing", "south", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).y(180).uvlock())
                        .put("facing", "west", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).y(270).uvlock())),
                new Identifier(SecretRooms.MOD_ID, glassTranslationKey)
            );

            // Add Ghost Blockstates
            RESOURCE_PACK.addBlockState(
                JState.state().add(JState.variant(JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + ghostBlockTranslationKey)))),
                new Identifier(SecretRooms.MOD_ID, ghostBlockTranslationKey)
            );

            // Add Glass Block Model
            RESOURCE_PACK.addModel(
                JModel.model().parent("block/cube").textures(JModel.textures()
                    .particle("minecraft:block/" + textureTranslationKey)
                    .var("south", "minecraft:block/" + textureTranslationKey)
                    .var("north", "minecraft:block/glass")
                    .var("east", "minecraft:block/" + textureTranslationKey)
                    .var("down", "minecraft:block/" + textureTranslationKey)
                    .var("up", "minecraft:block/" + textureTranslationKey)
                    .var("west", "minecraft:block/" + textureTranslationKey)
                ),
                new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)
            );

            // Add Ghost Block Model
            RESOURCE_PACK.addModel(
                JModel.model().parent("minecraft:block/"+textureTranslationKey),
                new Identifier(SecretRooms.MOD_ID, "block/" + ghostBlockTranslationKey)
            );

            // Add Glass Block Item Model
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID + ":block/" + glassTranslationKey),
                new Identifier(SecretRooms.MOD_ID, "item/" + glassTranslationKey)
            );

            // Add Ghost Block Item Model
            RESOURCE_PACK.addModel(
                JModel.model().parent("minecraft:item/generated").textures(JModel.textures()
                    .layer0(SecretRooms.MOD_ID+":item/"+ghostBlockTranslationKey)),
                new Identifier(SecretRooms.MOD_ID, "item/" + ghostBlockTranslationKey)
            );

            // Add Camo Door Item Model
            RESOURCE_PACK.addModel(
                JModel.model().parent("minecraft:item/generated").textures(JModel.textures()
                    .layer0(SecretRooms.MOD_ID + ":item/" + camoDoorTranslationKey)),
                new Identifier(SecretRooms.MOD_ID, "item/" + camoDoorTranslationKey)
            );

            // Add Camo Trapdoor Item Model
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID + ":block/" + camoTrapdoorTranslationKey),
                new Identifier(SecretRooms.MOD_ID, "item/" + camoTrapdoorTranslationKey)
            );

            RESOURCE_PACK.addLang(new Identifier(SecretRooms.MOD_ID + "_" + textureTranslationKey, "en_us"), JLang
                    .lang()
                    .entry("block." + SecretRooms.MOD_ID + "." + glassTranslationKey, stringClean(glassTranslationKey))
                    .entry("block." + SecretRooms.MOD_ID + "." + camoDoorTranslationKey, stringClean(camoDoorTranslationKey))
                    .entry("block." + SecretRooms.MOD_ID + "." + camoTrapdoorTranslationKey, stringClean(camoTrapdoorTranslationKey))
                    .entry("block." + SecretRooms.MOD_ID + "." + ghostBlockTranslationKey, stringClean(ghostBlockTranslationKey))
            );
        }

        RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));
        // //camo trapdoor block model
        // pack.addBlockModel(new Identifier(SecretRooms.MOD_ID,
        // camoTrapdoorTranslationKey+"_bottom"), model -> model
        // .parent(new Identifier(SecretRooms.MOD_ID,
        // "block/template_orientable_trapdoor_bottom"))
        // .texture("texture", new Identifier("minecraft:block/"+textureTranslationKey))
        // );
        // pack.addBlockModel(new Identifier(SecretRooms.MOD_ID,
        // camoTrapdoorTranslationKey+"_top"), model -> model
        // .parent(new Identifier(SecretRooms.MOD_ID,
        // "block/template_orientable_trapdoor_top"))
        // .texture("texture", new Identifier("minecraft:block/"+textureTranslationKey))
        // );
        // pack.addBlockModel(new Identifier(SecretRooms.MOD_ID,
        // camoTrapdoorTranslationKey+"_open"), model -> model
        // .parent(new Identifier(SecretRooms.MOD_ID,
        // "block/template_orientable_trapdoor_open"))
        // .texture("texture", new Identifier("minecraft:block/"+textureTranslationKey))
        // );
        // //Camo door blockstate
        // pack.addBlockState(new Identifier(SecretRooms.MOD_ID,
        // camoDoorTranslationKey), state -> state
        // .variant("facing=east,half=lower,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .uvlock(true)
        // )
        // .variant("facing=east,half=lower,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=east,half=lower,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .uvlock(true)
        // )
        // .variant("facing=east,half=lower,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=east,half=upper,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .uvlock(true)
        // )
        // .variant("facing=east,half=upper,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=east,half=upper,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .uvlock(true)
        // )
        // .variant("facing=east,half=upper,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=lower,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=lower,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .uvlock(true)
        // )
        // .variant("facing=north,half=lower,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=lower,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=upper,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=upper,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .uvlock(true)
        // )
        // .variant("facing=north,half=upper,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=upper,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=lower,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=lower,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=lower,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=lower,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .uvlock(true)
        // )
        // .variant("facing=south,half=upper,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=upper,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=upper,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=upper,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .uvlock(true)
        // )
        // .variant("facing=west,half=lower,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=lower,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=lower,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom_hinge"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=lower,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_bottom"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=upper,hinge=left,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=upper,hinge=left,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=upper,hinge=right,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top_hinge"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=upper,hinge=right,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoDoorTranslationKey+"_top"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // );
        // //Camo trapdoor blockstate
        // pack.addBlockState(new Identifier(SecretRooms.MOD_ID,
        // camoTrapdoorTranslationKey), state -> state
        // .variant("facing=north,half=bottom,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_bottom"))
        // .uvlock(true)
        // )
        // .variant("facing=south,half=bottom,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_bottom"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=east,half=bottom,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_bottom"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=bottom,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_bottom"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=top,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_top"))
        // .uvlock(true)
        // )
        // .variant("facing=south,half=top,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_top"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=east,half=top,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_top"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=top,open=false", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_top"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=bottom,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .uvlock(true)
        // )
        // .variant("facing=south,half=bottom,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=east,half=bottom,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .rotationY(90)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=bottom,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=north,half=top,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .rotationX(180)
        // .rotationY(180)
        // .uvlock(true)
        // )
        // .variant("facing=south,half=top,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .rotationX(180)
        // .rotationY(0)
        // .uvlock(true)
        // )
        // .variant("facing=east,half=top,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .rotationX(180)
        // .rotationY(270)
        // .uvlock(true)
        // )
        // .variant("facing=west,half=top,open=true", variant -> variant
        // .model(new Identifier(SecretRooms.MOD_ID,
        // "block/"+camoTrapdoorTranslationKey+"_open"))
        // .rotationX(180)
        // .rotationY(90)
        // .uvlock(true)
        // )
        // );

        // //Camo door block model
        // pack.addBlockModel(new Identifier(SecretRooms.MOD_ID,
        // camoDoorTranslationKey+"_bottom"), model -> model
        // .parent(new Identifier(SecretRooms.MOD_ID, "block/door_bottom"))
        // .texture("top", new Identifier("minecraft:block/"+textureTranslationKey))
        // .texture("bottom", new Identifier("minecraft:block/"+textureTranslationKey))
        // );
        // pack.addBlockModel(new Identifier(SecretRooms.MOD_ID,
        // camoDoorTranslationKey+"_bottom_hinge"), model -> model
        // .parent(new Identifier(SecretRooms.MOD_ID, "block/door_bottom_hinge"))
        // .texture("top", new Identifier("minecraft:block/"+textureTranslationKey))
        // .texture("bottom", new Identifier("minecraft:block/"+textureTranslationKey))
        // );
        // pack.addBlockModel(new Identifier(SecretRooms.MOD_ID,
        // camoDoorTranslationKey+"_top"), model -> model
        // .parent(new Identifier(SecretRooms.MOD_ID, "block/door_top"))
        // .texture("top", new Identifier("minecraft:block/"+textureTranslationKey))
        // .texture("bottom", new Identifier("minecraft:block/"+textureTranslationKey))
        // );
        // pack.addBlockModel(new Identifier(SecretRooms.MOD_ID,
        // camoDoorTranslationKey+"_top_hinge"), model -> model
        // .parent(new Identifier(SecretRooms.MOD_ID, "block/door_top_hinge"))
        // .texture("top", new Identifier("minecraft:block/"+textureTranslationKey))
        // .texture("bottom", new Identifier("minecraft:block/"+textureTranslationKey))
        // );

    }

    static String stringClean(String input) {
        String output = "";
        for (int i = 0; i < input.split("_").length; i++) {
            output += (Character.toUpperCase(input.split("_")[i].charAt(0)) + input.split("_")[i].substring(1));
            if (i != input.split("_").length - 1) {
                output += " ";
            }
        }
        return output;
    }
}