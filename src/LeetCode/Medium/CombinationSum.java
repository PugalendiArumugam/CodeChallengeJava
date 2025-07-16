package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 */

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
//        int[] ia1 = new int[]{2,3,6,7}; // target 7
        int[] ia2 = new int[]{2,3,5};   // target 8
        int[] ia3 = new int[]{2};       // target 1
        cs.result = cs.combinationSum(ia2,8);
//        cs.result = cs.combinationSum(ia2,8);
//        cs.result = cs.combinationSum(ia3,1);
        System.out.println(Arrays.toString(cs.result.toArray()));
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int[] numbers;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        numbers = candidates;
        backtrack(0, target);
        return result;
    }


    private void backtrack(int startIndex, int remainingSum) {
        System.out.println(curr);
        System.out.println("StartIndex:"+startIndex+" RemainingSum:"+remainingSum);
        if (remainingSum == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (startIndex >= numbers.length || remainingSum < numbers[startIndex]) {
            return;
        }
        System.out.println("+++ Num value:"+numbers[startIndex]);

        backtrack(startIndex + 1, remainingSum);

        curr.add(numbers[startIndex]);

        backtrack(startIndex, remainingSum - numbers[startIndex]);

        curr.remove(curr.size() - 1);
    }

// BEST SOLUTION
//
//    List<List<Integer>> result;
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        result = new ArrayList<>();
//        // Arrays.sort(candidates);
//        helper(candidates, target, 0, 0, new ArrayList<>());
//        return result;
//    }
//
//    private void helper(int[] candidates, int target, int idx, int currSum, List<Integer> currCandidates) {
//        if (currSum == target) {
//            result.add(new ArrayList<>(currCandidates));
//            return;
//        }
//
//        if (idx >= candidates.length)
//            return;
//
//        for (int i = idx; i < candidates.length; i++) {
//            if (currSum + candidates[i] > target)
//                continue;
//            currCandidates.add(candidates[i]);
//            helper(candidates, target, i, currSum + candidates[i], currCandidates);
//            currCandidates.remove(currCandidates.size() - 1);
//
//        }
//
//    }


}
