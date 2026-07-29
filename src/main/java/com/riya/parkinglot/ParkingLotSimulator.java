package com.riya.parkinglot;

import com.riya.parkinglot.models.*;
import com.riya.parkinglot.payments.PaymentStrategy;
import com.riya.parkinglot.payments.UpiPayment;
import com.riya.parkinglot.pricing.FeeCalculator;
import com.riya.parkinglot.pricing.HourlyFeeCalculator;
import com.riya.parkinglot.service.ParkingService;
import com.riya.parkinglot.strategies.NearestParkingStrategy;
import com.riya.parkinglot.strategies.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSimulator {
    public static void run(){

        List<ParkingSpot> spots = new ArrayList<>();

        spots.add(new CompactSpot("C1"));
        spots.add(new CompactSpot("C2"));
        spots.add(new LargeSpot("L1"));
        spots.add(new MotorcycleSpot("M1"));
        spots.add(new ElectricSpot("E1"));

        ParkingFloor floor1 =
                new ParkingFloor(1,spots);

        ParkingStrategy parkingStrategy = new NearestParkingStrategy();

        FeeCalculator feeCalculator = new HourlyFeeCalculator();

        PaymentStrategy paymentStrategy = new UpiPayment();

        ParkingLot parkingLot =
                new ParkingLot(
                        "City Mall Parking",
                        "Jaipur",
                        List.of(floor1),
                        parkingStrategy,
                        feeCalculator,
                        paymentStrategy
                );

        ParkingService parkingService =
                new ParkingService(parkingLot);

        Vehicle car = new Car("RJ14AB1234");

        EntryGate entryGate = new EntryGate("E1");
        ExitGate exitGate = new ExitGate("X1");

        ParkingTicket ticket = parkingService.parkVehicle(car,  entryGate);

        System.out.println("========== VEHICLE PARKED ==========");
        System.out.println("Ticket ID : " + ticket.getTicketId());
        System.out.println("Vehicle Number : " + ticket.getVehicle().getVehicleNumber());
        System.out.println("Entry Gate     : " + ticket.getEntryGate().getGateId());
        System.out.println("Spot : " + ticket.getParkingSpot().getSpotId());
        System.out.println("Entry Time : " + ticket.getEntryTime());

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }

        double fee = parkingService.unparkVehicle(ticket, exitGate);

        System.out.println("\n========== VEHICLE UNPARKED ==========");
        System.out.println("Exit Gate      : " + ticket.getExitGate().getGateId());
        System.out.println("Exit Time : " + ticket.getExitTime());
        System.out.println("Fee Paid : ₹" + fee);
    }

}
