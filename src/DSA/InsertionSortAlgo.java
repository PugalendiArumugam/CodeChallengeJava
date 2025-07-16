package DSA;

import java.util.Arrays;

public class InsertionSortAlgo {
    public static void main(String[] args) {
        int[] array = new int[]{9,1,8,2,7,3,6,5,4};

//        System.out.println(Arrays.toString(array));
        insertionSort(array);
        for (int i: array) {
            System.out.print(i+" ");
        }
    }

    public static void insertionSort(int[] array1){
        for (int i =1; i<array1.length;i++){
            int temp = array1[i];
            int j = i-1;
            while (j>=0 && array1[j] > temp){
                array1[j + 1] = array1[j];
                j--;
            }
            array1[j + 1] = temp;
        }
    }
}
