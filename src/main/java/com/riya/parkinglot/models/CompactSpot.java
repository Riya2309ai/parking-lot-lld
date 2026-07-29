package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.SpotType;

public class CompactSpot extends ParkingSpot{

    public CompactSpot(String spotId){
        super(spotId, SpotType.COMPACT);
    }
}
