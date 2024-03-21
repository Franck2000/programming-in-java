# Lab 05 
  
## Generic methods, classes, and interfaces

### Benefits of Using Generic Types
- **Type Safety:** Generics provide compile-time type checking, ensuring that the correct data types are used.
- **Code Reusability:** Generics allow you to write code that can work with any data type, reducing code duplication.
- **Elimination of Type Casting:** Generics eliminate the need for explicit type casting, making the code cleaner and more readable.
- **Better Performance:** Generics improve performance by avoiding unnecessary runtime type checks and casts.
- **Enhanced Code Documentation:** Generics make code more self-documenting by specifying the types of data used by classes, methods, and interfaces.

### Syntax of Generic Class and Method Declaration
- **Generic Class Declaration:**
  ```java
  public class ClassName<T> {
      // Class body
  }
  ```
Here, ClassName is the name of the generic class, and <T> is the type parameter declaration. T is a placeholder for the actual data type(s) that will be specified when creating an instance of the class.

- **Generic Method Declaration:**

````java
public <T> ReturnType methodName(Parameter<T> param) {
    // Method body
}
````
In a generic method declaration, <T> specifies the type parameter, and it can be used as part of the method signature or implementation. The method can accept parameters of type T and return values of type ReturnType.

### Raw Type and its Implications
- A raw type in Java is a generic type declaration without specifying any type arguments.
- Raw types are considered unsafe because they bypass the type checking provided by generics, leading to potential runtime errors.
- However, raw types are allowed in Java for backward compatibility with older code that predates generics. They are permitted to ensure compatibility with legacy codebases and libraries.

### Compilation Result of Given Code Snippets
- Snippet (a): In the first snippet, GenBox gb1 = new GenBox(1); creates a raw type instance of GenBox, allowing any type to be assigned to x. Therefore, gb1.setX("abc"); and gb1.setX(new GenBox(true)); compile successfully but may cause runtime errors due to type mismatch.
- Snippet (b): In the second snippet, GenBox<Integer> gb2 = new GenBox(1); creates a generic type instance of GenBox with the type parameter Integer. Attempting to assign a String value to x (gb2.setX("abc");) results in a compilation error due to a type mismatch, ensuring type safety. Similarly, gb2.setX(new GenBox(true)); also produces a compilation error for the same reason.

### Complete the method header in the following code so that it compiles:
````java
public class Main {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3};
        String[] strs = {"A", "B", "C"};

        print(ints);
        print(strs);
    }

    // Generic method to print elements of an array
    public static <T> void print(T[] elems) {
        for (int i = 0; i < elems.length; i++) {
            System.out.print(elems[i] + " ");
        }
        System.out.println();
    }
}

````
## Bounds for type variables 

## Exercise 3

### Purpose of Bounds for Type Variables:
Bounds for type variables in Java serve the purpose of restricting the types that can be substituted for those variables. By applying bounds, you can specify that a type variable must be a subtype of a particular class or implement certain interfaces. This helps to ensure type safety and allows you to enforce constraints on the types that can be used with generic classes or methods. Bounds provide compile-time checks to prevent inappropriate usage of types, which can help catch errors early in the development process.

### Multiple Interface Bounds for a Type Variable:
- In Java, a type variable can have multiple interface bounds by using the & operator to specify additional interface bounds after the first one.
- For example, consider the following syntax for a generic class declaration with multiple interface bounds:
````java
class MyClass<T extends Interface1 & Interface2 & Interface3> { ... }

````

- In this case, the type variable T is bounded to types that implement Interface1, Interface2, and Interface3. This ensures that T can be any type that implements all three interfaces.
- Multiple interface bounds are useful when you need to enforce that a type variable implements multiple interfaces to provide certain functionality or to satisfy specific contract requirements.
### Multiple Class Bounds for a Type Variable:

- Unlike multiple interface bounds, Java does not support specifying multiple class bounds for a type variable.
- You can only specify one class bound for a type variable in Java.
- If you need to impose additional constraints on the type variable beyond a single class bound, you can achieve that by using a combination of a class bound and one or more interface bounds.
- For example:
````java
class MyClass<T extends MyClassBase & Interface1 & Interface2> { ... }

````
- Here, MyClassBase is the class bound, and Interface1 and Interface2 are the interface bounds. This ensures that T is a subtype of MyClassBase and implements both Interface1 and Interface2.

### Change the following generic function so that it compiles
To modify the moveAll function so that it compiles, we need to declare an interface Moveable with a method goTo(double x, double y), and then use this interface as the bound for the type variable T. Here's how we can achieve this:
````java
interface Moveable {
    void goTo(double x, double y);
}

