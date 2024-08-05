package org.nikhilesh.pancakelab.persistence;

import org.nikhilesh.pancakelab.model.pancakes.Order;

import java.util.HashMap;
import java.util.Map;

// Singleton pattern used for database instance.
public class Database {
    private static Database instance;
    private Map<Integer, Order> orders;
    private static int orderIdCounter = 1;

    private Database() {
        orders = new HashMap<>();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public int createOrder(Order order) {
        int id = orderIdCounter++;
        orders.put(id, order);
        return id;
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public void removeOrder(int id) {
        orders.remove(id);
    }
}
