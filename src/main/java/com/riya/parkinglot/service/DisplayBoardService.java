package com.riya.parkinglot.service;

import com.riya.parkinglot.models.ParkingFloor;
import com.riya.parkinglot.models.ParkingLot;
import com.riya.parkinglot.models.ParkingSpot;

public class DisplayBoardService {
    public void displayAvailableSpots(ParkingLot parkingLot){

        int compact = 0;
        int large = 0;
        int motorcycle = 0;
        int electric = 0;

        for (ParkingFloor floor : parkingLot.getParkingFloors()) {

            for (ParkingSpot spot : floor.getParkingSpots()) {

                if (!spot.isOccupied()) {

                    switch (spot.getSpotType()) {

                        case COMPACT -> compact++;

                        case LARGE -> large++;

                        case MOTORCYCLE -> motorcycle++;

                        case ELECTRIC -> electric++;
                    }
                }
            }
        }
        System.out.println("\n========= DISPLAY BOARD =========");

        System.out.println("Compact Spots     : " + compact);

        System.out.println("Large Spots       : " + large);

        System.out.println("Motorcycle Spots  : " + motorcycle);

        System.out.println("Electric Spots    : " + electric);

        System.out.println("=================================");


    }
}
