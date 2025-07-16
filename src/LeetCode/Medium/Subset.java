package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;
/* 78 Subset
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */
public class Subset {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> curr = new ArrayList<>();
    private int[] globalNums;

    public static void main(String[] args) {
        Subset ss = new Subset();
        System.out.println(ss.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.globalNums = nums;
        createSubset(0);
        return res;
    }

    public void createSubset(int idx){
        if(idx==globalNums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        createSubset(idx+1);
        curr.add(globalNums[idx]);
        createSubset(idx+1);
        curr.remove(curr.size()-1);
    }


    // fastest
    public List<List<Integer>> subsets1(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i+1, subset);
            subset.remove(subset.size() - 1);
        }
    }

}
