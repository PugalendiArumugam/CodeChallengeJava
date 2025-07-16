package LeetCode.Medium;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 */

import java.util.Arrays;

public class FindFirstAndLastElement {
    public static void main(String[] args) {
        int[] ia = new int[]{1,2,3,4,5,9,9,9,9,10};   // target 8, result [3,4]
        int[] ia1 = new int[]{5,7,7,8,8,10};   // target 6, result [-1,-1]
        int[] ia2 = new int[]{};   // target 4, result [-1,-1]
        int[] ia3 = new int[]{7,8,8,8,8,8,8,8,8,8,8,9};   // target 8 and 7, result [3,4]
        int[] ia4 = new int[]{-999985131,-999953607,-999953607,-999915742,-999883817,-999849817,-999822901,-999815377,-999810801,-68594,-49967,20394,114012,999969829,999973689,999975494};
        // target -999953607, result [1,2]
        int[] ia5 = new int[]{2,2};   // target 3, result [-1,-1]
        int[] ia6 = new int[]{-3,-2,-1};   // target 0, result [-1,-1]
//        System.out.println(Arrays.toString(searchRange(ia,9)));
//        System.out.println(Arrays.toString(searchRange(ia1,6)));
//        System.out.println(Arrays.toString(searchRange(ia2,4)));
//        System.out.println(Arrays.toString(searchRange(ia3,7)));
//        System.out.println(Arrays.toString(searchRange(ia3,8)));
//        System.out.println(Arrays.toString(searchRange(ia4,-999953607)));
        System.out.println(Arrays.toString(searchRange(ia5,3)));
        System.out.println(Arrays.toString(searchRange(ia6,0)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
           return new int[]{-1,-1};
        }
        if(nums.length==1){
            if(nums[0]==target) {
                return new int[]{0,0};
            }
            return new int[]{-1,-1};
        }

        int left = FindLeftMost(nums,target);

        // if left is beyond boundary then the target is not available
        if(left>nums.length-1){
            return new int[]{-1,-1};
        }

        // if the left most index is not on the target. that means the value is not present
        if(nums[left]!=target){
            return new int[]{-1,-1};
        }
        int right=left;
        while (right+1 < nums.length) {
            if(nums[right+1]==target)
            {
                right++;
            } else break;
        }
        return new int[]{left,right};
    }

    public static int FindLeftMost(int[] nums, int target){
        int left =0;
        int right = nums.length;
        while (left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target){
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}
