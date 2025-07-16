package LeetCode.Medium;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
//        int[][] m = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] m = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotate(m);
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int k=0,j=0;
        for (int i = 0;i<len; i++){
            int[] iArray=new int[len];
            int frontfill = 0;
            while(frontfill<k){
                iArray[frontfill] = matrix[i][frontfill++];
            }
            j=k;
            while(j<len){
                if(i!=j) {
//                    System.out.println("i :"+i+" j :"+j);
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
                iArray[j]=matrix[i][j];
                j++;
            }
            //reverse the array
            int z=0;
            for(int l=len-1;l>=0;l--){
                matrix[i][z++]=iArray[l];
            }
            k++;
        }


//        int n = matrix.length;
//        int[][] res = new int[n][n];   // using another 2D array which is not given in
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i][j] = matrix[n - j - 1][i];
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = res[i][j];
//            }
//        }

                System.out.println(Arrays.deepToString(matrix));
    }
}
