package com.riya.parkinglot.factory;

import com.riya.parkinglot.enums.VehicleType;
import com.riya.parkinglot.models.Car;
import com.riya.parkinglot.models.MotorCycle;
import com.riya.parkinglot.models.Truck;
import com.riya.parkinglot.models.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleFactoryTest {

    @Test
    public void createVehicleTest(){
        Vehicle vehicle = VehicleFactory.createVehicle(VehicleType.CAR, "RJ14AB1234");
        assertNotNull(vehicle);
        assertTrue(vehicle instanceof Car);
        assertEquals("RJ14AB1234", vehicle.getVehicleNumber());

    }

    @Test
    void shouldCreateMotorcycle() {

        Vehicle vehicle = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE, "RJ14AB1234");

        assertNotNull(vehicle);
        assertTrue(vehicle instanceof MotorCycle);
        assertEquals("RJ14AB1234", vehicle.getVehicleNumber());
    }

    @Test
    void shouldCreateTruck() {

        Vehicle vehicle = VehicleFactory.createVehicle(VehicleType.TRUCK, "RJ14AB1234");

        assertNotNull(vehicle);
        assertTrue(vehicle instanceof Truck);
        assertEquals("RJ14AB1234", vehicle.getVehicleNumber());
    }

}
