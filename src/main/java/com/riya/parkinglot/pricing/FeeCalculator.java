package com.riya.parkinglot.pricing;

import com.riya.parkinglot.models.ParkingTicket;

public interface FeeCalculator {
    double calculateFee(ParkingTicket ticket);
}
