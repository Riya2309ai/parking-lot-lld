package com.riya.parkinglot.strategies;

import com.riya.parkinglot.models.ParkingSpot;

import java.util.List;

public class NearestParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isAvailable()){
                return spot;
            }
        }
        return null;
    }
}
