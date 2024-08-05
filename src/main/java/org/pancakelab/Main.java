package org.pancakelab;

import org.nikhilesh.pancakelab.model.pancakes.*;
import org.nikhilesh.pancakelab.persistence.Database;
import org.nikhilesh.pancakelab.service.Chef;
import org.nikhilesh.pancakelab.service.DeliveryService;
import org.nikhilesh.pancakelab.service.PancakeService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PancakeRecipeFactory pancakeFactory = new PancakeRecipeFactoryImpl();

        // Creating different flavors of Pancakes.
        Order darkChocolateOrder = new Order(12, 21);
        pancakeFactory.createPanCake(darkChocolateOrder.getId(),
                "Dark Chocolate Pancake", List.of(Ingredient.DARK_CHOCOLATE));

        Order milkChocolateOrder = new Order(13, 31);
        pancakeFactory.createPanCake(milkChocolateOrder.getId(),
                "Milk Chocolate Pancake", List.of(Ingredient.MILK_CHOCOLATE));

        Order darkChocolateWhippedCreamOrder = new Order(14, 41);
        pancakeFactory.createPanCake(darkChocolateWhippedCreamOrder.getId(),
                "Dark Chocolate Whipped Cream Pancake", List.of(Ingredient.DARK_CHOCOLATE, Ingredient.WHIPPED_CREAM));

        Order darkChocolateWhippedCreamHazelnutsOrder = new Order(15, 51);
        pancakeFactory.createPanCake
                (darkChocolateWhippedCreamHazelnutsOrder.getId(), "Dark Chocolate Whipped Cream Hazelnuts Pancake",
                        List.of(Ingredient.DARK_CHOCOLATE, Ingredient.WHIPPED_CREAM, Ingredient.HAZELNUTS));


        // Create database instance
        Database database = Database.getInstance();

        // Create and manage an order
        orderManagementCycle(darkChocolateOrder, database);
        orderManagementCycle(milkChocolateOrder, database);
        orderManagementCycle(darkChocolateWhippedCreamOrder, database);
        orderManagementCycle(darkChocolateWhippedCreamHazelnutsOrder, database);
    }

    private static void orderManagementCycle(Order flavoredOrder, Database database) {
        int darkChocolateOrderIdDb = database.createOrder(flavoredOrder);
        System.out.println("Created Order: " + database.getOrder(darkChocolateOrderIdDb));

        // Chef prepares the order
        Chef chef = new Chef();
        chef.prepareOrder(flavoredOrder);

        // Mark order as completed
        flavoredOrder.setCompleted(true);

        // Delivery service delivers the order
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.deliverOrder(flavoredOrder);

        // Remove order from database
        database.removeOrder(darkChocolateOrderIdDb);

        System.out.println("Order removed from database with Id : "+ darkChocolateOrderIdDb);
    }
}