package LeetCode;

// input : [0,1,2,2,3,0,4,2]. val = 2
// output k=5
// explanation : leaving val 2 the result array is [0,1,3,0,4] the no of element is 5 result
//
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2}; // output expect is 5
        int val =2;

        System.out.println(solution(nums,val));

    }

    public static int solution(int[] nums, int val){
        int ptr = 0;
        for (int i =0; i<nums.length; i++){
            if(nums[i] !=val ){
//                nums[ptr] = nums[i];
                ptr++;
            }
        }
        return ptr;
    }
}
