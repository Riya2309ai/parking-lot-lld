package com.riya.parkinglot.models;

import com.riya.parkinglot.enums.VehicleType;
import lombok.Getter;

@Getter
public class EntryGate {

    private String gateId;

    public EntryGate(String gateId){
        this.gateId = gateId;
    }
}
