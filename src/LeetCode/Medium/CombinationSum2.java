package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 cs2 = new CombinationSum2();
        int[] ia2 = new int[]{2,3,6,7};   // target 8
        cs2.result = cs2.combinationSum(ia2,7);
        System.out.println(Arrays.toString(cs2.result.toArray()));
    }

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int idx, int currSum, List<Integer> currCandidates) {

//        System.out.println("Top "+currCandidates+" index:"+idx+" CurSum:"+currSum);

        if (currSum == target) {
            result.add(new ArrayList<>(currCandidates));
            return;
        }

        if (idx >= candidates.length)
            return;

//        System.out.println("$$ After index Check $$"+currCandidates+" index:"+idx+" CurSum:"+currSum);

        for (int i = idx; i < candidates.length; i++) {
            if (currSum + candidates[i] > target){
//                System.out.println("Skip"+i);
                continue;
            }
            currCandidates.add(candidates[i]);

//            System.out.println("** Before helper called  **"+currCandidates+" index:"+idx+" CurSum:"+currSum);

            helper(candidates, target, i, currSum + candidates[i], currCandidates);

//            System.out.println("** After helper called **"+currCandidates+" index:"+idx+" CurSum:"+currSum);

            currCandidates.remove(currCandidates.size() - 1);
        }

//        System.out.println("** Bottom Out of helper method **"+currCandidates+" index:"+idx+" CurSum:"+currSum);
//        System.out.println("------------------");
//        System.out.println();
//
    }


}
