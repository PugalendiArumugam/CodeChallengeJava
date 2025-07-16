package HackerRank;

public class EvenFibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(EvenFibonacciSum(2));
        System.out.println(EvenFibonacciSum(10));
    }

    public static long EvenFibonacciSum(int limit){
        long one = 2;
        long two = 8;
        long temp = 0;
        long sum = 0;
        while(one < limit)
        {
            sum += one;
            temp = two;
            two = 4 * two + one;
            one = temp;
        }
        return sum;
    }
}
