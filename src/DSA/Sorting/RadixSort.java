package DSA.Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170,45,75,90,802,24,2,66};
        System.out.println("Orignl array "+ Arrays.toString(arr));
        rSort(arr);
        System.out.println("Sorted Array "+Arrays.toString(arr));
    }

    private static void rSort(int[] arr) {
        if (arr==null || arr.length<=1) return;

        int max = arr[0];
        for(int num: arr){
            if(num>max) max=num;
        }

        // Perform stable counting sort for each digit place
        // exp=1 10 100 etc...
        for(int exp=1; max/exp>0; exp*=10){
            countingSortDigitwise(arr,exp);
        }

    }

    private static void countingSortDigitwise(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];  // base 10 we have 10 slots starting 0.

        // count frequency of each digit at current place
        for(int i=0; i<n; i++){
            int digit = (arr[i]/exp) % 10;
            count[digit]++;
        }

        // convert cumulative counts to determines final positions
        for(int i=1; i<10; i++){
            count[i] += count[i-1];
        }

        // build output array
        for(int i= n-1; i>=0; i--){
            int digit = (arr[i]/exp) % 10;
            output[count[digit]-1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output,0, arr, 0,n);
    }
}
