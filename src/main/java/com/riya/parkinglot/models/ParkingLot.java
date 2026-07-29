package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.TicketStatus;
import com.riya.parkinglot.payments.PaymentStrategy;
import com.riya.parkinglot.pricing.FeeCalculator;
import com.riya.parkinglot.strategies.ParkingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingStrategy parkingStrategy;
    private Map<String, ParkingTicket> activeTickets;
    private FeeCalculator feeCalculator;
    private PaymentStrategy paymentStrategy;

    public ParkingLot(String name, String address, List<ParkingFloor> parkingFloors, ParkingStrategy parkingStrategy, FeeCalculator feeCalculator,  PaymentStrategy paymentStrategy) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.parkingStrategy = parkingStrategy;
        this.activeTickets = new HashMap<>();
        this.feeCalculator = feeCalculator;
        this.paymentStrategy = paymentStrategy;
    }
    public ParkingTicket parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = findAvailableSpot(vehicle);

        if(parkingSpot == null){
            throw new RuntimeException("Parking Lot is full");
        }
        parkingSpot.setOccupied(true);

        String ticketId = UUID.randomUUID().toString();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, parkingSpot);

        activeTickets.put(ticketId, ticket);
        return ticket;

    }

    public double unparkVehicle(ParkingTicket ticket){
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        ticket.setExitTime(LocalDateTime.now());
        double fee=feeCalculator.calculateFee(ticket);
        boolean paymentSuccessful= paymentStrategy.pay(fee);
        if(!paymentSuccessful){
            throw new RuntimeException("Payment failed");
        }
        parkingSpot.setOccupied(false);
        ticket.setTicketStatus(TicketStatus.PAID);
        activeTickets.remove(ticket.getTicketId());

        return fee;

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
