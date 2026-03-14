package DSA.Sorting;
//O(n²)
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={64, 34, 25, 12, 22, 11, 5,90, 11,25};
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int n = arr.length;
        int temp;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
//            if (swapped == false)
//                break;
        }
        for(int p: arr){
            System.out.print(p + " ");
        }
        System.out.println();

        sortwithduplicates();

    }


    public static void sortwithduplicates() {

        int[] arr = {64, 34, 25, 12, 22, 11, 5, 90, 11, 25};

        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int n = arr.length;
        int temp;
        boolean swapped;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        System.out.println("Sorted Array:");
        for (int p : arr) {
            System.out.print(p + " ");
        }

        System.out.println();

        // Remove duplicates
        int[] unique = new int[n];
        int index = 0;

        unique[index++] = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                unique[index++] = arr[i];
            }
        }

        System.out.println("Array without duplicates:");
        for (int i = 0; i < index; i++) {
            System.out.print(unique[i] + " ");
        }
    }

}

