package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import org.bedracket.powerdocker.init.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerTools(ModItems.COPPER_AXE, ModItems.COPPER_PICKAXE,
                ModItems.COPPER_HOE, ModItems.COPPER_SHOVEL,
                ModItems.COPPER_SWORD, Items.COPPER_INGOT, exporter);
        offerNugget(Items.COPPER_INGOT, ModItems.COPPER_NUGGET, exporter);
        offerArmors(ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE,
                ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
                Items.COPPER_INGOT, exporter);
        offerSimpleCooking(exporter, ModItems.TROUT, ModItems.COOKED_TROUT);
        offerJavelin(ModItems.STONE_JAVELIN, Items.COBBLESTONE, exporter);
        offerJavelin(ModItems.COPPER_JAVELIN, Items.COPPER_INGOT, exporter);
    }

    private static void offerSimpleCooking(Consumer<RecipeJsonProvider> exporter, Item input, Item output) {
        CookingRecipeJsonBuilder recipeJsonBuilder = CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), RecipeCategory.FOOD, output, 0.35F, 200, RecipeSerializer.SMELTING).criterion(hasItem(input), conditionsFromItem(input));
        String named = getItemPath(output);
        recipeJsonBuilder.offerTo(exporter, named);
    }

    private static void offerJavelin(Item result, Item material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.COMBAT, result)
                .input('X', material)
                .input('#', Items.STICK)
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" # ")
                .criterion("has_" + material,
                        conditionsFromItem(material))
                .offerTo(exporter);
    }

    private static void offerNugget(Item ingotItem, Item nuggetItem, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.MISC, nuggetItem, 9)
                .input(ingotItem)
                .criterion("has_" + ingotItem,
                        conditionsFromItem(ingotItem))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.MISC, ingotItem)
                .input(nuggetItem, 9)
                .criterion("has_" + nuggetItem,
                        conditionsFromItem(nuggetItem))
                .offerTo(exporter);
    }

    private static void offerArmors(Item helmet, Item chestplate, Item leggings, Item boots, Item material, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.COMBAT, helmet)
                .input('X', material)
                .pattern("XXX")
                .pattern("X X")
                .criterion("has_" + material,
                        conditionsFromItem(material))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.COMBAT, chestplate)
                .input('X', material)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .criterion("has_" + material,
                        conditionsFromItem(material))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.COMBAT, leggings)
                .input('X', material)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .criterion("has_" + material,
                        conditionsFromItem(material))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.COMBAT, boots)
                .input('X', material)
                .pattern("X X")
                .pattern("X X")
                .criterion("has_" + material,
                        conditionsFromItem(material))
                .offerTo(exporter);
    }

    private static void offerTools(Item axeItem, Item pickaxeItem, Item hoeItem, Item shovelItem, Item swordItem, Item materialItem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.TOOLS, axeItem)
                .input('#', Items.STICK)
                .input('X', materialItem)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion("has_" + materialItem,
                        conditionsFromItem(materialItem))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.TOOLS, pickaxeItem)
                .input('#', Items.STICK)
                .input('X', materialItem)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion("has_" + materialItem,
                        conditionsFromItem(materialItem))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.TOOLS, hoeItem)
                .input('#', Items.STICK)
                .input('X', materialItem)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion("has_" + materialItem,
                        conditionsFromItem(materialItem))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.TOOLS, shovelItem)
                .input('#', Items.STICK)
                .input('X', materialItem)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion("has_" + materialItem,
                        conditionsFromItem(materialItem))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.COMBAT, swordItem)
                .input('#', Items.STICK)
                .input('X', materialItem)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion("has_" + materialItem,
                        conditionsFromItem(materialItem))
                .offerTo(exporter);
    }

}
