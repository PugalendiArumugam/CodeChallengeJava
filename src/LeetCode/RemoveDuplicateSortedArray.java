package LeetCode;

import java.util.Arrays;

public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums = new int[]{1,1,2};
//        int[] nums = new int[]{1,1,1};
//        int[] nums = new int[]{1,2,3};
        int result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums){
        int len = nums.length;
        if (len==0) return 0;
//        if (len==1) return 1;
        int p2=1;     // index pointer
        int result=0;
        for (; p2<len; p2++){
            if(nums[p2]!=nums[result]) {
                nums[++result] = nums[p2];
            }
        }
//        for(;p1<len;p1++){
//            nums[p1]=0;
//        }
        System.out.println(Arrays.toString(nums));
        return result+1;

        // shortest algorithm

//        int k=0;
//        if(nums.length==0)
//            return 0;
//
//        for(int i=1;i<nums.length;i++)
//        {
//            if(nums[i]!=nums[k])
//                nums[++k]=nums[i];
//        }
//        return k+1;



    }
}
