package DSA.Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4,2,2,8,3,3,1};
        sort(arr);

    }

    public static void sort(int[] arr){
        if(arr == null || arr.length <=1) return;

        int min = arr[0];
        int max = arr[0];
        for (int num: arr){
            if (num<min) min = num;
            if (num>max) max = num;
        }

        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        // count the frequency of each element
        for (int num: arr){
            count[num - min]++;
        }
        System.out.println("count array"+Arrays.toString(count));

        //convert count to cumulative count
        for(int i=1;i<range;i++){
            count[i] += count[i-1];
        }
        System.out.println("count array with cumulative frequency()"+Arrays.toString(count));

        //Build output array (traverse backwards for STABILITY)
        for (int i = arr.length-1; i>=0; i--){
            int num = arr[i];
            int pos = count[num-min] - 1;
            output[pos] = num;
            count[num-min]--;
        }
        System.out.println("Before sorting"+ Arrays.toString(arr));
        System.out.println("Out put array "+Arrays.toString(output));

        // change the original array to sorted array
        int j =0;
        for(int i =arr.length-1;i>=0;i--){
            arr[j++]=output[i];
        }
        System.out.println("Out put array "+Arrays.toString(output));


    }
}
