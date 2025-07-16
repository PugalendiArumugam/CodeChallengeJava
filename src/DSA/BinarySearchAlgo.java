package DSA;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        int[] array = new int[200];
        int target = 142;

        for (int i = 0; i<200;i++){
            array[i] = i;
        }
        int index = binarySearch(array, target);
        System.out.println("Search Index "+index);
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length-1;
        int middle;

        while(low <= high){
            middle = low + (high - low) /2;
            System.out.println(middle);
            int val = array[middle];
            if(val < target) {
                low = middle + 1;
            } else if(val > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
