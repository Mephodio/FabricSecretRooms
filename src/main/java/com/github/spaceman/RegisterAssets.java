package com.github.spaceman;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.util.Identifier;

public class RegisterAssets {
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(new Identifier(SecretRooms.MOD_ID, "secret_rooms_assets"));

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
                        .put("facing=up", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).x(270).uvlock())
                        .put("facing=down", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).x(90).uvlock())
                        .put("facing=north", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).uvlock())
                        .put("facing=east", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).y(90).uvlock())
                        .put("facing=south", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).y(180).uvlock())
                        .put("facing=west", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + glassTranslationKey)).y(270).uvlock())),
                new Identifier(SecretRooms.MOD_ID, glassTranslationKey)
            );

            // Add Ghost Blockstates
            RESOURCE_PACK.addBlockState(
                JState.state().add(JState.variant(JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + ghostBlockTranslationKey)))),
                new Identifier(SecretRooms.MOD_ID, ghostBlockTranslationKey)
            );

            // Add Camo Door Blockstates
            RESOURCE_PACK.addBlockState(
                JState.state().add(JState.variant()
                    .put("facing=east,half=lower,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock())
                    .put("facing=east,half=lower,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock().y(90))
                    .put("facing=east,half=lower,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock())
                    .put("facing=east,half=lower,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock().y(270))
                    .put("facing=east,half=upper,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock())
                    .put("facing=east,half=upper,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock().y(90))
                    .put("facing=east,half=upper,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock())
                    .put("facing=east,half=upper,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock().y(270))

                    .put("facing=north,half=lower,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock().y(270))
                    .put("facing=north,half=lower,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock())
                    .put("facing=north,half=lower,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock().y(270))
                    .put("facing=north,half=lower,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock().y(180))
                    .put("facing=north,half=upper,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock().y(270))
                    .put("facing=north,half=upper,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock())
                    .put("facing=north,half=upper,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock().y(270))
                    .put("facing=north,half=upper,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock().y(180))

                    .put("facing=south,half=lower,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock().y(90))
                    .put("facing=south,half=lower,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock().y(180))
                    .put("facing=south,half=lower,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock().y(90))
                    .put("facing=south,half=lower,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock())
                    .put("facing=south,half=upper,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock().y(90))
                    .put("facing=south,half=upper,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock().y(180))
                    .put("facing=south,half=upper,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock().y(90))
                    .put("facing=south,half=upper,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock())

                    .put("facing=west,half=lower,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock().y(180))
                    .put("facing=west,half=lower,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock().y(270))
                    .put("facing=west,half=lower,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom_hinge")).uvlock().y(180))
                    .put("facing=west,half=lower,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_bottom")).uvlock().y(90))
                    .put("facing=west,half=upper,hinge=left,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock().y(180))
                    .put("facing=west,half=upper,hinge=left,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock().y(270))
                    .put("facing=west,half=upper,hinge=right,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top_hinge")).uvlock().y(180))
                    .put("facing=west,half=upper,hinge=right,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey + "_top")).uvlock().y(90))
                ), 
                new Identifier(SecretRooms.MOD_ID, camoDoorTranslationKey)
            );

            // Add Camo Trapdoor Blockstates
            RESOURCE_PACK.addBlockState(
                JState.state().add(JState.variant()
                    .put("facing=north,half=bottom,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_bottom")).uvlock())
                    .put("facing=south,half=bottom,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_bottom")).uvlock().y(180))
                    .put("facing=east,half=bottom,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_bottom")).uvlock().y(90))
                    .put("facing=west,half=bottom,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_bottom")).uvlock().y(270))
                    .put("facing=north,half=top,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_top")).uvlock())
                    .put("facing=south,half=top,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_top")).uvlock().y(180))
                    .put("facing=east,half=top,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_top")).uvlock().y(90))
                    .put("facing=west,half=top,open=false", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_top")).uvlock().y(270))
                    .put("facing=north,half=bottom,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock())
                    .put("facing=south,half=bottom,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock().y(180))
                    .put("facing=east,half=bottom,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock().y(90))
                    .put("facing=west,half=bottom,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock().y(270))
                    .put("facing=north,half=top,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock().x(180).y(180))
                    .put("facing=south,half=top,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock().x(180))
                    .put("facing=east,half=top,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock().x(180).y(270))
                    .put("facing=west,half=top,open=true", JState.model(new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")).uvlock().x(180).y(90))
                ), 
                new Identifier(SecretRooms.MOD_ID, camoTrapdoorTranslationKey)
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

            // Add Camo Door Block Models
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID + ":block/door_bottom").textures(JModel.textures()
                    .var("top", "minecraft:block/" + textureTranslationKey)
                    .var("bottom", "minecraft:block/" + textureTranslationKey)
                ), 
                new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey+"_bottom")
            );

            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID + ":block/door_bottom_hinge").textures(JModel.textures()
                    .var("top", "minecraft:block/" + textureTranslationKey)
                    .var("bottom", "minecraft:block/" + textureTranslationKey)
                ), 
                new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey+"_bottom_hinge")
            );
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID + ":block/door_top").textures(JModel.textures()
                    .var("top", "minecraft:block/" + textureTranslationKey)
                    .var("bottom", "minecraft:block/" + textureTranslationKey)
                ), 
                new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey+"_top")
            );
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID + ":block/door_top_hinge").textures(JModel.textures()
                    .var("top", "minecraft:block/" + textureTranslationKey)
                    .var("bottom", "minecraft:block/" + textureTranslationKey)
                ), 
                new Identifier(SecretRooms.MOD_ID, "block/" + camoDoorTranslationKey+"_top_hinge")
            );


            // Add Camo Trapdoor Block Model
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID+":block/template_orientable_trapdoor_bottom").textures(JModel.textures()
                    .particle("minecraft:block/"+textureTranslationKey)
                    .var("texture", "minecraft:block/" + textureTranslationKey)
                ),  
                new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_bottom")
            );
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID+":block/template_orientable_trapdoor_top").textures(JModel.textures()
                    .particle("minecraft:block/"+textureTranslationKey)
                    .var("texture", "minecraft:block/" + textureTranslationKey)
                ), 
                new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_top")
            );            
            RESOURCE_PACK.addModel(
                JModel.model().parent(SecretRooms.MOD_ID+":block/template_orientable_trapdoor_open").textures(JModel.textures()
                    .particle("minecraft:block/"+textureTranslationKey)
                    .var("texture", "minecraft:block/" + textureTranslationKey)
                ), 
                new Identifier(SecretRooms.MOD_ID, "block/" + camoTrapdoorTranslationKey + "_open")
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
                JModel.model().parent(SecretRooms.MOD_ID + ":block/" + camoTrapdoorTranslationKey + "_bottom"),
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