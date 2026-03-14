package DSA.Sorting;
//O(n²)
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {64,34,25,12,22,11,5};
        for(int p: nums){
            System.out.print(p+" ");
        }
        System.out.println();
        int n = nums.length;
        for(int i=1;i<n;i++){
            int key = nums[i];
            int j=i-1;
            while (j>=0 && nums[j]>key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
        for(int p: nums){
            System.out.print(p+" ");
        }
    }
}
