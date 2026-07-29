package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class ParkingTicket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final EntryGate entryGate;

    @Setter
    private ExitGate exitGate;

    @Setter
    private LocalDateTime exitTime;

    @Setter
    private TicketStatus ticketStatus;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, EntryGate entryGate) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot =parkingSpot;
        this.entryGate = entryGate;

        this.entryTime = LocalDateTime.now();
        this.ticketStatus=TicketStatus.ACTIVE;
    }


}
