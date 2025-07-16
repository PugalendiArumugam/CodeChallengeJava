package LeetCode.Medium;

/*
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 0

 */

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println("0:"+cp.countPrimes(0));
        System.out.println("2:"+cp.countPrimes(2));
        System.out.println("5:"+cp.countPrimes(5));
        System.out.println("6:"+cp.countPrimes(6));
        System.out.println("8:"+cp.countPrimes(8));
        System.out.println("17:"+cp.countPrimes(17));
        System.out.println("26:"+cp.countPrimes(26));
        System.out.println("100:"+cp.countPrimes(100));
        System.out.println("101:"+cp.countPrimes(101));
        System.out.println("500:"+cp.countPrimes(500));
        System.out.println("1000:"+cp.countPrimes(1000));
        System.out.println("2000:"+cp.countPrimes(2000));
        System.out.println("5000:"+cp.countPrimes(5000));
        System.out.println("9000:"+cp.countPrimes(9000));
        System.out.println("29000:"+cp.countPrimes(29000));
    }

    public int countPrimes(int n) {
////original
//        int result = 0;
//        boolean[] primeTable = new boolean[n];
//        Arrays.fill(primeTable,true);
//        for(int i=2; i< n;i++){
//            if(primeTable[i]) result++;
//            for(int j=i*2;j<n;j+=i){
//                primeTable[j]=false;
//            }
//        }
//        return result;


        if(n<=2){
            return 0;
        }
        int result = 0;
        boolean[] primeTable = new boolean[n];
        Arrays.fill(primeTable,true);
        for(int i=2; i*i< n;i++){
            if(primeTable[i]) {
                for (int j = i * i; j < n; j += i) {
                    primeTable[j] = false;
                }
            }
        }
        for(int i=2;i<primeTable.length;i++){
            if(primeTable[i]) result++;
        }
        return result;



// The following logic is more faster than the above one.  because it is reverse.
// fill in true all the hit cases and count the false
//        if(n<=2){
//            return 0;
//        }
//        boolean[] primes = new boolean[n+1];
//        for(int i = 2;i * i <= n;i++){
//            if(!primes[i]){
//                for(int j = i*i; j<= n; j+=i){
//                    primes[j] = true;
//                }
//            }
//        }
//        int count = 0;
//        for(int i =2; i < n; i++){
//            if(!primes[i]){
//                count++;
//            }
//        }
//        return count;
//

    }

}
