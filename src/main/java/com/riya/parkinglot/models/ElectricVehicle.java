package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.VehicleType;

public class ElectricVehicle extends  Vehicle {
    public ElectricVehicle(String vehicleNumber) {
        super(vehicleNumber, VehicleType.ELECTRIC);
    }

}
