package com.riya.parkinglot.pricing;

import com.riya.parkinglot.models.ParkingTicket;

public class FlatFeeCalculator implements  FeeCalculator {

    public double calculateFee(ParkingTicket ticket) {
        return 100;
    }
}
