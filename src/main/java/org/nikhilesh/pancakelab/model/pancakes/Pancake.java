package org.nikhilesh.pancakelab.model.pancakes;

import java.util.List;
import java.util.UUID;

public class Pancake {

    protected UUID orderId;
    protected String name;
    protected List<Ingredient> ingredients;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

}
