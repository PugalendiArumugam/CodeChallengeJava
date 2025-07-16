//*
//***** SIMPLE COMPLEXITY ************
//*
//* Determine whether the largest number in the array is at least twice as much as
//* every other number in the array. If it is return the index of the largest
//* element. or return -1.
//* input : [3,6,1,0]
//* output 1
//* explanation: 6 is the largest number twice of remaining numbers are not great than
//* 6.
//* input : [1,2,3,4]
//* output :-1
//* explanation : 4 is the largest number but the twice of one of the remaining number 3 is
//* 6 which is greater than 4. Hence -1
//*
//* logic : find the max and second max number and if the twice of second max is greater
//* than max number then return -1 else send the index of the max number
//*
public class LargestNumberTwiceofOthers {
    public static void main(String[] args) {
//        int[] nums = new int[] {3,6,1,0};
//        int[] nums = new int[] {1,2,3,4};
        int[] nums = new int[] {1,2,3,4,10,19};
        int result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums){
        int max =0;
        int smax =0;
        int maxi = 0;
        for (int i =0; i<=nums.length-1;i++){
            if(nums[i]>max) {
                smax = max;
                max = nums[i];
                maxi =i;
            } else if (nums[i]>smax){
                smax =nums[i];
            }
        }
        if (smax*2 <= max){
            return maxi;
        }
        return -1;
    }
}
