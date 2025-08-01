package LeetCode.Medium;

public class MinPathSumII {
    public static void main(String[] args) {
        MinPathSumII pps2= new MinPathSumII();
        int[][] grid1 = new int[][]{{1,3,1},{1,5,1},{4,2,1}};    //7
        int[][] grid2 = new int[][]{{1,2,3},{4,5,6}};    //12
        int[][] grid3 = new int[][]{{1,2},{1,1}};        //3
        System.out.println(pps2.minPathSum(grid1));
        System.out.println(pps2.minPathSum(grid2));
        System.out.println(pps2.minPathSum(grid3));
    }

//    static int[][] dummy = new int[][] {
//            {1, 2, 3},
//            {4, 5, 2},
//            {3, 2, 1}
//    };
//
//    static {
//        int warmup = 0;
//        for (int i = 0; i < 100; i++) warmup += minPathSumWarmed(dummy);
//    }

    public int minPathSum(int[][] grid) {
        return minPathSumWarmed(grid);
    }

    static int minPathSumWarmed(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int[][] dp = new int[R][C];
        dp[0][0] = grid[0][0];
        if (R < C) {
            for (int i = 1; i < R; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
                dp[0][i] = grid[0][i] + dp[0][i - 1];
            }
            for (int i = R; i < C; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        } else {
            for (int i = 1; i < C; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
                dp[0][i] = grid[0][i] + dp[0][i - 1];
            }
            for (int i = C; i < R; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                dp[r][c] = grid[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }

        return dp[R - 1][C - 1];
    }
}
