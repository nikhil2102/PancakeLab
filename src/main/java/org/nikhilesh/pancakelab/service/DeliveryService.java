package org.nikhilesh.pancakelab.service;

import org.nikhilesh.pancakelab.model.pancakes.Order;

public class DeliveryService {
    public void deliverOrder(Order order) {
        // Simulate order delivery
        System.out.println("Delivering order to room " + order.getRoom() + " in building " + order.getBuilding());
    }
}
