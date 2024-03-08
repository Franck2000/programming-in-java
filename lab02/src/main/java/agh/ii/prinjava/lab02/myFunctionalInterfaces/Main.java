package agh.ii.prinjava.lab02.myFunctionalInterfaces;

public class Main {
    private  static void  demo1(){
        // Anonymous class implementation
        MyI1 i1Anon = new MyI1() {
            @Override
            public int apply() {
                return 42;
            }
        };

// Lambda expression implementation
        MyI1 i1Lambda = () -> 42;
        System.out.println("interface 1 with Anonymous class:" + i1Anon.apply());
        System.out.println("interface 1 with Lambda Expression :" + i1Anon.apply());
    }

    private  static void  demo2(){

        // Anonymous class implementation
        I2 i2Anon = new I2() {
            @Override
            public void apply(String s) {
                System.out.println("Length: " + s.length());
            }
        };

// Lambda expression implementation
        I2 i2Lambda = s -> System.out.println("Length: " + s.length());

        System.out.println("interface 2 with Anonymous class:");
        i2Anon.apply("bonjour");
        System.out.println("interface 2 with Lambda Expression :");
        i2Anon.apply("bonsoir");
    }
    private  static void  demo3(){

        // Anonymous class implementation
        I3 i3Anon = new I3() {
            @Override
            public int apply(int x) {
                return 2 * x;
            }
        };

// Lambda expression implementation
        I3 i3Lambda = x -> 2 * x;

        System.out.println("interface 3 with Anonymous class:" + i3Anon.apply(50));
        System.out.println("interface 3 with Lambda Expression :" + i3Anon.apply(60));
    }


    private  static void  demo4(){
        // Anonymous class implementation
        I4 i4Anon = new I4() {
            @Override
            public void apply(int x, int y) {
                System.out.println("Sum: " + (x + y));
            }
        };

// Lambda expression implementation
        I4 i4Lambda = (x, y) -> System.out.println("Sum: " + (x + y));
        System.out.println("interface 4 with Anonymous class:" );
        i4Anon.apply(50,120);
        System.out.println("interface 4 with Lambda Expression :" );
        i4Anon.apply(60,150);
    }

    public static void main(String[] args) {
        demo1();
        System.out.println();

        demo2();
        System.out.println();

        demo3();
        System.out.println();

        demo4();
        System.out.println();
    }

}
