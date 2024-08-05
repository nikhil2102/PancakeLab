package org.pancakelab.service.nikhilesh;

import org.junit.jupiter.api.Test;
import org.nikhilesh.pancakelab.model.exception.OrderIncompleteException;
import org.nikhilesh.pancakelab.model.pancakes.Order;
import org.nikhilesh.pancakelab.service.DeliveryService;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryServiceTest {

    @Test
    public void testDeliverOrder() throws OrderIncompleteException {
        DeliveryService deliveryService = new DeliveryService();
        Order order = new Order(10, 20);
        order.setCompleted(true);
        // This is more of an integration test, so limited scope to assert or verify details.
        deliveryService.deliverOrder(order);
    }

    @Test
    public void testDeliverOrderFailsForIncompleteOrder() {
        DeliveryService deliveryService = new DeliveryService();
        Order order = new Order(10, 20);

        Exception exception = assertThrows(OrderIncompleteException.class, () -> {
            deliveryService.deliverOrder(order);
        });

        assertEquals("Please provide only completed orders.", exception.getMessage());

    }
}
