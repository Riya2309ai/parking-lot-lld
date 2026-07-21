# Primary Use Cases

## UC-1
Park Vehicle

Actor:
Customer

Flow:

Customer enters

↓

System finds nearest available spot

↓

System allocates spot

↓

Ticket generated

↓

Barrier opens

---

## UC-2

Exit Vehicle

Customer reaches Exit Gate

↓

System validates ticket

↓

Calculates fee

↓

Payment successful

↓

Parking spot released



## UseCases in Descripted way mentioned:


# Parking Lot Management System - Use Cases

# UC-1: Park a Vehicle

## Actor

Customer

---

## Preconditions

- Vehicle arrives at the entry gate.
- Parking lot has at least one compatible parking spot available.

---

## Main Flow

1. Customer arrives at the entry gate.
2. System identifies the vehicle type.
3. System searches for the nearest available compatible parking spot.
4. System allocates the parking spot.
5. System generates a parking ticket.
6. Entry gate opens.
7. Customer parks the vehicle.

---

## Alternate Flows

### AF-1

No parking spot is available.

Result:

- Display "Parking Full".
- Entry denied.

---

### AF-2

Vehicle type is unsupported.

Result:

- Entry denied.

---

## Postconditions

- Parking spot becomes occupied.
- Parking ticket is active.
- Vehicle is successfully parked.

==================================================================

# UC-2: Exit a Vehicle

## Actor

Customer

---

## Preconditions

- Vehicle is already parked.
- Customer has a valid parking ticket.

---

## Main Flow

1. Customer reaches the exit gate.
2. System validates the ticket.
3. System calculates parking fee.
4. Customer makes payment.
5. Payment is successful.
6. Parking spot is released.
7. Ticket is closed.
8. Exit gate opens.

---

## Alternate Flows

### AF-1

Invalid ticket.

Result:

- Exit denied.

---

### AF-2

Payment fails.

Result:

- Retry payment.

---

## Postconditions

- Parking spot becomes available.
- Ticket is closed.
- Vehicle exits successfully.

==================================================================

# UC-3: Search Vehicle

## Actor

Parking Operator

---

## Preconditions

- Vehicle is currently parked.

---

## Main Flow

1. Operator enters vehicle number.
2. System searches the parking lot.
3. System displays floor and parking spot.

---

## Alternate Flow

Vehicle not found.

Result:

Display:

Vehicle not present.

==================================================================

# UC-4: Display Available Parking

## Actor

Customer / Operator

---

## Main Flow

1. Request parking availability.
2. System calculates available spots.
3. System displays:

- Motorcycle Spots
- Compact Spots
- Large Spots
- Electric Spots

==================================================================

# UC-5: View Parking Ticket

## Actor

Customer

---

## Main Flow

Display:

- Ticket ID
- Vehicle Number
- Entry Time
- Parking Spot
- Parking Floor
