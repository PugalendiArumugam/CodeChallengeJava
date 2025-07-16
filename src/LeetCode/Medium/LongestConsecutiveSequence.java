package LeetCode.Medium;

/*
128. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[]{100,4,200,1,3,2}));    //4
        System.out.println(lcs.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));   //9
        System.out.println(lcs.longestConsecutive(new int[]{1,0,1,2}));   //3
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int streakVal=0;
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (set.contains(num) && !set.contains(num-1)) {
                int curr = num;
                int count=0;

                while (set.contains(curr)) {
                    set.remove(curr);
                    curr += 1;
                    count += 1;
                }
                streakVal=Math.max(streakVal,count);
            }
        }
        return streakVal;
    }

    //this is faster than above
    public int longestConsecutive(int[] nums){
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int res = 1, cnt = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1])
                continue;

            if (nums[i] == nums[i - 1] + 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

}
