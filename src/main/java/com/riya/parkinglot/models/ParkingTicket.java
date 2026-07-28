package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkingTicket {
    private String ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private TicketStatus ticketStatus;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.parkingSpot =parkingSpot;
        this.ticketStatus=TicketStatus.ACTIVE;
    }


}
