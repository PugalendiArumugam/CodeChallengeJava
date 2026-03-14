package DSA.Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {64,34,25,12,22,11,5,7,3};
        for(int p: nums){
            System.out.print(p+" ");
        }
        System.out.println();

        mergeSort(nums, 0, nums.length-1);

        for(int p:nums){
            System.out.print(p+" ");
        }
        System.out.println();

    }

    static void mergeSort(int[]arr, int left, int right){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(arr, left,mid);
            mergeSort(arr,mid+1, right);

            merge(arr,left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
