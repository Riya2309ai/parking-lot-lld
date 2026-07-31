package com.riya.parkinglot.pricing;

import com.riya.parkinglot.enums.SpotType;
import com.riya.parkinglot.enums.TicketStatus;
import com.riya.parkinglot.enums.VehicleType;
import com.riya.parkinglot.models.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourlyFeeCalculatorTest {

    private final HourlyFeeCalculator hourlyFeeCalculator = new HourlyFeeCalculator();

    @Test
    void shouldChargeOneHourForThirtyMinutes(){

        Vehicle car = new Car("RJ14AB1234");
        ParkingSpot spot = new CompactSpot("S1");
        EntryGate gate = new EntryGate("G1");

        ParkingTicket parkingTicket = new ParkingTicket("T1", car, spot, gate);
        parkingTicket.setExitTime(parkingTicket.getEntryTime().plusMinutes(30));

        double fee= hourlyFeeCalculator.calculateFee(parkingTicket);
        assertEquals(20.0, fee);

    }

    @Test
    void shouldChargeOneHourForExactlyOneHour() {

        Vehicle car = new Car("RJ14AB1234");
        ParkingSpot spot = new CompactSpot("S1");
        EntryGate gate = new EntryGate("G1");

        ParkingTicket parkingTicket =
                new ParkingTicket("T2", car, spot, gate);

        parkingTicket.setExitTime(parkingTicket.getEntryTime().plusHours(1));

        double fee = hourlyFeeCalculator.calculateFee(parkingTicket);

        assertEquals(20.0, fee);
    }

    @Test
    void shouldChargeTwoHoursForNinetyMinutes() {

        Vehicle car = new Car("RJ14AB1234");
        ParkingSpot spot = new CompactSpot("S1");
        EntryGate gate = new EntryGate("G1");

        ParkingTicket parkingTicket =
                new ParkingTicket("T3", car, spot, gate);

        parkingTicket.setExitTime(parkingTicket.getEntryTime().plusMinutes(90));

        double fee = hourlyFeeCalculator.calculateFee(parkingTicket);

        assertEquals(40.0, fee);
    }



}
