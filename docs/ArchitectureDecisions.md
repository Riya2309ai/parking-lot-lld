# Parking Lot Management System - Architecture Decisions

        ## Overview

        This document explains the major design decisions taken while designing the Parking Lot Management System.

        The objective is to build a scalable, maintainable, extensible, and object-oriented system following SOLID principles.

        ---

        # 1. Why Object-Oriented Design?

        The parking lot consists of real-world entities such as:

        - Vehicle
        - Parking Spot
        - Parking Floor
        - Parking Ticket
        - Entry Gate
        - Exit Gate

        Object-Oriented Programming naturally models these entities and their relationships.

        ---

        # 2. Why is Vehicle an Abstract Class?

        Every vehicle has common properties:

        - Vehicle Number
        - Vehicle Type

        However, different vehicles may have different parking rules in the future.

        Examples:

        - Car
        - Motorcycle
        - Truck
        - Electric Vehicle

        Instead of duplicating common fields, an abstract class provides a shared implementation while allowing specialization.

        ---

        # 3. Why is ParkingSpot an Abstract Class?

        All parking spots contain common information:

        - Spot ID
        - Occupancy Status
        - Parked Vehicle

        Different parking spot types implement different compatibility rules.

        Examples:

        - Compact Spot
        - Large Spot
        - Motorcycle Spot
        - Electric Spot

        ---

        # 4. Why Use Enums?

        Certain values never change.

        Examples:

        VehicleType

        - CAR
        - TRUCK
        - MOTORCYCLE
        - ELECTRIC

        SpotType

        - COMPACT
        - LARGE
        - MOTORCYCLE
        - ELECTRIC

        Using enums improves readability and prevents invalid values.

        ---

        # 5. Why Use Composition?

        ParkingLot contains ParkingFloors.

        ParkingFloor contains ParkingSpots.

        These objects have a strong "has-a" relationship.

        If a ParkingLot is removed, its floors are no longer meaningful within this system.

        ---

        # 6. Why Strategy Pattern?

        Parking allocation may change.

        Examples:

        - Nearest Spot
        - First Available Spot
        - Least Occupied Floor
        - VIP Parking

        Instead of modifying ParkingLot every time, the allocation algorithm is separated into interchangeable strategies.

        ---

        # 7. Why Factory Pattern?

        Vehicle creation depends on vehicle type.

        Instead of writing multiple if-else blocks throughout the code, a factory centralizes object creation.

        ---

        # 8. Why Singleton Pattern?

        There should typically be only one ParkingLot instance managing the system.

        Singleton ensures controlled access to this shared instance.

        ---

        # 9. Why Keep Business Logic Out of Models?

        Models should represent data.

        Business logic belongs in dedicated service or manager classes.

        This follows the Single Responsibility Principle (SRP).

        ---

        # 10. Extensibility

        The design should support future enhancements without modifying existing code.

        Possible future features:

        - Reservation System
        - Dynamic Pricing
        - Monthly Passes
        - EV Charging
        - Parking Analytics
        - Mobile Application

        The system should follow the Open/Closed Principle whenever possible.