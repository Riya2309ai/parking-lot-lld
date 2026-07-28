package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.TicketStatus;
import com.riya.parkinglot.strategies.ParkingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingStrategy parkingStrategy;

    public ParkingTicket parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = findAvailableSpot(vehicle);

        if(parkingSpot == null){
            throw new RuntimeException("Parking Lot is full");
        }
        parkingSpot.setOccupied(true);

        String ticketId = UUID.randomUUID().toString();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, parkingSpot);

        return ticket;

    }

    private ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for(ParkingFloor floor : parkingFloors){

            ParkingSpot spot = parkingStrategy.findSpot(floor.getParkingSpots());

            if(spot != null && spot.canFitVehicle(vehicle)){
                return spot;
            }
        }
        return null;
    }
}
