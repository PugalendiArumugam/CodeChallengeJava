package LeetCode.Medium;

import java.util.Arrays;
/* 31 Next Permutation
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the
permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array
is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the
lowest possible order (i.e., sorted in ascending order).

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        np.nextPermutation(new int[]{1,2,3});  //1,3,2
        np.nextPermutation(new int[]{3,2,1});  //1,2,3
        np.nextPermutation(new int[]{1,1,5});  //1,5,1

    }

    public void nextPermutation1(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        int i= len -2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        int start = i + 1, end = len - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
        System.out.println(Arrays.toString(nums));
    }



    static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            System.out.println(Arrays.toString(nums));
            return ;
        }
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }
        reverse(nums, pivot + 1, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

}
