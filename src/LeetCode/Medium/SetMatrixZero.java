package LeetCode.Medium;

import java.util.Arrays;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

in-place algorithm is an algorithm that operates directly on the input data structure without requiring extra space
proportional to the input size. In other words, it modifies the input in place, without creating a separate copy of
the data structure. An algorithm which is not in-place is sometimes called not-in-place or out-of-place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

 */
public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] ia1 = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] ia2 = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        SetMatrixZero smz = new SetMatrixZero();
        smz.setZeroes(ia1);
        smz.setZeroes(ia2);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMatrix = new int[m];
        int[] colMatrix = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowMatrix[i]=1;
                    colMatrix[j]=1;
                }
            }
        }
        //Zeroise the rows from rows indicator
        for(int i=0;i<rowMatrix.length;i++){
            if(rowMatrix[i]==1){
                for(int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        //Zeroise the cols from column indicator
        for(int i=0;i<colMatrix.length;i++){
            if(colMatrix[i]==1){
                for(int j=0;j<m;j++){
                    matrix[j][i]=0;
                }
            }
        }
//        System.out.println(Arrays.deepToString(matrix));
    }
}
