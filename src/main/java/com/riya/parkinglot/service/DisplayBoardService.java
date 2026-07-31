package com.riya.parkinglot.service;

import com.riya.parkinglot.enums.SpotType;
import com.riya.parkinglot.models.ParkingFloor;
import com.riya.parkinglot.models.ParkingLot;
import com.riya.parkinglot.models.ParkingSpot;

import java.util.EnumMap;
import java.util.Map;

public class DisplayBoardService {
    public void displayAvailableSpots(ParkingLot parkingLot){

        Map<SpotType, Integer> availableSpots = new EnumMap<>(SpotType.class);
        // Initialize all counts to 0
        for (SpotType type : SpotType.values()) {
            availableSpots.put(type, 0);
        }

        for (ParkingFloor floor : parkingLot.getParkingFloors()) {

            for (ParkingSpot spot : floor.getParkingSpots()) {

                if (!spot.isOccupied()) {

                    SpotType type = spot.getSpotType();

                    availableSpots.put(type, availableSpots.get(type) + 1);
                }
            }
        }
        System.out.println("\n========= DISPLAY BOARD =========");

        for (Map.Entry<SpotType, Integer> entry : availableSpots.entrySet()) {

            System.out.printf("%-15s : %d%n",
                    entry.getKey(),
                    entry.getValue());
        }

        System.out.println("=================================");


    }
}
