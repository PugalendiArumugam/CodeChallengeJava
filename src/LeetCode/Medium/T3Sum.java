package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class T3Sum {
    public static void main(String[] args) {
        T3Sum s3= new T3Sum();
        System.out.println(s3.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(s3.threeSum(new int[]{0,1,1}));
        System.out.println(s3.threeSum(new int[]{0,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            int left=i+1, right =n-1;
            while(left< right)
            {
                if(nums[left]+nums[right]==-nums[i])
                {
                    List<Integer> t=new ArrayList<Integer>();
                    t.add(nums[i]);
                    t.add(nums[left]);
                    t.add(nums[right]);
                    result.add(t);
                    while(left+1< right &&  nums[left+1]==nums[left]) left++;
                    while(right -1>left &&  nums[right -1]==nums[right]) right--;
                    left++; right--;
                }
                else if(nums[left]+nums[right] < -nums[i]) left++;
                else right--;
            }
            while(i+1<n && nums[i+1]==nums[i]) i++;
        }
        return result;
    }
}
