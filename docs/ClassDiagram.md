classDiagram

        class ParkingLot {
        - String name
        - String address
        - List~ParkingFloor~ parkingFloors
        + parkVehicle()
        + exitVehicle()
        }

        class ParkingFloor {
        - int floorNumber
        - List~ParkingSpot~ parkingSpots
        }

        class ParkingSpot {
<<abstract>>
- String spotId
- boolean occupied
- Vehicle parkedVehicle
+ parkVehicle()
+ removeVehicle()
}

class CompactSpot
class LargeSpot
class MotorcycleSpot
class ElectricSpot

class Vehicle {
<<abstract>>
    - String vehicleNumber
    - VehicleType vehicleType
    }

    class Car
    class Truck
    class Motorcycle
    class ElectricVehicle

    class ParkingTicket {
    - String ticketId
    - LocalDateTime entryTime
    - LocalDateTime exitTime
    }

    class EntryGate

    class ExitGate

    class Payment {
    - double amount
    - PaymentMode paymentMode
    }

    class DisplayBoard

    class ParkingStrategy {
    <<interface>>
        + getAvailableSpot()
        }

        class PricingStrategy {
        <<interface>>
            + calculateFee()
            }

            ParkingLot "1" *-- "*" ParkingFloor
            ParkingFloor "1" *-- "*" ParkingSpot

            ParkingSpot --> Vehicle
            ParkingTicket --> Vehicle
            ParkingTicket --> ParkingSpot

            EntryGate --> ParkingTicket
            ExitGate --> ParkingTicket
            ExitGate --> Payment

            Vehicle <|-- Car
            Vehicle <|-- Truck
            Vehicle <|-- Motorcycle
            Vehicle <|-- ElectricVehicle

            ParkingSpot <|-- CompactSpot
            ParkingSpot <|-- LargeSpot
            ParkingSpot <|-- MotorcycleSpot
            ParkingSpot <|-- ElectricSpot

            ParkingLot --> ParkingStrategy
            ExitGate --> PricingStrategy

            DisplayBoard --> ParkingFloor