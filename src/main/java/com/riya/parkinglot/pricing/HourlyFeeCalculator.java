package com.riya.parkinglot.pricing;

import com.riya.parkinglot.models.ParkingTicket;

import java.time.Duration;

public class HourlyFeeCalculator implements FeeCalculator {

    private static final double HOURLY_RATE=20.0;

    public double calculateFee(ParkingTicket ticket){

        Duration duration = Duration.between(
                ticket.getEntryTime(),
                ticket.getExitTime()
        );

        long hours = duration.toHours();

        if(duration.toMinutes()%60==0){
            hours+=1;
        }
        return hours * HOURLY_RATE ;

    }
}
