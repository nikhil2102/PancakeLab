package org.nikhilesh.pancakelab.model.pancakes;

import java.util.List;
import java.util.UUID;

public class PancakeRecipeFactoryImpl implements PancakeRecipeFactory{

    @Override
    public Pancake createPanCake(UUID orderId, String name, List<Ingredient> ingredients) {
        return new CustomPanCake(orderId, name, ingredients);
    }
}
