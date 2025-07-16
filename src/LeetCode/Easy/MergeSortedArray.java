package LeetCode.Easy;


/*
Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        msa.merge(new int[]{1,2,3,0,0,0},3, new int[]{2,5,6}, 3);
        msa.merge(new int[]{1},1, new int[]{}, 0);
        msa.merge(new int[]{0},0, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length!=m+n) return;
        int l = m-1;
        int r = n-1;
        int fullIndex = m+n-1;
        while(r>=0){                           // right over - come out
            if(l<0 || nums1[l]<=nums2[r]){     // left is over - keep filling from right
                nums1[fullIndex] = nums2[r];
                r--;
            } else {
                nums1[fullIndex] = nums1[l];
                l--;
            }
            fullIndex--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
