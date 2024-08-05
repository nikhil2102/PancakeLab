package org.nikhilesh.pancakelab.model.pancakes;

import java.util.List;
import java.util.UUID;

public interface PancakeRecipeFactory {

    Pancake createPanCake(UUID orderId, String name, List<Ingredient> ingredients);
}
