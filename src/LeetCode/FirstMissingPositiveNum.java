package LeetCode;
/*

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 */


public class FirstMissingPositiveNum {
    public static void main(String[] args) {
//        int [] nums = new int[]{1,2,0};
//        int [] nums = new int[]{1,2,3};
        int [] nums = new int[]{2,4,4};
//        int [] nums = new int[]{3,4,-1,1};
//        int [] nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
//        int len = nums.length;
//        for(int i =0; i<len; ++i){
//            while(nums[i]>0 && nums[i] <=len && nums[i] !=nums[nums[i]-1]){
//                swapposition(nums,i,nums[i]-1);
//            }
//        }
//        for(int i =0; i<len;++i){
//            if(nums[i]!=i+1) return i+1;       // because the loops starts from 0;
//        }
//        return len+1;   // incase all values are correst line [1,2,3,4] then 5 is first missing +ve number


        int c=0;
        int n=nums.length;
        int ans[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0&&nums[i]<=n)
                ans[nums[i]]=1;
        }
        for(int i=1;i<=n;i++)
        {
            if(ans[i]==0)
                return i;
        }
        if(n==1&&(nums[0]==1||nums[0]==0))
            return nums[0]+1;
        return n+1;



    }

    private static void swapposition(int[] nums, int first, int second){

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

    }

}
