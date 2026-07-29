package com.riya.parkinglot.models;

import lombok.Getter;

@Getter
public class ExitGate {
    private final String gateId;
    public ExitGate(String gateId){
        this.gateId = gateId;
    }
}
