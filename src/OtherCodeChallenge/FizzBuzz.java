public class FizzBuzz {
    //************************************************************************
    //* print number 1 to 100, but if the number is multiple of 3 print Fizz ≈
    //* or if number is multiple of 5 print Buzz, but if number multiple of both
    //* 3 and 5 print FizzBuzz
    //************************************************************************

    public static void main(String[] args) {
        printFizzBuzz(100);
    }

    public static void printFizzBuzz(int in){
        for (int i = 1; i <= in; i++){
            if ((i%3==0)&&(i%5==0)){
                System.out.println("FizzBuzz");
            } else if (i%3==0) {
                System.out.println("Fizz");
            } else if (i%5==0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
