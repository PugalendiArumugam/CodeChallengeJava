package DSA.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args){
        int[] arr = {10,20,25,12,40,15,18,7,2,45};
//        int[] arr = {4,10,3,5,1};
        System.out.println("Original "+ Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr){
        if(arr==null|| arr.length<=1) return;
        int n = arr.length;

        // Building Max-heap
        // Start from last non leaf note and heapify downwords (parent of the last node n/2-1
        for (int i=n/2-1;i>=0;i--){
            System.out.println("i value in heapify downwords "+i + " arr value "+arr[i]);
            heapify(arr,n,i);
        }
        System.out.println("==================================");
        // Phase 2: Extract elements one by one
        for(int i=n-1;i>0; i--){
            System.out.println("i extract elements -> "+i+" arr "+arr[i]);
            // Move current root (max) to the end
            swap(arr,0,i);
            // Heapify the reduced heap
            heapify(arr,i,0);
        }
    }

    private static void heapify(int[] arr, int n, int i){
        System.out.println("i in heapify ->"+i+" arr "+arr[i]);
        System.out.println(Arrays.toString(arr));
        int largest = i;
        int left =  2 * i + 1;
        int right = 2 * i + 2;

        // If left child exists and is greater than root
        if (left < n && arr[left] > arr[largest]){
            largest=left;
        }

        // If right child exists and is greater than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest=right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i){
            swap(arr,i,largest);
            heapify(arr,n,largest);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
