# Testing

This project includes JUnit test suites for the `MechanicalSystem` component, covering both kernel and secondary methods.

## Test Structure

* `MechanicalSystem1Test`
  Tests all kernel methods such as setters, getters, force application, reset, clear, `newInstance`, and `transferFrom`.

* `MechanicalSystemSecondaryTest`
  Tests higher-level behaviors including acceleration, motion stepping, kinetic energy, rest detection, and object equality.

## Testing Approach

The tests are designed to verify:

* Correct return values for all operations
* Proper updates to the system state
* Preservation of unaffected fields after each method call

Since no reference implementation is used, correctness is validated by directly inspecting the state of the object after each operation.

## Coverage

The test suite covers:

* All kernel methods
* All secondary methods
* Object behavior (`equals`, `hashCode`, `toString`)

Overall, the tests ensure that the component behaves consistently with its design-by-contract specifications.
