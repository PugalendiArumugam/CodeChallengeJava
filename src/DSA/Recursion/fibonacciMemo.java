package DSA.Recursion;

public class fibonacciMemo {
    public static void main(String[] args) {
        int n = 30;

        long start = System.currentTimeMillis();

        for (int i = 1; i <= n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println(start+" "+end);
        System.out.println("Took : " + ((end - start) / 1000));


        start = System.currentTimeMillis();

        System.out.println("No recursion");
        int m=30, firstNum=0, secondNum=1;
        int nextNum;
        for (int j=1; j<=m;j++){
            System.out.print(firstNum+" ");
            nextNum=firstNum+secondNum;
            firstNum=secondNum;
            secondNum=nextNum;
        }
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println(start+" "+end);
        System.out.println("Took : " + ((end - start) / 1000));

        start = System.currentTimeMillis();

        int[] memo = new int[n+1];
        for(int i=1;i<=n;i++){
            System.out.print(fibonacci(i,memo)+" ");
        }

        end = System.currentTimeMillis();
        System.out.println();
        System.out.println(start+" "+end);
        System.out.println("Took : " + ((end - start) / 1000));

    }

    public static int fib(int n){
        if(n<=1) return n;
        return  fib(n-1)+fib(n-2);
    }

    public static int fibonacci(int n, int[] memo){
        if(memo[n] !=0){
            return memo[n];
        }
        if(n==1||n==2){
            return 1;
        } else {
            memo[n]=fibonacci(n-1, memo)+fibonacci(n-2, memo);
            return memo[n];
        }
    }
}
