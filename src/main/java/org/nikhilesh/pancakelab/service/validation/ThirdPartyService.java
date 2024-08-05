package org.nikhilesh.pancakelab.service.validation;

public class ThirdPartyService {

    public static boolean roomNumberExists(int roomNumber) {
        return roomNumber>0;
    }

    public static boolean buildingExists(int buildingNumber) {
        return buildingNumber>0;
    }
}
