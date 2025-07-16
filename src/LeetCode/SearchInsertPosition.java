package LeetCode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        int result = solution(nums,target);
        System.out.println(result);
    }

    public static int solution(int[] nums, int target) {
        int len = nums.length;
        int i = 0;
        for (; i < len; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return i;
    }
}
