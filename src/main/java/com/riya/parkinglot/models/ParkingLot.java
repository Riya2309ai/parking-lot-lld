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





}
