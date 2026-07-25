package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.VehicleType;

public class Truck extends  Vehicle {
    public Truck(String vehicleNumber) {
        super(vehicleNumber, VehicleType.TRUCK);
    }
}
