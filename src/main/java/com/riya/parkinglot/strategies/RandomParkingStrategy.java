package com.riya.parkinglot.strategies;

import com.riya.parkinglot.models.ParkingSpot;

import java.util.List;
import java.util.Random;

public class RandomParkingStrategy implements ParkingStrategy{


    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpots) {

        List<ParkingSpot> availableSpots = parkingSpots.stream().filter(ParkingSpot::isAvailable).toList();

        if(availableSpots.isEmpty()) return null;

        return availableSpots.get(new Random().nextInt(0, availableSpots.size()));

    }
}
