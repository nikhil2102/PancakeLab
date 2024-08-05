package org.pancakelab.service.nikhilesh;

import org.junit.jupiter.api.Test;
import org.nikhilesh.pancakelab.service.validation.ThirdPartyService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThirdPartyServiceTest {

    @Test
    public void testWhenBuildingNumberIsInvalid() {
        assertFalse(ThirdPartyService.buildingExists(-1));
    }

    @Test
    public void testWhenBuildingNumberIsValid() {
        assertTrue(ThirdPartyService.buildingExists(10));
    }

    @Test
    public void testWhenRoomNumberIsInvalid() {
        assertFalse(ThirdPartyService.roomNumberExists(0));
    }

    @Test
    public void testWhenRoomNumberIsValid() {
        assertTrue(ThirdPartyService.buildingExists(100));
    }
}
