classDiagram
        direction TB

        %% Core parking structure
        class ParkingLot {
        -String name
        -String address
        -List~ParkingFloor~ parkingFloors
        +parkVehicle()
        +exitVehicle()
        }

        class ParkingFloor {
        -int floorNumber
        -List~ParkingSpot~ parkingSpots
        }

        class ParkingSpot {
<<abstract>>
-String spotId
-boolean occupied
-Vehicle parkedVehicle
+parkVehicle()
+removeVehicle()
}

%% Parking spot types
class CompactSpot
class LargeSpot
class MotorcycleSpot
class ElectricSpot

%% Vehicle hierarchy
class Vehicle {
<<abstract>>
    -String vehicleNumber
    -VehicleType vehicleType
    }

    class Car
    class Truck
    class Motorcycle
    class ElectricVehicle

    %% Ticketing and payment
    class ParkingTicket {
    -String ticketId
    -LocalDateTime entryTime
    -LocalDateTime exitTime
    }

    class Payment {
    -double amount
    -PaymentMode paymentMode
    }

    %% Gates and display
    class EntryGate
    class ExitGate
    class DisplayBoard

    %% Strategies
    class ParkingStrategy {
    <<interface>>
        +getAvailableSpot()
        }

        class PricingStrategy {
        <<interface>>
            +calculateFee()
            }

            %% Composition
            ParkingLot "1" *-- "*" ParkingFloor : contains
            ParkingFloor "1" *-- "*" ParkingSpot : contains

            %% Vehicle and spot associations
            ParkingSpot "0..1" --> "0..1" Vehicle : parks
            ParkingTicket "1" --> "1" Vehicle : records
            ParkingTicket "1" --> "1" ParkingSpot : reserves

            %% Gate operations
            EntryGate "1" --> "*" ParkingTicket : issues
            ExitGate "1" --> "*" ParkingTicket : closes
            ExitGate "1" --> "*" Payment : processes

            %% Vehicle inheritance
            Vehicle <|-- Car
            Vehicle <|-- Truck
            Vehicle <|-- Motorcycle
            Vehicle <|-- ElectricVehicle

            %% Spot inheritance
            ParkingSpot <|-- CompactSpot
            ParkingSpot <|-- LargeSpot
            ParkingSpot <|-- MotorcycleSpot
            ParkingSpot <|-- ElectricSpot

            %% Strategy dependencies
            ParkingLot ..> ParkingStrategy : uses
            ExitGate ..> PricingStrategy : uses
            DisplayBoard --> ParkingFloor : displays