package LeetCode.Hard;
import java.util.TreeSet;
//363. Max Sum of Rectangle No Larger Than K
//Example 1:
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2
//Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
//
//Example 2:
//Input: matrix = [[2,2,-1]], k = 3
//Output: 3

public class MaxSumOfRectangle {
    public static void main(String[] args) {
        MaxSumOfRectangle ms = new MaxSumOfRectangle();
        int[][] input1 = new int[][]{{1,0,1},{0,-2,3}};
        int[][] input2 = new int[][]{{2,2,-1}};
        System.out.println(ms.maxSumSubmatrix(input1,2));
        System.out.println(ms.maxSumSubmatrix(input2,3));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        final int infinity = Integer.MAX_VALUE;
        int result = -infinity;
        for (int startRow = 0; startRow < r; ++startRow) {
            int[] sum1 = new int[c];
            for (int endRow = startRow; endRow < r; ++endRow) {
                for (int col = 0; col < c; ++col) {
                    sum1[col] += matrix[endRow][col];
                }
                int sum2 = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int sum : sum1) {
                    sum2 += sum;
                    Integer minSum = set.ceiling(sum2 - k);
                    if (minSum != null) {
                        result = Math.max(result, sum2 - minSum);
                    }
                    set.add(sum2);
                }
            }
        }
        return result;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
                if (j > 0) {
                    matrix[i][j] += matrix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    matrix[i][j] -= matrix[i - 1][j - 1];
                }
            }
        }
        int result = Integer.MIN_VALUE;

        int[][] dpHigh = new int[matrix.length][matrix.length + 1];
        int[][] dpLow = new int[matrix.length][matrix.length + 1];

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int h = 1; h <= matrix.length - i; h++) {
                int theValue = getSum(matrix, i, matrix[0].length - 1, h, 1);
                dpLow[i][h] = theValue;
                dpHigh[i][h] = theValue;
                if (theValue == k) {
                    return theValue;
                }
                if (theValue < k) {
                    result = Math.max(result, theValue);
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                for (int h = 1; h <= matrix.length - i; h++) {
                    int newSum = getSum(matrix, i, j, h, 1);
                    if (dpLow[i][h] > 0) {
                        dpHigh[i][h] += newSum;
                        dpLow[i][h] = newSum;
                    } else if (dpHigh[i][h] < 0) {
                        dpLow[i][h] += newSum;
                        dpHigh[i][h] = newSum;
                    } else {
                        dpHigh[i][h] += newSum;
                        dpLow[i][h] += newSum;
                    }
                    if (dpHigh[i][h] >= result && dpLow[i][h] <= k) {
                        for (int w = 1; w <= matrix[0].length - j; w++) {
                            int sum = getSum(matrix, i, j, h, w);
                            if (sum == k) {
                                return sum;
                            } else if (sum < k) {
                                result = Math.max(result, sum);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private int getSum(int[][] matrix, int i, int j, int h, int w) {
        int sum = matrix[i + h - 1][j + w - 1];
        if (i > 0) {
            sum -= matrix[i - 1][j + w - 1];
        }
        if (j > 0) {
            sum -= matrix[i + h - 1][j - 1];
        }
        if (i > 0 && j > 0) {
            sum += matrix[i - 1][j - 1];
        }
        return sum;
    }

}
