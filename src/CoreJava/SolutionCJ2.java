package CoreJava;

class Base {
    static void display(){
        System.out.println("Base class");
    }
}

class Derived extends Base{
    static void display(){
        System.out.println("Derived class");
    }
}

public class SolutionCJ2 {
    public static void main(String[] args) {
        Base obj = new Derived();
        obj.display();
    }
}
