package com.riya.parkinglot.payments;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("pay amount: " + amount + " via card");
        return true;
    }
}
