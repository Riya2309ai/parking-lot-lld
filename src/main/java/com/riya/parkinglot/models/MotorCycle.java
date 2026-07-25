package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.VehicleType;

public class MotorCycle extends Vehicle{
    public MotorCycle(String vehicleNumber) {
        super(vehicleNumber, VehicleType.MOTORCYCLE);
    }
}
