package org.nikhilesh.pancakelab.service;

import org.nikhilesh.pancakelab.model.pancakes.Order;
import org.nikhilesh.pancakelab.model.pancakes.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PancakeService {
    private List<Order> orders = new ArrayList<>();
    private Set<UUID> completedOrders = new HashSet<>();
    private Set<UUID> preparedOrders = new HashSet<>();
    private List<Pancake> pancakes = new ArrayList<>();

    public Order createOrder(int building, int room) {
        Order order = new Order(building, room);
        orders.add(order);
        return order;
    }

    public void addDarkChocolatePancake(UUID orderId, int count) {
        for (int i = 0; i < count; ++i) {
            addPancake(new CustomPanCake(orderId, "Dark Chocolate Pancake", List.of(Ingredient.DARK_CHOCOLATE)),
                    orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().get());
        }
    }

    public void addDarkChocolateWhippedCreamPancake(UUID orderId, int count) {
        for (int i = 0; i < count; ++i) {
            addPancake(new CustomPanCake(orderId, "Dark Chocolate Whipped Cream Pancake",
                            List.of(Ingredient.DARK_CHOCOLATE, Ingredient.WHIPPED_CREAM)),
                    orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().get());
        }
    }

    public void addDarkChocolateWhippedCreamHazelnutsPancake(UUID orderId, int count) {
        for (int i = 0; i < count; ++i) {
            addPancake(new CustomPanCake(orderId, "Dark Chocolate Whipped Cream  Hazelnuts Pancake",
                            List.of(Ingredient.DARK_CHOCOLATE, Ingredient.WHIPPED_CREAM, Ingredient.HAZELNUTS)),
                    orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().get());
        }
    }

    public void addMilkChocolatePancake(UUID orderId, int count) {
        for (int i = 0; i < count; ++i) {
            addPancake(new CustomPanCake(orderId, "Milk Chocolate Pancake", List.of(Ingredient.MILK_CHOCOLATE)),
                    orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().get());
        }
    }

    public void addMilkChocolateHazelnutsPancake(UUID orderId, int count) {
        for (int i = 0; i < count; ++i) {
            addPancake(new CustomPanCake(orderId, "Milk Chocolate Hazelnuts Pancake",
                            List.of(Ingredient.MILK_CHOCOLATE, Ingredient.HAZELNUTS)), orders.stream().
                    filter(o -> o.getId().equals(orderId)).findFirst().get());
        }
    }

    public List<String> viewOrder(UUID orderId) {
        return pancakes.stream()
                .filter(pancake -> pancake.getOrderId().equals(orderId))
                .map(Pancake::getName).toList();
    }

    private void addPancake(Pancake pancake, Order order) {
        pancake.setOrderId(order.getId());
        pancakes.add(pancake);

//        OrderLog.logAddPancake(order, pancake.description(), pancakes);
    }

    public void removePancakes(String name, UUID orderId, int count) {
        final AtomicInteger removedCount = new AtomicInteger(0);
        pancakes.removeIf(pancake -> {
            return pancake.getOrderId().equals(orderId) &&
                    pancake.getName().equals(name) &&
                    removedCount.getAndIncrement() < count;
        });

        Order order = orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().get();
//        OrderLog.logRemovePancakes(order, name, removedCount.get(), pancakes);
    }

    public void cancelOrder(UUID orderId) {
        Order order = orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().get();
//        OrderLog.logCancelOrder(order, this.pancakes);

        pancakes.removeIf(pancake -> pancake.getOrderId().equals(orderId));
        orders.removeIf(o -> o.getId().equals(orderId));
        completedOrders.removeIf(u -> u.equals(orderId));
        preparedOrders.removeIf(u -> u.equals(orderId));

//        OrderLog.logCancelOrder(order, pancakes);
    }

    public void completeOrder(UUID orderId) {
        completedOrders.add(orderId);
        orders.stream().filter(order -> orderId.equals(order.getId())).findFirst().get().setCompleted(true);
    }

    public Set<UUID> listCompletedOrders() {
        return completedOrders;
    }

    public void prepareOrder(UUID orderId) {
        preparedOrders.add(orderId);
        completedOrders.removeIf(u -> u.equals(orderId));
    }

    public Set<UUID> listPreparedOrders() {
        return preparedOrders;
    }

    public Object[] deliverOrder(UUID orderId) {
        if (!preparedOrders.contains(orderId)) return null;

        Order order = orders.stream().filter(o -> o.getId().equals(orderId)).findFirst().get();
        List<String> pancakesToDeliver = viewOrder(orderId);
//        OrderLog.logDeliverOrder(order, this.pancakes);

        pancakes.removeIf(pancake -> pancake.getOrderId().equals(orderId));
        orders.removeIf(o -> o.getId().equals(orderId));
        preparedOrders.removeIf(u -> u.equals(orderId));

        return new Object[]{order, pancakesToDeliver};
    }
}
