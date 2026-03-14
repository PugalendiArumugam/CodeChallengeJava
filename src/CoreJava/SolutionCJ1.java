package CoreJava;


class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
}

class C extends B {
    public C() {
        System.out.println("C");
    }
}

public class SolutionCJ1 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        A a3 = new C();
        B b1 = new B();
        B b2 = new B();
        C c1 = new C();

//        B b0 = new A();    // not allowed.
//        C c0 = new A();    // not allowed.
//        C cx = new B();    // not allowed.
    }
}
