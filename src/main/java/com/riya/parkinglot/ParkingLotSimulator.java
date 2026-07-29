package com.riya.parkinglot;

import com.riya.parkinglot.models.*;

public class ParkingLotSimulator {
    public static void run() {
        ParkingSpot spot1 = new CompactSpot("S1");
        ParkingSpot spot2 = new LargeSpot("S2");
        ParkingSpot spot3 = new MotorcycleSpot("S3");
        ParkingSpot spot4 = new ElectricSpot("S4");
    }

}
