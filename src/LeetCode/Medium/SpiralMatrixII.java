package LeetCode.Medium;

import java.util.Arrays;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top=0, bottom=n-1, left=0, right=n-1;
        int total=0;
        while(top<=bottom && left<=right){
            for (int i = left; i <= right; ++i) {
                result[top][i]=++total;
            }
            top++;
            for (int i = top; i <= bottom; ++i) {
                result[i][right]=++total;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    result[bottom][i]=++total;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    result[i][left]=++total;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII sm2 = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(sm2.generateMatrix(3)));
        System.out.println(Arrays.deepToString(sm2.generateMatrix(4)));
    }
}
