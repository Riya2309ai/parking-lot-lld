package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.SpotType;

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

}
