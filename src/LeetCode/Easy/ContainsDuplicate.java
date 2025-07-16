package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

/* 217
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(cd.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(cd.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int num:nums){
            if(!map.add(num)) {
                return true;
            }
        }
        return false;
    }

    // fastest algorithm
    public boolean containsDuplicate1(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<min || nums[i]>max){
                min=Math.min(min,nums[i]);
                max=Math.max(max,nums[i]);
                continue;
            }
            for (int j=0;j<i;j++){
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // fastest algorithm
    public static volatile boolean b;
    static {
        int[] t = {1,2,3,4,5,6,7,8,9,9};
        for (int i  = 0; i < 200; ++i) {
            b = containsDuplicate2(t);
        }
    }
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> s = new HashSet<>(nums.length * 2);
        for (int x: nums) {
            if (!s.add(x)) {
                return true;
            }
        }
        return false;
    }

}
