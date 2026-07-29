package com.riya.parkinglot.payments;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("pay amount: " + amount + "via cash");
        return true;
    }
}
