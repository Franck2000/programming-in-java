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
# Exercise 3

## Nested Classes in Java

### 1. Main Differences between Types of Nested Classes

Java supports several types of nested classes:

- **Static Nested Class:**
    - A static member class declared with the `static` keyword.
    - It cannot access non-static members of the outer class directly.
    - Instantiated using the syntax: `OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();`

- **Inner (Non-Static Member) Class:**
    - A non-static member class declared without the `static` keyword.
    - It has access to both static and non-static members of the outer class.
    - Instantiated using the syntax: `OuterClass outerObj = new OuterClass(); OuterClass.InnerClass innerObj = outerObj.new InnerClass();`

- **Local Class:**
    - A nested class defined within a method or a block.
    - Has access to the variables of the enclosing block; however, these variables must be effectively final or final.
    - Instantiated within the block where it is defined.

- **Anonymous Class:**
    - A local class without a name.
    - Typically used for one-time use and instantiation.
    - Often employed when implementing interfaces or extending classes in a concise manner.

### 2. Can an Inner Class Be Used in a Class Other Than the Class in Which It Nests?

No, an inner class is associated with an instance of the outer class and cannot be used independently in another class.

### 3. Modifiers for Inner Classes

- **Access Modifiers (`public`, `protected`, `private`):**
    - Inner classes can have these modifiers.
    - The choice depends on the desired visibility and access level.

- **`static` Modifier:**
    - Inner classes can be static, making them independent of the outer class instance.
    - Static nested classes and inner interfaces are examples.

### 4. Refactoring Source Code to One File-One Class Structure

The source code has been refactored to follow the one file-one class structure. Each class is in its own separate file for clarity and maintainability.

# Exercises 4

## Understanding Abstract Classes and Interfaces in Java

## 2. Main Differences between Abstract Classes and Interfaces

### Abstract Classes
- Can have constructors.
- Can have instance variables (non-static fields).
- Supports access modifiers for methods (public, protected, private).
- Allows the use of non-static and static methods.

### Interfaces
- Cannot have constructors.
- Can only have static final variables (constants).
- All methods are implicitly public and abstract.
- Supports multiple inheritance (a class can implement multiple interfaces).

## 3. Possible Types of Members of Java Interfaces

Members of Java interfaces can include:
- Constants (public static final fields).
- Abstract methods (public abstract methods).
- Default methods (methods with default implementations).
- Static methods (public static methods).

## 4. Correct Definition of an Abstract Class

The correct definition of an abstract class is:
```java
abstract class D {
    protected void ml();
}
```
## 5.The correct definition of an interface is:

The correct definition of an interface is:

````java
interface D {
    void ml();
}

````

## 6 .explanation of output of the code provide:

- B b = new B();: An instance of class B is created.

- if (b instanceof A): Checks whether the object b is an instance of interface A. Since class B extends D, and D extends C, the condition is true. This is due to the fact that the instanceof operator considers the entire inheritance hierarchy.

- System.out.println("b is an instance of A");: Prints "b is an instance of A" to the console.

- if (b instanceof C): Checks whether the object b is an instance of class C. Since class B extends D, which extends C, the condition is also true.

- System.out.println("b is an instance of C");: Prints "b is an instance of C" to the console.

# Exercises 5 
## Explanation
Relationship between Lambda Expressions and Functional Interfaces
   Lambda expressions in Java are closely associated with functional interfaces. A functional interface is an interface that contains only one abstract method (SAM - Single Abstract Method), and lambda expressions provide a concise way to implement the abstract method of a functional interface.

Lambda expressions are used to create instances of functional interfaces without the need to explicitly define a separate class. They introduce a more readable and compact syntax for writing anonymous classes when the interface has only one method.


## Implementation 
- available on my repository on directory myFunctiionInterface


MY REPO : https://github.com/Franck2000/programming-in-java.git