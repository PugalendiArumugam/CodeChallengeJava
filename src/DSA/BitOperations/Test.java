package DSA.BitOperations;

import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
//        highLowBit();
//        System.out.println(isPowerOfTwo(64));
        StringBuilder sb = new StringBuilder();
        SortedSet<String> set = new TreeSet<>();
        set.add("b");
        set.add("c");
        set.add("a");
        System.out.println(sb);
    }

    public static void highLowBit(){
        int high=0,low=0;
        for(int i=225;i>0;){
            high = Integer.highestOneBit(i);
            low = Integer.lowestOneBit(i);
            System.out.println("i:"+i+" high:"+high+" "+Integer.toBinaryString(i));
            System.out.println("i:"+i+" low:"+low+" "+Integer.toBinaryString(i));
//            System.out.println("i:"+i+" "+Integer.toBinaryString(i));
            i>>>=1;
        }
    }

    public static boolean isPowerOfTwo(int n){
        boolean result = (n & n - 1) == 0;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n-1));
        System.out.println(Integer.toBinaryString(n & n-1));
        return result;
    }
}
