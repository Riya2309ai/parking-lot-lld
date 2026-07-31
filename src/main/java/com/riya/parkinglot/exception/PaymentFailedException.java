package com.riya.parkinglot.exception;

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String message){
        super(message);
    }
}
