//*
//* square the input numbers and sort the order order
//* [-4,-1,-0.3,10] => [16,1,0,9,100]
//* output : [0,1,9,16,100]
//*

import java.util.Arrays;

public class squareSortArray {
    public static void main(String[] args) {
        int[] nums = new int[] {-4,-1,0,3,10};
        int[] result = SquareAndSort(nums);
        System.out.println(Arrays.toString(result));

    }

    public static int[] SquareAndSort(int[] nums){
        int[] resultArray = new int[nums.length];
        int start = 0;
        int end = nums.length-1;
        int ptr = resultArray.length-1;
        int counter =0;
        while(start<=end){
            counter++;
            int ss = nums[start] * nums[start];
            int es = nums[end] * nums[end];

            if(ss > es){
                resultArray[ptr] = ss;
                start++;
            } else {
                resultArray[ptr] = es;
                end--;
            }
            ptr--;
        }
        System.out.println(counter);
        return resultArray;
    }

}
