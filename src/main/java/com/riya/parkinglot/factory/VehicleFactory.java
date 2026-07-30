package com.riya.parkinglot.factory;

import com.riya.parkinglot.enums.VehicleType;
import com.riya.parkinglot.models.*;

public class VehicleFactory {
    private VehicleFactory() {}
    public static Vehicle createVehicle(VehicleType vehicleType, String vehicleNumber ) {
        return switch(vehicleType){
            case CAR -> new Car(vehicleNumber);
            case TRUCK -> new Truck(vehicleNumber);
            case MOTORCYCLE -> new MotorCycle(vehicleNumber);
            case ELECTRIC -> new ElectricVehicle(vehicleNumber);

        };
    }
}
