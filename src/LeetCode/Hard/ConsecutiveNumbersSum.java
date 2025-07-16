package LeetCode.Hard;
/*
Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.

Example 1:
Input: n = 5
Output: 2
Explanation: 5 = 2 + 3

Example 2:
Input: n = 9
Output: 3
Explanation: 9 = 4 + 5 = 2 + 3 + 4

Example 3:
Input: n = 15
Output: 4
Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        ConsecutiveNumbersSum cns = new ConsecutiveNumbersSum();
        System.out.println(cns.consecutiveNumbersSum3(15));
//        System.out.println(cns.consecutiveNumbersSum(5));
//        System.out.println(cns.consecutiveNumbersSum(15));
//        System.out.println(cns.consecutiveNumbersSum(16));
//        System.out.println(cns.consecutiveNumbersSum(17));
//        System.out.println(cns.consecutiveNumbersSum(18));
//        System.out.println(cns.consecutiveNumbersSum(23));
    }

    public int consecutiveNumbersSum(int n) {
        System.out.println("For the number ==> "+n);
        if (n==0) return 0;
        int count =0;
        for(int k=1; 2*n > k*(k-1);k++ ){
            int num = n -(k*(k-1)/2);
            System.out.println("K:"+k+"num:"+num+"count:"+count);
            if(num%k==0) count++;
        }
        return count;
    }

    // Other best solutions.

    public int consecutiveNumbersSum1(int N) {
        int res = 1, count;
        while (N % 2 == 0) N /= 2;
        for (int i = 3; i * i <= N; res *= count + 1, i += 2)
            for (count = 0; N % i == 0; N /= i, count++);
        return N == 1 ? res : res * 2;
    }

    public int consecutiveNumbersSum2(int n) {
        int count = 0;
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                if((i & 1) > 0){
                    count++;
                }
                int f = n/i;
                if(f != i && (f & 1) > 0){
                    count++;
                }
            }
        }
        return count;
    }

    public int consecutiveNumbersSum3(int n){
        int count = 0, m = 0;
        for(int i = 1; ; i++){
            int remaining = n - m;
            if(remaining <= 0){
                break;
            }
            if(remaining % i == 0){
                count++;
            }
            m += i;
        }
        return count;
    }

    public int consecutiveNumbersSum0(int N) {
        int i = 1, count=0;
        while (N > 0) {
            N -= i;
            if(N%i==0) count++;
            i++;
        }
        return count;
    }


}
