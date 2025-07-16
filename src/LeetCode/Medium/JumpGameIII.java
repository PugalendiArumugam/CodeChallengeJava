package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
/*
Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 */
public class JumpGameIII {
    public static void main(String[] args) {
        JumpGameIII jg = new JumpGameIII();
        System.out.println(jg.canReach(new int[]{4,2,3,0,3,1,2},5));
        System.out.println(jg.canReach(new int[]{4,2,3,0,3,1,2},0));
        System.out.println(jg.canReach(new int[]{3,0,2,1,2},2));
    }

    public boolean canReach1(int[] arr, int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            if (arr[currentIndex] == 0) {
                return true;
            }
            int jump = arr[currentIndex];
            arr[currentIndex] = -1;
            int f = currentIndex + jump;
            int b = currentIndex - jump;

            if (f >= 0 && f < arr.length && arr[f] >= 0) {
                queue.offer(f);
            }

            if (b >= 0 && b < arr.length && arr[b] >= 0) {
                queue.offer(b);
            }
        }
        return false;
    }

    // dfs fast method
    public boolean canReach(int[] arr, int start) {
        return dfsSearch(arr, start);
    }

    public boolean dfsSearch(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) return false;
        if (arr[start] == 0) return true;
        int jump = arr[start];
        arr[start] = -1;
        return dfsSearch(arr, start - jump) || dfsSearch(arr, start + jump);
    }

}
