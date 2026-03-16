package DSA.Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {64,34,25,3,22,11,5,7,12};

        for(int p:arr){
            System.out.print(p+" ");
        }
        System.out.println();
        quickSort(arr,0,arr.length-1);

        for(int p:arr){
            System.out.print(p+" ");
        }
        System.out.println();

    }

    static void quickSort(int[] arr, int low, int high){
        if (low<high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }



}
