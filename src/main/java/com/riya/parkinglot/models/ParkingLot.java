package com.riya.parkinglot.models;

import com.riya.parkinglot.strategies.ParkingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingStrategy parkingStrategy;
}
