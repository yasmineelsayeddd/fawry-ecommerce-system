# Fawry Challenge 2025 — E-Commerce System

This repository contains my submission for the **Fawry Rise Journey Full Stack Development Internship Challenge 2025**.  
It is a modular, extensible, and SOLID-compliant Java-based e-commerce system that simulates product listing, cart operations, and customer checkout.

---

## Features

- Define products with name, price, and quantity.
- Add optional behaviors:
  - **Expiration** (e.g. Cheese, Biscuits)
  - **Shipping** (e.g. Cheese, TV) — with weight provided.
- Cart functionality:
  - Add products with quantity checks
  - Prevent expired or out-of-stock products
- Checkout:
  - Calculate subtotal, shipping, and total
  - Deduct from customer balance
  - Ship shippable items via `ShippingService`
- Informative console output matching Fawry's sample format

---

## Assumptions & Design Decisions

- **Product names are unique**, used to manage cart contents and prevent duplication.
- A product can be **shippable**, **expirable**, both, or neither — so I avoided inheritance and used **decorators** to dynamically compose behavior.
- **Shipping is calculated by total weight** using a strategy pattern (`WeightBasedShippingStrategy`), so new strategies (like free shipping) can be added without rewriting core logic.
- **Shippable items** implement a separate `ShippableItem` interface with `getName()` and `getWeight()` as required by the problem.

---

## Design Patterns Used

### Decorator Pattern  
Used to wrap base products with extra features like expiration and shipping.

- Keeps classes small and focused
- Supports combinable behavior without subclass explosion

### Strategy Pattern  
Used for shipping fee calculation.

- Makes the shipping logic replaceable
- Code is open for extension, closed for modification

### Interface Segregation Principle  
Interfaces like `Product` and `ShippableItem` keep roles clear and avoid forcing classes to implement unnecessary methods.

---

## Sample Output
2 x Cheese added to cart.
1 x Biscuits added to cart.
1 x TV added to cart.
1 x Scratch Card added to cart.

** Shipment notice **

Cheese 800.0g

Biscuits 700.0g

TV 7000.0g
Total package weight 8.5kg

** Checkout receipt **
2x Cheese 200.0
1x Biscuits 150.0
1x TV 5000.0
1x Scratch Card 50.0
Subtotal 5400.0
Shipping 255.0
Amount 5655.0
Remaining balance: 4345.0

---

## How to Run

1. Clone the repo or download the `.zip`  
2. Open terminal or command prompt and navigate to the project directory  
3. Compile and run the main class:

```bash
javac Main.java
java Main
Make sure all .java files are inside the same folder or under a src/ directory.
```
## Author
Yasmine Elqorashy
GitHub: @yasmineelsayeddd

## Notes
Code was written in Java and does not use external dependencies.

Follows SOLID principles and uses three core OOP design patterns.

Designed to be readable and extendable for future functionality like GUI or database storage.


