//*
//*
//*
//***** MEDIUM COMPLEXITY ************
//*
//* Given an integer array nums, return true if the triplet indices i<j<k in sequence
//* input : [1,2,3,4,5]
//* output: true
//* input : [5,4,3,2,1]
//* output : false
//* input : [2,1,5,0,4,6]
//* output: true  because 0,4,6 is triplet with 0<4<6

public class IncreasingTripletSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
//        int[] nums = new int[]{5,4,3,2,1};
//        int[] nums = new int[]{2,1,5,0,4,6};
        boolean result = solution(nums);
        System.out.println(result);
    }

    public static boolean solution(int[] nums) {
        int tripletCount =0;
        for (int i =1; i<=nums.length-1;i++){
            if (nums[i-1] < nums[i]){
                tripletCount++;
            } else {
                tripletCount=0;
            }
            if (tripletCount == 2) {
                return true;
            }
        }
        return false;
    }
}
