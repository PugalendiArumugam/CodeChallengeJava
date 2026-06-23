package CoreJava;

public class String1Concept {
    public static void main(String[] args) {
        String str1 = new String("Pugal");
        String str2 = new String("Pugal");
        System.out.println(str1.equals(str2));
        StringBuffer sb1 = new StringBuffer("Pugal");
        StringBuffer sb2 = new StringBuffer("Pugal");
        System.out.println(sb1.equals(sb2));
        StringBuilder sbd1 = new StringBuilder("Pugal");
        StringBuilder sbd2 = new StringBuilder("Pugal");
        System.out.println(sbd1.equals(sbd2));
    }
}
