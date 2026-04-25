# Mechanical System Component

## Overview

This project implements a **Mechanical System component** that models a simple physical system using fundamental physics principles such as Newton’s Second Law.

The system represents an object with:

* mass
* position
* velocity
* applied forces

It allows users to simulate motion over time by applying forces and advancing the system state.

---

## Features

* Set and update system properties (mass, position, velocity)
* Apply and accumulate forces
* Compute acceleration using Newton’s Second Law
* Advance the system using time steps
* Calculate kinetic energy
* Detect whether the system is at rest

---

## Design

### Representation

The system is implemented using the following fields:

* `mass` → double
* `position` → Vector
* `velocity` → Vector
* `netForce` → Vector

This representation was chosen because it directly models the physical quantities required for motion simulation.

### Representation Invariant

* mass > 0
* position ≠ null
* velocity ≠ null
* netForce ≠ null

(Enforced in implementation)

---

### Abstraction Function

The system represents:

```
(mass, position, velocity, forces)
```

where:

* mass = object's mass
* position = current position vector
* velocity = current velocity vector
* forces = collection of applied forces (stored as net force)

---

## API

### Kernel Methods

* `setMass(double m)`
* `setPosition(Vector p)`
* `setVelocity(Vector v)`
* `applyForce(Vector f)`
* `clearForces()`
* `reset()`

These define the core behavior of the system

---

### Secondary Methods

* `acceleration()`
* `step(double deltaT)`
* `kineticEnergy()`
* `isAtRest()`

These provide higher-level physics functionality

---

## Physics Model

### Acceleration

```
a = F / m
```

Implemented using:

```java
return scale(netForce, 1.0 / mass);
```

---

### Motion Update (Step)

Velocity:

```
v = v + a * dt
```

Position:

```
x = x + v * dt
```

Implemented in `step()`

---

## Use Cases

### Use Case 1: Basic Simulation

```java
MechanicalSystem system = new MechanicalSystem1();

system.setMass(2.0);
system.applyForce(new Vector2D(4.0, 0.0));

System.out.println(system.acceleration());

system.step(1.0);

System.out.println(system.getPosition());
System.out.println(system.getVelocity());
```

This simulates a simple object under constant force.

---

### Use Case 2: Moving Object Wrapper

```java
MovingObject obj = new MovingObject(5.0);

obj.push(10, 0);
obj.update(1.0);

System.out.println(obj.getPosition());
```

This demonstrates how the component can be embedded in another system abstraction.

---

## Testing

Testing is designed to verify:

* Correct return values
* Object state is preserved after operations

Example testing strategy:

```java
assertEquals(true, system.isAtRest());
assertEquals(copy, system);
```

Tests cover:

* kernel methods
* secondary methods
* state consistency

---

## Project Structure

```
src/
  MechanicalSystem1.java
  MechanicalSystemSecondary.java
  MechanicalSystemKernel.java
  MechanicalSystem.java
  Vector.java
  Vector2D.java
  MovingObject.java
  UseCase1.java

test/
  (JUnit test files)

doc/
  (design documentation)

lib/
  junit, components.jar
```

---

## Reflection

Through this project, I gained a deeper understanding of:

* designing software components using abstraction and contracts
* separating kernel and secondary methods
* modeling real-world systems in code
* writing testable and modular software

One key challenge was ensuring that methods not only returned correct values but also preserved system state. This improved my understanding of correctness beyond simple outputs.

This project strengthened my confidence in building structured and reusable software components.

---

## How to Run

1. Compile all Java files
2. Run:

```
UseCase1.java
```

---

## Author

* Yuchen Wang
