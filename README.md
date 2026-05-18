# OBTRS - Online Bus Ticket Reservation System

**Course:** CPIT 252 - Software Design Patterns
**Section:** IT3 | **Semester:** Spring 2025/2026
**Instructor:** Prof. Dr. M. Rizwan Jameel Qureshi

**Team:**
| Name | ID |
|---|---|
| Abdullah Anwar Ageeli | 2336154 |
| Elyas Abdullah Al-Ghamdi | 2336000 |
| Hassan Ahmed Asiri | 2339657 |

**Case Study:**
Mehra, D., Gangadia, J., Ghag, J., and Gupta, A. (2021). Bus Reservation System.
International Research Journal of Modernization in Engineering Technology and Science (IRJMETS),
Vol. 03, Issue 05, May 2021. e-ISSN: 2582-5208. Impact Factor: 5.354.
Link: https://www.irjmets.com/uploadedfiles/paper/volume3/issue_5_may_2021/11341/1628083460.pdf

---

## About

OBTRS is a Java-based bus ticket reservation system for Imo Transport Company (ITC), Owerri, Nigeria.
It solves the problem of manual, counter-only ticket sales by providing an online booking system
that validates seats, calculates NGN prices, confirms bookings, and notifies passengers via SMS.

The system is implemented using nine software design patterns as part of a university project
for CPIT 252 - Software Design Patterns at King Abdulaziz University.

---

## Design Patterns Used

| Pattern | Type | File |
|---|---|---|
| Singleton | Creational | DatabaseConnection.java |
| Factory Method | Creational | TicketFactory.java |
| Builder | Creational | BookingBuilder.java |
| Proxy | Structural | SeatService.java, RealSeatService.java, SeatAvailabilityProxy.java |
| Decorator | Structural | TicketDecorator.java, MealDecorator.java, InsuranceDecorator.java |
| Facade | Structural | BookingFacade.java |
| Strategy | Behavioral | PricingStrategy.java, StandardPricingStrategy.java, VIPPricingStrategy.java, ExpressPricingStrategy.java |
| Observer | Behavioral | BookingObserver.java, PassengerNotifier.java |
| MVC | Architecture | BookingView.java, BookingController.java |

---

## Project Structure

```
bus-ticket-reservation-dp/
|
+-- assets/
|   +-- class-diagram.png             <- UML class diagram (derived from use case diagram)
|   +-- use-case-diagram.png          <- UML use case diagram (Passenger and Admin actors)
|   +-- output-screenshot.png         <- Screenshot of the program running in the terminal
|   +-- CPIT252_Group_Project_Report.docx  <- Full project report
|   +-- case-study.pdf                <- IRJMETS case study paper (Mehra et al., 2021)
|
+-- src/
|   +-- model/
|   |   +-- Ticket.java               (1)  Core ticket data class
|   |   +-- Passenger.java            (2)  Passenger personal data
|   |   +-- Booking.java              (3)  Booking record
|   |   +-- BusTicket.java            (4)  Concrete ticket subclass
|   |
|   +-- singleton/
|   |   +-- DatabaseConnection.java   (5)  Creational - Singleton
|   |
|   +-- factory/
|   |   +-- TicketFactory.java        (6)  Creational - Factory Method
|   |
|   +-- builder/
|   |   +-- BookingBuilder.java       (7)  Creational - Builder
|   |
|   +-- proxy/
|   |   +-- SeatService.java          (8)  Structural - Proxy interface
|   |   +-- RealSeatService.java      (9)  Structural - Proxy real subject
|   |   +-- SeatAvailabilityProxy.java (10) Structural - Proxy gatekeeper
|   |
|   +-- decorator/
|   |   +-- TicketDecorator.java      (11) Structural - Decorator base
|   |   +-- MealDecorator.java        (12) Structural - Adds meal (+NGN 500)
|   |   +-- InsuranceDecorator.java   (13) Structural - Adds insurance (+NGN 300)
|   |
|   +-- facade/
|   |   +-- BookingFacade.java        (14) Structural - Facade (orchestrates all patterns)
|   |
|   +-- strategy/
|   |   +-- PricingStrategy.java      (15) Behavioral - Strategy interface
|   |   +-- StandardPricingStrategy.java (16) No change to base price
|   |   +-- VIPPricingStrategy.java   (17) +20% VIP premium
|   |   +-- ExpressPricingStrategy.java (18) +10% Express surcharge
|   |
|   +-- observer/
|   |   +-- BookingObserver.java      (19) Behavioral - Observer interface
|   |   +-- PassengerNotifier.java    (20) Behavioral - Sends SMS confirmation
|   |
|   +-- view/
|   |   +-- BookingView.java          (21) MVC - View (displays output)
|   |
|   +-- controller/
|   |   +-- BookingController.java    (22) MVC - Controller
|   |
|   +-- Main.java                     (23) Entry point
|
+-- .gitignore
+-- README.md
```

---

## Note on Diagrams

The class diagram is derived directly from the use case diagram.
The use case diagram identifies the actors (Passenger and Bus Owner/Admin) and the operations
they perform. Those operations become the methods in the class diagram, and the data each
operation needs becomes the class attributes. This is standard UML methodology.

Both diagrams are available in the assets/ folder.

---

## ITC Ticket Pricing (NGN)

| Class | Base Price | With Meal | With Insurance | With Both |
|---|---|---|---|---|
| STANDARD | 3,500 | 4,000 | 3,800 | 4,300 |
| VIP | 7,000 | 7,500 | 7,300 | 7,800 |
| EXPRESS | 5,000 | 5,500 | 5,300 | 5,800 |

VIP strategy adds 20% on top. Express strategy adds 10% on top.

---

## Demo Scenarios

| Booking | Passenger | Route | Type | Seat | Result |
|---|---|---|---|---|---|
| BK-001 | Chukwu Emeka | Lagos-Owerri | STANDARD | 12 | Confirmed - NGN 3,500 |
| BK-002 | Ngozi Okonkwo | Abuja-PortHarcourt | VIP | 3 | Confirmed - NGN 8,400 |
| Demo | n/a | Lagos-Abuja | EXPRESS | n/a | Decorator stacking demo |
| BK-003 | Tunde Balogun | Owerri-Enugu | STANDARD | 99 | Proxy blocks invalid seat |

---

## How to Run

1. Clone the repository
2. Open the src/ folder in your IDE (VS Code recommended)
3. Run Main.java

No external libraries required. Plain Java only.

---

## Appendix

Full project report: assets/CPIT252_Group_Project_Report.docx
Case study PDF: assets/case-study.pdf
GitHub: https://github.com/HsnAQA/bus-ticket-reservation-dp
