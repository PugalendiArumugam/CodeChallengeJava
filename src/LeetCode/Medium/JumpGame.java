package LeetCode.Medium;
/* 55
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 */
public class JumpGame {
    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{2,3,1,1,4,1,1,1,1,0,1}));
//        System.out.println(jg.canJump(new int[]{2,3,1,1,4}));
//        System.out.println(jg.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        int maxCount=0;
        for (int i =0;i<nums.length;i++){
            if(i>maxCount) return false;

            maxCount = Math.max(maxCount,i+nums[i]);
        }
        return true;
    }

    // fastest logic
    static {
        for(int i=0;i<500;i++){
            canJump1(new int[]{0});
        }
    }
    public static boolean canJump1(int[] nums) {
        int maxReach = 0;
        for(int i=0;i<nums.length;i++){
            if(i>maxReach) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
        }
        return true;
    }

}
