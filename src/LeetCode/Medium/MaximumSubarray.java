package LeetCode.Medium;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums1  = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2  = new int[]{1};
        int[] nums3  = new int[]{5,4,-1,7,8};
        int[] nums4  = new int[]{-1,-14,11,7,-1,1,-1,-2};
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currentMax = Math.max(currentMax, 0) + nums[i];
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
}
