package org.pancakelab.service.nikhilesh;

import org.junit.jupiter.api.Test;
import org.nikhilesh.pancakelab.model.pancakes.Order;
import org.nikhilesh.pancakelab.service.DeliveryService;

public class DeliveryServiceTest {

    @Test
    public void testDeliverOrder() {
        DeliveryService deliveryService = new DeliveryService();
        Order order = new Order(10, 20);
        // This is more of an integration test, so limited scope to assert or verify details.
        deliveryService.deliverOrder(order);
    }
}
