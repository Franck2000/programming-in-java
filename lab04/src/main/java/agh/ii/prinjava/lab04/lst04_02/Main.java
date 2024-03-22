package agh.ii.prinjava.lab04.lst04_02;

public class Main {
    /**
     * Generics enable you to detect errors at compile time rather than at runtime.
     */
    private static void demo1() {
        System.out.println("demo1...");
        GenBox gb1 = new GenBox(1);
        gb1.setX("abc");
        gb1.setX(new GenBox(true));
    }

    /**
     * NEVER USE <i>RAW</i> types as were used before Java 5!
     * <p>Warning: Main.java uses unchecked or unsafe operations
     *
     * <p>A <i>raw type</i> - a generic class or interface used without specifying a concrete type
     * (this enables backward compatibility with earlier versions of Java, i.e., pre-Java5).
     */
    private static void demo2() {
        System.out.println("demo2...");

        // Never use raw types!!!
        GenBox b1 = new GenBox(3); // raw type, compiles, but... (T ~ Object)
        //int x = b1.getX(); // <- Required type: int. Provided: Object
        int x = (int) b1.getX();
        System.out.println("x from b1 = " + x);

        /*
         * String y = (String) b1.getX(); // <- ClassCastException
         * System.out.println("y (as String) from b1 = " + y);
         */
        String y = b1.getX().toString();
        System.out.println("y from getX().toString() = " + y);
    }

    public static void main(String[] args) {
        demo1();

    }
}
