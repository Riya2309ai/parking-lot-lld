package com.riya.parkinglot.service;

import com.riya.parkinglot.models.ParkingFloor;
import com.riya.parkinglot.models.ParkingLot;
import com.riya.parkinglot.models.ParkingSpot;

public class AdminService {
    private final ParkingLot parkingLot;
    public AdminService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public void addParkingFloor(ParkingFloor parkingFloor){
        for(ParkingFloor existingFloor : parkingLot.getParkingFloors()){
            if(existingFloor.getFloorNumber() == parkingFloor.getFloorNumber()){
                throw new  IllegalStateException("Parking Floor : "+ parkingFloor.getFloorNumber() +" already exists");
            }
        }
        parkingLot.getParkingFloors().add(parkingFloor);
        System.out.println("Parking Floor : " + parkingFloor.getFloorNumber() + " Added Successfully");
    }

    public void addParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot){
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            if(floor.getFloorNumber() == parkingFloor.getFloorNumber()){
                for(ParkingSpot existingSpot : floor.getParkingSpots()){
                    if(existingSpot.getSpotId()==parkingSpot.getSpotId()){
                        throw new IllegalStateException("Parking Spot : "+ parkingSpot.getSpotId() +" already exists");
                    }
                }
                floor.getParkingSpots().add(parkingSpot);
                System.out.println("Spot : "+ parkingSpot.getSpotId() + " added to Floor " + parkingFloor.getFloorNumber());
                return;
            }
        }
        throw new IllegalStateException("Parking Floor : "+ parkingFloor.getFloorNumber() +" does not exist");
    }

    public void removeParkingSpot(int floorNumber, String spotId){

        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            if(floor.getFloorNumber() == floorNumber){
                ParkingSpot spotToRemove =null;
                for(ParkingSpot spot : floor.getParkingSpots()){
                    if(spot.getSpotId().equals(spotId)){
                        if(spot.isOccupied()){
                            throw new IllegalStateException("Cannot remove an occupied parking spot");
                        }
                        spotToRemove = spot;
                        break;
                    }
                }

                if(spotToRemove == null){
                    throw new IllegalStateException("Parking spot not found");
                }
                floor.getParkingSpots().remove(spotToRemove);
                System.out.println("Spot : "+ spotId + " removed from Floor " + floor.getFloorNumber());
            }

        }
        throw new IllegalStateException("Floow not found");
    }

    public void displayParkingLotStatus(){
        System.out.println("\n========== PARKING LOT STATUS ==========");

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){

            System.out.println("\nFloor : " + parkingFloor.getFloorNumber());

            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){

                System.out.printf(
                        "%-5s %-12s %-10s%n",
                        parkingSpot.getSpotId(),
                        parkingSpot.getSpotType(),
                        parkingSpot.isAvailable() ? "Available" : "Occupied"
                );
            }
        }
        System.out.println("\n========================================");
    }
}
