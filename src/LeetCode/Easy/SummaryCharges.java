package LeetCode.Easy;
/*  Summary Ranges
Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

 */

import java.util.ArrayList;
import java.util.List;

public class SummaryCharges {
    public static void main(String[] args) {
        SummaryCharges sc = new SummaryCharges();
        System.out.println(sc.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));   //["0->2","4->5","7"]
        System.out.println(sc.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9, 11})); //["0","2->4","6","8->9","11"]
        System.out.println(sc.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})); //["0","2->4","6","8->9"]
        System.out.println(sc.summaryRanges(new int[]{0})); //["0"]

    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length < 1) return result;
        int counter = 1;
        result.add("" + nums[0]);
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                if (i == nums.length - 1) {
                    result.set(result.size() - 1, result.get(result.size() - 1) + "->" + nums[i]);
                }
                counter++;
            } else {
                if (counter == 1) {
                    result.add("" + nums[i]);
                } else {
                    result.set(result.size() - 1, result.get(result.size() - 1) + "->" + nums[i - 1]);
                    result.add("" + nums[i]);
                }
                counter = 1;
            }
        }
        return result;
    }


    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length < 1) return result;
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            result.add(rangeCreate(nums, i, j));
        }
        return result;
    }

    private String rangeCreate(int[] nums, int start, int end) {
        return start == end ? Integer.toString(nums[start]) : String.format("%d->%d", nums[start], nums[end]);
    }

}
