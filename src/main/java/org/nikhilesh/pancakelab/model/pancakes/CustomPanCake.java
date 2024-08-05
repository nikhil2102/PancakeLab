package org.nikhilesh.pancakelab.model.pancakes;

import java.util.List;
import java.util.UUID;

public class CustomPanCake extends Pancake{

    public CustomPanCake(UUID orderId, String name, List<Ingredient> ingredients) {
        this.orderId = orderId;
        this.name = name;
        this.ingredients = ingredients;
    }
}
