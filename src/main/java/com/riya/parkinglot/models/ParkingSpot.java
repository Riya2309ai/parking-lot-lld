package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.SpotType;
import com.riya.parkinglot.enums.VehicleType;

public abstract class ParkingSpot {
    private String spotId;
    private SpotType spotType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType spotType){
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
    }
    public synchronized void assignVehicle(Vehicle vehicle){
        this.parkedVehicle=vehicle;
        this.isOccupied=true;
    }
    public synchronized void removeVehicle(Vehicle vehicle){
        this.parkedVehicle=null;
        this.isOccupied=false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void setOccupied(boolean b) {
        isOccupied=b;
    }


    public boolean canFitVehicle(Vehicle vehicle) {

        return switch (spotType) {

            case MOTORCYCLE ->
                    vehicle.getVehicleType() == VehicleType.MOTORCYCLE;

            case COMPACT ->
                    vehicle.getVehicleType() == VehicleType.CAR;

            case LARGE ->
                    vehicle.getVehicleType() == VehicleType.TRUCK;

            case ELECTRIC ->
                    vehicle.getVehicleType() == VehicleType.ELECTRIC;
        };
    }
}
