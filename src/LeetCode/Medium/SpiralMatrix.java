package LeetCode.Medium;

/*
54 Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix sp = new SpiralMatrix();
        int[][] mx1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] mx2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] mx3 = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 } };
        System.out.println(sp.spiralOrder(mx1));
        System.out.println(sp.spiralOrder(mx2));
        System.out.println(sp.spiralOrder(mx3));
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Integer> res = new ArrayList<>();

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; ++i) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; ++i) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
