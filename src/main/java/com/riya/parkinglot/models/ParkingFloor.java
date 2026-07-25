package com.riya.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ParkingFloor {
    private int floorNumber;
    List<ParkingSpot> parkingSpots;
}
