package com.riya.parkinglot.strategies;

import com.riya.parkinglot.models.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> parkingSpots);
}
