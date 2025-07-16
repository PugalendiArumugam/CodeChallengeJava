package LeetCode.Easy;
/* counting 169  using Moore Voting Algorithm $$$$$$
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 10^4
-109 <= nums[i] <= 10^9
 */

public class MajorityElement {
    public static void main(String[] args) {
        int[] ia1 = new int[]{3,2,3};
        int[] ia2 = new int[]{2,2,1,1,1,2,2};
        int[] ia3 = new int[]{2,2,1,2,3,2,4,2,1,2,1,4};
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(ia1));
        System.out.println(me.majorityElement(ia2));
        System.out.println(me.majorityElement(ia3));
    }

    public int majorityElement(int[] nums) {
        int count=0;
        int prevnum=0;
        for(int num: nums){
            if(count==0){
                prevnum = num;
                count++;
            } else {
                if(num==prevnum){
                    count++;
                } else {
                    count--;
                }
            }
        }
        return prevnum;
    }
}
