package DSA.Sorting;
//O(n²)
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {64,34,25,12,22,11,5,90,11,25};
        for (int i: nums){
            System.out.print(i+" ");
        }
        System.out.println();
        int len = nums.length;
        for(int i =0;i<len-1;i++){
            int minIndex = i;
            for(int j=i+1;j<len;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }

        for ( int i: nums){
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
