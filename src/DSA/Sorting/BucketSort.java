package DSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BucketSort {
    public static void main(String[] args) {
        double[] arr = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
        System.out.println("Original Array "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array "+Arrays.toString(arr));
    }

    private static void sort(double[] arr) {
        if(arr==null || arr.length<=1) return;
        int n = arr.length;
        int k = n;

        // find min and max;
        double min = arr[0];
        double max = arr[0];

        for (double num:arr){
            if(num<min) min = num;
            if(num>max) max = num;
        }

        if (min == max) return;   // if min max are equal that means all the numbers are same

        // initialize empty buckets
        List<List<Double>> buckets = new ArrayList<>(k);

        // create empty buckets
        for(int i=0; i<k; i++){
            buckets.add(new ArrayList<>());
        }

        // Core =  Distribute elements in to buckets
        double range = max - min;
        for (double val: arr){
            int bucketIndex = (int) Math.floor((val - min) / range * k);
//            double temp = (val - min) / range * k;
            if(bucketIndex == k) bucketIndex--;
            buckets.get(bucketIndex).add(val);
        }

        // sort each bucket using insertion sort
        for(List<Double> bucket : buckets){
            insertionNewSort(bucket);
        }

        // concat all the buckets back to original array

        int index =0 ;
        for (List<Double> bucket : buckets){
            for(double val: bucket){
                arr[index++] = val;
            }
        }


    }

    private static void insertionNewSort(List<Double> bucket) {
        for (int i=1; i<bucket.size();i++){
            double key = bucket.get(i);
            int j = i-1;
            while (j>=0 && bucket.get(j)> key){
                bucket.set(j+1,bucket.get(j));
                j--;
            }
            bucket.set(j+1,key);
        }
    }


}
