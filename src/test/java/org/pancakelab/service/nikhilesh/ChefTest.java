package org.pancakelab.service.nikhilesh;

import org.junit.jupiter.api.Test;
import org.nikhilesh.pancakelab.model.pancakes.Order;
import org.nikhilesh.pancakelab.service.Chef;

public class ChefTest {

    @Test
    public void testPrepareOrder() {
        Chef chef = new Chef();
        Order order = new Order(11, 22);
        chef.prepareOrder(order);
    }
}
