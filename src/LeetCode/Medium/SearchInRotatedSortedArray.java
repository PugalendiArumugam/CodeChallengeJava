package LeetCode.Medium;

import java.util.HashMap;

/*
33. Search in Rotated Sorted Array
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray ssa = new SearchInRotatedSortedArray();
        System.out.println(ssa.search(new int[]{4,5,6,7,0,1,2},0));    //4
        System.out.println(ssa.search(new int[]{4,5,6,7,0,1,2},3));    //-1
        System.out.println(ssa.search(new int[]{1},0));            //-1
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int start=0;
        int end=n-1;
        while(start<end){
            int md= (start+end)/2;
            if(nums[0] <=nums[md]){
                if(nums[0]<=target && target<=nums[md]){
                    end=md;
                } else {
                    start=md+1;
                }
            } else {
                if(nums[md]<target && target<=nums[nums.length-1]){
                    start=md+1;
                } else {
                    end=md;
                }
            }
        }
        return nums[start] == target ? start : -1;
    }

    // using the hashmap, but it is slower than binary search.  This is not binary search
    public int search2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        return -1;
    }
}
