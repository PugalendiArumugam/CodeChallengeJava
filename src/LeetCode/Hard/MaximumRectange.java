package LeetCode.Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
85 Maximum Rectangle
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0

Example 3:
Input: matrix = [["1"]]
Output: 1
 */
public class MaximumRectange {
    public static void main(String[] args) {
        MaximumRectange mr = new MaximumRectange();
        char[][] matrix1 = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix2 = new char[][]{{'0'}};
        char[][] matrix3 = new char[][]{{'1'}};
        System.out.println(mr.maximalRectangle(matrix1));
        System.out.println(mr.maximalRectangle(matrix2));
        System.out.println(mr.maximalRectangle(matrix3));
    }

    public int maximalRectangle(char[][] matrix) {
        int numColumns = matrix[0].length;
        int[] heights = new int[numColumns];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < numColumns; ++j) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, area(heights));
        }
        return maxArea;
    }

    private int area(int[] vertical) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] l = new int[vertical.length];
        int[] r = new int[vertical.length];
        Arrays.fill(r, vertical.length);
        for (int i = 0; i < vertical.length; ++i) {
            while (!stack.isEmpty() && vertical[stack.peek()] >= vertical[i]) {
                r[stack.pop()] = i;
            }
            l[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < vertical.length; ++i) {
            maxArea = Math.max(maxArea, vertical[i] * (r[i] - l[i] - 1));
        }
        return maxArea;
    }
}
