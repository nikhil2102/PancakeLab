package org.pancakelab.service.nikhilesh;

import org.junit.jupiter.api.Test;
import org.nikhilesh.pancakelab.model.pancakes.*;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PancakeRecipeFactoryImplTest {

    private PancakeRecipeFactory factory = new PancakeRecipeFactoryImpl();

    @Test
    public void testCreateDarkChocolatePancake() {
        Pancake pancake = factory.createPanCake(UUID.randomUUID(), "Dark Chocolate Pancake",
                List.of(Ingredient.DARK_CHOCOLATE));
        assertTrue(pancake instanceof CustomPanCake);
        assertTrue(pancake.getIngredients().contains(Ingredient.DARK_CHOCOLATE));
    }

    @Test
    public void testCreateMilkChocolatePancake() {
        Pancake pancake = factory.createPanCake(UUID.randomUUID(), "Milk Chocolate Pancake",
                List.of(Ingredient.MILK_CHOCOLATE));
        assertTrue(pancake instanceof CustomPanCake);
        assertTrue(pancake.getIngredients().contains(Ingredient.MILK_CHOCOLATE));
    }

    @Test
    public void testCreateWhippedCreamHazelnutsPancake() {
        Pancake pancake = factory.createPanCake(UUID.randomUUID(), "Whipped Cream Hazelnuts Pancake",
                List.of(Ingredient.WHIPPED_CREAM, Ingredient.HAZELNUTS));
        assertTrue(pancake instanceof CustomPanCake);
        assertTrue(pancake.getIngredients().contains(Ingredient.WHIPPED_CREAM));
        assertTrue(pancake.getIngredients().contains(Ingredient.HAZELNUTS));
    }

    @Test
    public void testCreateDarkChocolateWhippedCreamHazelnutsPancake() {
        Pancake pancake = factory.createPanCake(UUID.randomUUID(), "Whipped Cream Hazelnuts Pancake",
                List.of(Ingredient.DARK_CHOCOLATE, Ingredient.WHIPPED_CREAM, Ingredient.HAZELNUTS));
        assertTrue(pancake instanceof CustomPanCake);
        assertTrue(pancake.getIngredients().contains(Ingredient.DARK_CHOCOLATE));
        assertTrue(pancake.getIngredients().contains(Ingredient.WHIPPED_CREAM));
        assertTrue(pancake.getIngredients().contains(Ingredient.HAZELNUTS));
    }
}
