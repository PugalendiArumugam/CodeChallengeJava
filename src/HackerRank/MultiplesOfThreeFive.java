package HackerRank;

public class MultiplesOfThreeFive {
    public static void main(String[] args) {
        System.out.println(multipleSum(2-1));
        System.out.println(multipleSum(10-1));
        System.out.println(multipleSum(100-1));
    }

    public static int multipleSum(int num){
        return anySum(num,3)+anySum(num,5)-anySum(num,15);
    }

    public static int anySum(int num,int multiples){
        double d = (double) num /multiples;
        int flr = (int) Math.floor(d);
        return  multiples * (flr*(flr+1))/2;
    }


    //Brute force... optimize above
    public static int multipleSum2(int N){
        int result=0;
        for (int i=3;i<N;i++){
            if (i%3==0 || i%5==0){
//                System.out.println(i);
                result+=i;
            }
        }
        return result;
    }
}
