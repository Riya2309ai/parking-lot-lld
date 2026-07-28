# Parking Lot Management System - UML Class Diagram

        ```mermaid
        classDiagram

        class ParkingLot{
        -String name
        -String address
        +parkVehicle()
        +exitVehicle()
        }

        class ParkingFloor{
        -int floorNumber
        }

        class ParkingSpot{
<<Abstract>>
-String spotId
-boolean occupied
+parkVehicle()
+removeVehicle()
}

class Vehicle{
<<Abstract>>
    -String vehicleNumber
    }

    class Car
    class Truck
    class Motorcycle
    class ElectricVehicle

    ParkingLot "1" *-- "*" ParkingFloor
    ParkingFloor "1" *-- "*" ParkingSpot

    Vehicle <|-- Car
    Vehicle <|-- Truck
    Vehicle <|-- Motorcycle
    Vehicle <|-- ElectricVehicle
    ```