package DSA.Sorting;
//O(n log n)   - Divide and conquer - but use pivot element
public class QuickSort2 {
    public static void main(String[] args) {
//        int[] arr = {64,34,25,3,22,11,5,7,12};
        int[] arr = {8,2,4,7,1,3,9,6,5};

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
        System.out.println("quickSort() "+"low:"+low+" high"+high);

//        if (low<high) {
//            int pivotIndex = partition(arr, low, high);
//            System.out.println("Pivot index "+pivotIndex+" "+arr[pivotIndex]);
//            quickSort(arr,low,pivotIndex-1);
//            quickSort(arr,pivotIndex+1, high);
//        }

        if (high<=low) return;  // base case

        int pivotIndex = partition(arr,low, high);
        quickSort(arr,low,pivotIndex-1);
        quickSort(arr, pivotIndex+1,high);


        for(int p:arr){
            System.out.print(p+" ");
        }
        System.out.println();
    }

    static int partition(int[] arr, int low, int high) {
        System.out.println("partition() "+"low:"+low+" high"+high);
        for(int p:arr){
            System.out.print(p+" ");
        }
        System.out.println();
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }



}
