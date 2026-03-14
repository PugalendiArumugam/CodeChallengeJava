package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subset78 {

    // List to store all subsets
    private List<List<Integer>> result = new ArrayList<>();
    // Temporary list to build current subset
    private List<Integer> currentSubset = new ArrayList<>();
    // Input array reference
    private int[] nums;

    /**
     * Generate all possible subsets of the given array
     * @param nums Input array of integers
     * @return List containing all possible subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0);
        return result;
    }

    /**
     * Recursive backtracking function to generate subsets
     * @param index Current index in the nums array
     */
    private void backtrack(int index) {
        // Base case: reached end of array, add current subset to result
        if (index == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        // Choice 1: Exclude current element from subset
        backtrack(index + 1);

        // Choice 2: Include current element in subset
        currentSubset.add(nums[index]);
        backtrack(index + 1);

        // Backtrack: remove the element we just added
        currentSubset.remove(currentSubset.size() - 1);
    }


    public static void main(String[] args) {

        Subset78 s = new Subset78();
        System.out.println(s.subsets(new int[]{1,2,3}));

    }
}
