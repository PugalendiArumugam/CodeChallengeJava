package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*18 Four sum

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */
public class T4Sum {
    public static void main(String[] args) {
        T4Sum s4 = new T4Sum();
        System.out.println(s4.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(s4.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                while (l < r) {
                    long curr = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (curr < target) {
                        l++;
                    } else if (curr > target) {
                        r--;
                    } else {        // target equal case
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        ++l;
                        --r;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        // Number of elements in the input array
        int arraySize = nums.length;
        // Container to store the resulting quadruplets
        List<List<Integer>> quadrupletsList = new ArrayList<>();
        // If there are fewer than 4 elements, no quadruplet can be formed
        if (arraySize < 4) {
            return quadrupletsList;
        }
        // Sort the input array to enable the two-pointer approach
        Arrays.sort(nums);
        // Iterate over the array with the first pointer
        for (int i = 0; i < arraySize - 3; ++i) {
            // Skip duplicate values to ensure uniqueness of the quadruplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < arraySize - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int leftPointer = j + 1, rightPointer = arraySize - 1;
                while (leftPointer < rightPointer) {
                    long currentSum = (long) nums[i] + nums[j] + nums[leftPointer] + nums[rightPointer];
                    if (currentSum < target) {
                        ++leftPointer;
                    } else if (currentSum > target) {
                        --rightPointer;
                    }
                    // If the sum is equal to the target, a quadruplet is found
                    else {
                        quadrupletsList.add(Arrays.asList(nums[i], nums[j], nums[leftPointer], nums[rightPointer]));
                        // Move the left pointer to the right and the right pointer to the left
                        leftPointer++;
                        rightPointer--;
                        // Skip over any duplicate values for the third and fourth numbers in the quadruplet
                        while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer - 1]) {
                            leftPointer++;
                        }
                        while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer + 1]) {
                            rightPointer--;
                        }
                    }
                }
            }
        }
        return quadrupletsList;
    }
}
