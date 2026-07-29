package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.SpotType;

public class MotorcycleSpot extends ParkingSpot{
    public MotorcycleSpot(String spotId){
        super(spotId, SpotType.MOTORCYCLE);
    }
}
