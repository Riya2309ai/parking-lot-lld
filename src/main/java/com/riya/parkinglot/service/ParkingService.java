package com.riya.parkinglot.service;

import com.riya.parkinglot.enums.TicketStatus;
import com.riya.parkinglot.exception.ParkingLotFullException;
import com.riya.parkinglot.exception.PaymentFailedException;
import com.riya.parkinglot.models.*;
import com.riya.parkinglot.strategies.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ParkingService {
    private final ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    private ParkingSpot findAvailableSpot(Vehicle vehicle) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for(ParkingFloor floor : parkingFloors){

            ParkingSpot spot = parkingLot.getParkingStrategy().findSpot(floor.getParkingSpots());

            if(spot != null && spot.canFitVehicle(vehicle)){
                return spot;
            }
        }
        return null;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle, EntryGate entryGate){
        ParkingSpot parkingSpot = findAvailableSpot(vehicle);

        if(parkingSpot == null){
            throw new ParkingLotFullException("Parking Lot is full and no Spot is available right now");
        }
        parkingSpot.assignVehicle(vehicle);
        String ticketId = UUID.randomUUID().toString();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, parkingSpot,  entryGate);

        parkingLot.getActiveTickets().put(ticketId, ticket);
        return ticket;

    }

    public double unparkVehicle(ParkingTicket ticket, ExitGate exitGate){
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        ticket.setExitTime(LocalDateTime.now());
        ticket.setExitGate(exitGate);
        double fee=parkingLot.getFeeCalculator().calculateFee(ticket);
        boolean paymentSuccessful= parkingLot.getPaymentStrategy().pay(fee);

        if(!paymentSuccessful){
            throw new PaymentFailedException("Payment failed for vehicle : " + ticket.getVehicle().getVehicleNumber());
        }
        parkingSpot.removeVehicle();
        ticket.setTicketStatus(TicketStatus.PAID);
        parkingLot.getActiveTickets().remove(ticket.getTicketId());

        return fee;

    }


}
