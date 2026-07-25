package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.VehicleType;

public class Car extends  Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
