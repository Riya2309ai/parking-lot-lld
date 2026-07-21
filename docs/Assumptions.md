# Parking Lot Management System - Assumptions

## Overview

These assumptions define the scope of the Parking Lot Management System and help avoid ambiguity during design and implementation.

---

## General Assumptions

- A vehicle can occupy only one parking spot at a time.
- A parking spot can accommodate only one vehicle at a time.
- Every vehicle has a unique registration number.
- Every parking ticket has a unique ticket ID.
- Every parking spot has a unique spot ID.
- Every parking floor has a unique floor number.

---

## Parking Rules

- A vehicle can park only in a compatible parking spot.
- An occupied parking spot cannot be allocated to another vehicle.
- A parking spot becomes available immediately after the vehicle exits.

---

## Ticket Rules

- A parking ticket is generated when a vehicle enters.
- A ticket remains active until the vehicle exits.
- Each ticket is associated with exactly one vehicle and one parking spot.

---

## Payment Rules

- Payment is made only during vehicle exit.
- Parking fee is calculated based on the total parking duration.
- A vehicle cannot exit until the payment is completed successfully.

---

## System Assumptions

- The parking lot may have multiple floors.
- Each floor contains multiple parking spots.
- The parking lot may have multiple entry gates.
- The parking lot may have multiple exit gates.
- The system should be designed to support concurrent vehicle entries and exits in the future.

---

## Future Enhancements

The following features are intentionally excluded from the initial version:

- Online parking reservation
- Monthly subscriptions
- EV charging management
- Dynamic pricing
- Parking analytics dashboard
- Mobile application integration