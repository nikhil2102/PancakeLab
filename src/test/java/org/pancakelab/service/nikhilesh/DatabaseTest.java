package org.pancakelab.service.nikhilesh;

import org.junit.jupiter.api.Test;
import org.nikhilesh.pancakelab.model.pancakes.Order;
import org.nikhilesh.pancakelab.persistence.Database;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test
    public void testSingleton() {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        // Asserting that the SINGLETON pattern is getting utilised and only single instance of DB getting exists.
        assertSame(db1, db2);
    }

    @Test
    public void testCreateAndRemoveOrder() {
        Database db = Database.getInstance();
        Order order = new Order(101, 201);
        int orderId = db.createOrder(order);

        // Unit testing add and remove order methods of database.
        assertNotNull(db.getOrder(orderId));
        db.removeOrder(orderId);
        assertNull(db.getOrder(orderId));
    }
}
