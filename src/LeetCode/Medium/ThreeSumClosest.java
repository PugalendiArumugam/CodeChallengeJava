package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest sc= new ThreeSumClosest();
        System.out.println(sc.threeSumClosest(new int[]{-1,2,1,-4},1));   //2
        System.out.println(sc.threeSumClosest(new int[]{-1, 2, 2, 4},4));   //5
        System.out.println(sc.threeSumClosest(new int[]{0,0,0},1));   //0
    }



    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int result = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int left=i+1, right =n-1;
            while(left< right)
            {
                int temp = nums[left]+nums[right]+nums[i];

                if (Math.abs(temp - target) < diff) {
                    diff = Math.abs(temp - target);
                    result = temp;
                } else if(Math.abs(temp - target) == diff) {
                    result = Math.max(result, temp);
                }

                if (temp > target){
                    right--;
                } else{
                    left++;
                }
            }
        }
        return result;
    }
}
