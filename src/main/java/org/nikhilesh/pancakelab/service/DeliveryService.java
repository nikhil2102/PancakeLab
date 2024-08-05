package org.nikhilesh.pancakelab.service;

import org.nikhilesh.pancakelab.model.exception.OrderIncompleteException;
import org.nikhilesh.pancakelab.model.pancakes.Order;

public class DeliveryService {
    public void deliverOrder(Order order) throws OrderIncompleteException {
        // Simulate order delivery
        if (!order.isCompleted()) {
            throw new OrderIncompleteException("Please provide only completed orders.");
        }
        System.out.println("Delivering order to room " + order.getRoom() + " in building " + order.getBuilding());
    }
}
