package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.SpotType;

public class LargeSpot extends ParkingSpot{
    public LargeSpot(String spotId){
        super(spotId, SpotType.LARGE);
    }
}
