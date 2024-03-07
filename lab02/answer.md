# Exercises 1

## 2. Benefits of Using Constants:

- Enhances C ode Readability: Constants provide meaningful names to values, making code more readable.
- Avoids Magic Numbers: Constants eliminate the use of magic numbers, enhancing code maintenance.
- Ensures Consistency: Constants maintain consistent values throughout the program.
- Facilitates Code Changes: Changes to constant values are centralized, making updates easier.

## 3. Keyword 'final' Usage:

- Local Variables: Implies the variable is effectively final (assigned once).
- Instance Variables: Implies the variable is a constant (unchangeable once assigned).
- Static Constants: Implies a constant value shared across all instances.
- Methods: Implies the method cannot be overridden in subclasses.
- Classes: Implies the class cannot be subclassed.

## 4. Immutability Questions:

- If a class contains only private data fields and no setter methods, it does not guarantee immutability. Immutable classes typically have no mutator methods, a private state, and final fields.
- If all data fields are private and of primitive types, and the class lacks setter methods, it provides a level of immutability, but it may still be mutable if the class contains methods that modify the state.

## 5. Immutability of Class C:

- The class is not immutable because the `getValues` method returns a reference to the internal array, allowing external modification.

## 6. Refactored Source Code:

```java
public class ImmutableClass {

    private final int[] values;

    public ImmutableClass(int[] values) {
        this.values = values.clone(); // Defensive copying to maintain immutability
    }

    public int[] getValues() {
        return values.clone(); // Defensive copying to prevent external modifications
    }
}
```
# Exercises 2

### Enum-Based Singleton

The provided code attempts to create an enum-based singleton but contains a syntax error in the `setValue` method. Additionally, the thread safety of this implementation is questionable. Enum-based singletons are inherently thread-safe, but the addition of a mutable field (`value` in this case) and a setter method introduces potential thread safety issues.

Here's the corrected and refactored code:

```java
// EnumBasedSingleton.java

public enum EnumBasedSingleton {
    INSTANCE;

    private int value; // Make the field private

    public int getValue() {
        return value;
    }

    public synchronized void setValue(int value) { // Add synchronized for thread safety
        this.value = value;
    }
}
```

