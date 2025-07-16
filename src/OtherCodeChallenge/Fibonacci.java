//*
//* Get n th term and print Fibannaci series
//* input 4  output 0 1 1 2
//* input 6  output 0 1 1 2 3 5
public class Fibonacci {
    public static void main(String[] args) {
        int nthTerm = 4;
        printFeboSeries(nthTerm);
    }

    public static void printFeboSeries(int nthterm) {
        int firstT = 0;
        int secondT = 1;
        int thirdT = 0;
        System.out.println();
        if (nthterm == 0) return;
        System.out.print(firstT + " ");
        if (nthterm == 1) return;
        System.out.print(secondT + " ");
        while (nthterm > 2) {
            thirdT = firstT + secondT;
            System.out.print(thirdT + " ");
            firstT = secondT;
            secondT = thirdT;
            nthterm -= 1;
        }
    }
}
