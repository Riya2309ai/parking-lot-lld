package com.riya.parkinglot.payments;

public class UpiPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("pay amount: " + amount + "via UPI");
        return true;
    }
}
