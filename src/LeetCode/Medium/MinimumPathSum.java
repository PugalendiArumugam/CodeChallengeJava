package LeetCode.Medium;

import java.util.ArrayList;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
------>
1 3 1 |
1 5 1 |
4 3 1 V

1 → 3 → 1 → 1 → 1 = 7  left to bottom right
1 -> 5 -> 1 -> 1 = 8
4-> 3 -> 1 = 8
So minimum is first one 7

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

1 2 3
4 5 6
1->2->3->6 = 12    < this is minimum
4->5->6 =15

 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum pps = new MinimumPathSum();
        int[][] grid1 = new int[][]{{1,3,1},{1,5,1},{4,2,1}};    //7
        int[][] grid2 = new int[][]{{1,2,3},{4,5,6}};    //12
        int[][] grid3 = new int[][]{{1,2},{1,1}};        //3
        System.out.println(pps.minPathSum1(grid1));
        System.out.println(pps.minPathSum1(grid2));
        System.out.println(pps.minPathSum1(grid3));
    }

    public int minPathSum(int[][] grid) {
        int result=Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top < bottom) {
            int total=0;
            for (int i = left; i <= right; ++i) {
                total+=grid[top][i];
            }
            top++;
            for (int i = top; i <= bottom; ++i) {
                total+=grid[i][right];
            }
//            right--;
            result=Math.min(result,total);
        }
        return result;
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
