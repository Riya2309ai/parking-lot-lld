package com.riya.parkinglot.payments;

public interface PaymentStrategy {
    public boolean pay(double amount);
}
