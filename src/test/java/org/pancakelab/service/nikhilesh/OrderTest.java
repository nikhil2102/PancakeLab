package org.pancakelab.service.nikhilesh;

import org.junit.jupiter.api.Test;
import org.nikhilesh.pancakelab.model.pancakes.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    public void testOrderCreation() {
        Order order = new Order(301, 103);
        assertEquals(301, order.getBuilding());
        assertEquals(103, order.getRoom());
    }
}
