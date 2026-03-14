package DSA;

public class FibonacciGenerator {
    public static void main(String[] args) {
        int count = 24; // Number of Fibonacci numbers to generate
        int[] fibonacci = new int[count];

        fibonacci[0] = 0;
        if (count > 1) {
            fibonacci[1] = 1;
        }

        for (int i = 2; i < count; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        for (int num : fibonacci) {
            System.out.print(num + " ");
        }
    }


}
