package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.SpotType;

public class ElectricSpot extends  ParkingSpot{
    public ElectricSpot(String spotId){
        super(spotId, SpotType.ELECTRIC);
    }
}
