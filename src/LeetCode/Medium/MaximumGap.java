package LeetCode.Medium;

import java.util.Arrays;

/*
164. Maximum Gap
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

$$$$ You must write an algorithm that runs in linear time and uses linear extra space. $$$$ O(n)

Example 1:
Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

Example 2:
Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

 */
public class MaximumGap {

    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        System.out.println(mg.maximumGap(new int[]{3,6,9,1}));
        System.out.println(mg.maximumGap(new int[]{10}));
    }


    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int v : nums) {
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        int size = Math.max(1, (max - min) / (n - 1));
        int count = (max - min) / size + 1;
        int[][] buckets = new int[count][2];
        for (int[] bucket : buckets) {
            bucket[0] = Integer.MAX_VALUE;
            bucket[1] = -Integer.MAX_VALUE;
        }
        for (int v : nums) {
            int idx = (v - min) / size;
            buckets[idx][0] = Math.min(buckets[idx][0], v);
            buckets[idx][1] = Math.max(buckets[idx][1], v);
        }
        int prev = Integer.MAX_VALUE;
        int result=0;
        for (int[] bucket : buckets) {
            if (bucket[0] > bucket[1]) {
                continue;
            }
            result = Math.max(result, bucket[0] - prev);
            prev = bucket[1];
        }
        return result;
    }


    // fastest algorithm
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        // Step 1: Find global min and max
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0; // All elements are the same

        // Step 2: Initialize buckets
        int bucketSize = (int) Math.max(1, Math.ceil((double)(max - min) / (n - 1)));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Step 3: Place each number in a bucket
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            bucketUsed[idx] = true;
        }

        // Step 4: Scan through buckets to find max gap
        int maxGap = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!bucketUsed[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
}
