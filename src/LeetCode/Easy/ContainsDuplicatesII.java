package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/*
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

 */
public class ContainsDuplicatesII {
    public static void main(String[] args) {
        ContainsDuplicatesII cd = new ContainsDuplicatesII();
        int[] numArray1 = new int[]{1, 2, 3, 1};   //k=3  /true
        int[] numArray2 = new int[]{1, 0, 1, 1};   //k=1  /true
        int[] numArray3 = new int[]{1, 2, 3, 1, 2, 3};    //k=2  /false

        System.out.println(cd.containsNearbyDuplicate(numArray1, 3));
        System.out.println(cd.containsNearbyDuplicate(numArray2, 1));
        System.out.println(cd.containsNearbyDuplicate(numArray3, 2));

    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {       ///   This logic is time out
        boolean ConditionK = false;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    if(Math.abs(i-j)<=k){
                        ConditionK=true;
                    }
                }
            }
        }
        return ConditionK;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int dupIndex = map.getOrDefault(nums[i], -1000000);
            if (i - dupIndex <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
