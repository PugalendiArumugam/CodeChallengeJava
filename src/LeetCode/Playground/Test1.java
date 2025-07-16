package LeetCode.Playground;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test1 {
    // Bit manipulation
    public static void main(String[] args) {

    int n=55;
    int i=0;
    System.out.println(Integer.toBinaryString(n)+" "+n+" i th bit:"+i);
    int result = setBit(n,i);
    System.out.println(Integer.toBinaryString(result)+" "+result);



//        int answer = 0;
//        int[] nums = new int[]{2,2,5,3,3,5,9};
//
//        // Loop over each value in the array 'nums'
//        for (int value : nums) {
//            // Apply XOR operation between the 'answer' and the 'value'
//            // Since XOR of a number with itself is 0 and with 0 is the number itself,
//            // this will cancel out all pairs leaving the single number alone
//            System.out.println(Integer.toBinaryString(answer)+" "+answer);
//            System.out.println(Integer.toBinaryString(value)+" "+value);
//            answer ^= value;
//            System.out.println(Integer.toBinaryString(answer)+" "+answer);
//            System.out.println("====================");
//        }
//        System.out.println("Ans"+answer);




//        String s="ab";
//        System.out.println(s.repeat(5));
//
//        int high = Integer.highestOneBit(17);
//        //System.out.println(high);
//
//        long exp = 11,temp=0;

//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.toBinaryString(16));
//        int minval1 = Integer.MIN_VALUE+1;
//        int minval2 = -Integer.MAX_VALUE;
//        System.out.println("Min value1 and Min value 2");
//        System.out.println(Integer.toBinaryString(minval1));
//        System.out.println(Integer.toBinaryString(minval2));
//        int test = 4 + 16 >>> 1;
//        System.out.println(Integer.toBinaryString(test)+" Int val"+test);

//  P R I O R I T Y  Q U E U E

//        Queue<Integer> pq = new LinkedList<>();
//        Queue<Integer> pq = new PriorityQueue<>();
//
//        // Adding items to the pQueue using add()
//        pq.add(12);
//        pq.add(20);
//        pq.add(21);
//        pq.add(23);
//        pq.add(25);
//        pq.add(11);
//        pq.add(13);
//        pq.add(10);
//        System.out.println(pq);
//        int n=pq.size();
//        for(int i=0;i<n;i++){
//            System.out.println(pq.poll());
//        }

//        System.out.println("1  "+Integer.toBinaryString(1));
//        System.out.println("2  "+Integer.toBinaryString(2));
//        System.out.println("3  "+Integer.toBinaryString(3));
//        System.out.println("4  "+Integer.toBinaryString(4));
//        System.out.println("5  "+Integer.toBinaryString(5));
//        System.out.println("6  "+Integer.toBinaryString(6));
//        System.out.println("7  "+Integer.toBinaryString(7));
//        System.out.println("8  "+Integer.toBinaryString(8));
//        System.out.println("9  "+Integer.toBinaryString(9));
//        System.out.println("10 "+Integer.toBinaryString(10));
//        System.out.println("11 "+Integer.toBinaryString(11));
//        System.out.println("12 "+Integer.toBinaryString(12));
//        System.out.println("13 "+Integer.toBinaryString(13));
//        System.out.println("14 "+Integer.toBinaryString(14));
//        System.out.println("15 "+Integer.toBinaryString(15));
//        System.out.println("---------------------");
//        System.out.println(Integer.toBinaryString(9));
//        System.out.println(Integer.toBinaryString(1));
//        int test = 9 & 1;
//        System.out.println(Integer.toBinaryString(test)+" Int val"+test);
//
//        System.out.println(test);
//        test = 110 & 100;
//        System.out.println(test);
//
//        for(int i =0;i<1;i++){
//            System.out.println("temp before:"+temp);
//            System.out.println(Long.toBinaryString(exp));
//            temp = exp & 11;
//            System.out.println("temp after:"+temp);
//            exp >>= 1;
//            System.out.println(Long.toBinaryString(exp));
//            System.out.println("------------------");
//        }

//        int leadingZeros = Integer.numberOfLeadingZeros(-17);
//        System.out.println(leadingZeros);

//        int reversedNum = Integer.reverse(17);
//        System.out.println(reversedNum);    //-2013265920
//        System.out.println(Integer.toBinaryString(reversedNum));
//
//        int reversedNum2 = Integer.reverse(16);
//        System.out.println(reversedNum2);    //134217728
//
//        System.out.println("\nBitwise compliment");
//        int number = 35, result;
//        // bitwise complement of 35
//        result = ~number;
//        System.out.println(Integer.toBinaryString(number));
//        System.out.println(result);    // prints -36
//        System.out.println(Integer.toBinaryString(result));
//        result=~result;
//        System.out.println(Integer.toBinaryString(result));
//
//        System.out.println("\nBit shift operators");
//        int number1 = Integer.MAX_VALUE;
//        int number1 = Integer.MIN_VALUE;
//        // 2 bit left shift operation
//        int result1 = number1 >>> 1;
//        System.out.println(Integer.toBinaryString(number1));
//        System.out.println("Number "+number1+" Result "+result1);    // prints 8
//        System.out.println(Integer.toBinaryString(result1));
//        System.out.println();
//        String smax = Integer.toBinaryString(Integer.MAX_VALUE);
//        String smin = Integer.toBinaryString(Integer.MIN_VALUE);
//        System.out.println("Max Value "+Integer.MAX_VALUE+"   "+smax+" Size ="+smax.length() );
//        System.out.println("Min Value "+Integer.MIN_VALUE+" "+smin+" Size ="+smin.length());
    }


    static boolean getBit(int num, int i)
    {

        // Return true if the ith bit is
        // set. Otherwise return false
        return ((num & (1 << i)) != 0);
    }

    // Function to set the ith bit of the
// given number num
    static int setBit(int num, int i)
    {
        System.out.println(Integer.toBinaryString(num));
        // Sets the ith bit and return
        // the updated value
        return num | (1 << i);
    }

    // Function to clear the ith bit of
// the given number num
    static int clearBit(int num, int i)
    {

        // Create the mask for the ith
        // bit unset
        int mask = ~(1 << i);

        // Return the updated value
        return num & mask;
    }

}
