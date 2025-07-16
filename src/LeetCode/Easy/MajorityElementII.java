package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        MajorityElementII me2 = new MajorityElementII();
        int[] ia1 = new int[]{2,4,2,2,4,2,1,4};
        int[] ia2 = new int[]{3,2,3};  //3
        int[] ia3 = new int[]{1,1,2,2,3,3};  //1
        int[] ia4 = new int[]{1,2};  //1

        System.out.println(me2.majorityElement(ia1));
        System.out.println(me2.majorityElement(ia2));
        System.out.println(me2.majorityElement(ia3));
        System.out.println(me2.majorityElement(ia4));
    }

    public List<Integer> majorityElement(int[] nums) {
        int big1 = 0, big2 = 0;
        int counter1 = 0, counter2 = 0;
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (num == big1) {
                counter1++;
            } else if (num == big2) {
                counter2++;
            } else if (counter1 == 0) {
                big1 = num;
                counter1 = 1;
            } else if (counter2 == 0) {
                big2 = num;
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0;
        counter2 = 0;

        for (int num : nums) {
            if (num == big1) {
                counter1++;
            } else if (num == big2) {
                counter2++;
            }
        }

        if (counter1 > nums.length / 3) {
            result.add(big1);
        }
        if (counter2 > nums.length / 3) {
            result.add(big2);
        }

        return result;
    }
}