private static <T extends Moveable> void moveAll(T[] elems, double x, double y) {
    for (var e : elems) {
        e.goTo(x, y);
    }
}

````
****In this modified version:****
-
- We declare an interface Moveable with a method goTo(double x, double y).
- We use T extends Moveable as the bound for the type variable T in the moveAll method signature. This means that T can only be a type that implements the Moveable interface.
- Now, the moveAll function will compile successfully, and it can be used to move all elements of an array of Moveable objects to a specified point (x, y).


## Exercise 4
### 1 Invariance, Covariance, and Contravariance:

- Invariance: Invariance means that a generic type parameter preserves its relationship with other types in all situations. In other words, if ClassA is a subtype of ClassB, then GenBox<ClassA> is neither a subtype nor a supertype of GenBox<ClassB>. Invariance ensures type safety but can be restrictive in some cases.

- Covariance: Covariance allows a generic type to vary in the same direction as its type parameter. In other words, if ClassA is a subtype of ClassB, then GenBox<ClassA> is considered a subtype of GenBox<ClassB>. Covariance preserves the ordering of types, ensuring that subtyping relationships are maintained.

- Contravariance: Contravariance is the opposite of covariance. It allows a generic type to vary in the opposite direction of its type parameter. In other words, if ClassA is a subtype of ClassB, then GenBox<ClassB> is considered a subtype of GenBox<ClassA>. Contravariance reverses the ordering of types, allowing more flexibility in certain scenarios.

### 2 Subtype Wildcard, Supertype Wildcard, and Unbounded Wildcard:

- Subtype Wildcard (<? extends T>): Also known as an upper bounded wildcard, it represents some unknown type that is a subtype of T. This wildcard allows flexibility when dealing with subtypes of a specific type. For example, List<? extends Number> can hold a list of any type that extends Number, such as Integer, Double, or Float.

- Supertype Wildcard (<? super T>): Also known as a lower bounded wildcard, it represents some unknown type that is a supertype of T. This wildcard allows flexibility when dealing with supertypes of a specific type. For example, List<? super Integer> can hold a list of any type that is a superclass of Integer, such as Number or Object.

- Unbounded Wildcard (<?>): Also known as an any object wildcard, it represents some unknown type. This wildcard is not bounded by any specific type and can accept any type of object. It provides maximum flexibility but limits the operations that can be performed on the elements. For example, List<?> can hold a list of objects of any type, but you cannot add elements to it except for null.

### Subtyping and Wildcards
 ```java
class A {}
class B extends A {}
class C extends B {}
class GenBox<T> {
  private T x;

  public T getX() { return x; }
  public void setX(T x) { this.x = x; }
  //...
}

// Creating instances of GenBox with various type parameters
GenBox<B> gb1 = new GenBox<B>(); // Valid
GenBox<B> gb2 = new GenBox<C>(); // Error: Cannot convert from GenBox<C> to GenBox<B> because of invariance
GenBox<B> gb3 = new GenBox<A>(); // Error: Cannot convert from GenBox<A> to GenBox<B> because of invariance
B b1 = gb1.getX(); // Valid
gb1.setX(new B()); // Valid

GenBox<? extends B> gb4 = new GenBox<B>(); // Valid
GenBox<? extends B> gb5 = new GenBox<C>(); // Valid
GenBox<? extends B> gb6 = new GenBox<A>(); // Error: Cannot convert from GenBox<A> to GenBox<? extends B> because A is not a subtype of B
B b2 = gb5.getX(); // Valid, returns type B or a subtype of B
gb5.setX(new B()); // Error: Cannot assign to a wildcard-extended generic
gb5.setX(new C()); // Error: Cannot assign to a wildcard-extended generic

GenBox<? super B> gb7 = new GenBox<B>(); // Valid
GenBox<? super B> gb8 = new GenBox<C>(); // Error: Cannot convert from GenBox<C> to GenBox<? super B> because C is a subtype of B, not a supertype
GenBox<? super B> gb9 = new GenBox<A>(); // Valid
B b3 = gb9.getX(); // Error: The return type is of type Object, requires casting to B
gb9.setX(new B()); // Valid, can accept B or its subtypes
gb9.setX(new C()); // Valid, can accept C as it is a subtype of B

GenBox<?> gb10 = new GenBox<B>(); // Valid, unknown type, but compatible with any GenBox
GenBox<?> gb11 = new GenBox<C>(); // Valid, unknown type, but compatible with any GenBox
GenBox<?> gb12 = new GenBox<A>(); // Valid, unknown type, but compatible with any GenBox
Object b4 = gb10.getX(); // Valid, returns Object type since the generic type T is unknown
gb10.setX(new B()); // Error: Cannot assign to an unbounded wildcard generic
```
