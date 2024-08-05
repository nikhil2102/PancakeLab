package org.nikhilesh.pancakelab.model.pancakes;

import org.nikhilesh.pancakelab.service.validation.ThirdPartyService;

import java.util.Objects;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final int building;
    private final int room;
    private boolean isCompleted;

    public Order(int building, int room) {
        // Input data validation for building and room number.
        if (!ThirdPartyService.buildingExists(building) || !ThirdPartyService.roomNumberExists(room)) {
            throw new IllegalArgumentException("Building and room number should be valid.");
        }
        this.id = UUID.randomUUID();
        this.building = building;
        this.room = room;
        this.isCompleted = false;
    }

    public UUID getId() {
        return id;
    }

    public int getBuilding() {
        return building;
    }

    public int getRoom() {
        return room;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
