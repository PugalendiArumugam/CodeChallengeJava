package CoreJava;

public class Constructr {
    int i;
    String name;
    int age =33;
    Constructr constructr;

    Constructr(){
        this.age=34;
        constructr=this;
    };

    public boolean next(){
        System.out.println("next executed");
        return false;
    }

/*    Constructr(int inputage){
        this.age=inputage;
    }*/


    public static void main(String[] args) {
        Constructr cc = new Constructr();
        System.out.println(cc.i);
        System.out.println(cc.name);
        System.out.println(cc.age);
        System.out.println(cc.next());
        cc.constructr.next();
    }
}
