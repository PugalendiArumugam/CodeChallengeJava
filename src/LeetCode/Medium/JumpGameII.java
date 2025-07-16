package LeetCode.Medium;
/* 45 Jump Game II
Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

 */

public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{2,3,1,1,4}));
        System.out.println(jg.jump(new int[]{2,3,0,1,4}));
        System.out.println(jg.jump(new int[]{2,3,0,1,4,5,1,1,1,1,1}));
    }

    public int jump(int[] nums) {
        int ans = 0;
        int longest = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            longest = Math.max(longest, i + nums[i]);
            if (i == end) {
                ans++;
                end = longest;
            }
        }
        return ans;
    }
}
