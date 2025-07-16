package LeetCode.Medium;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;

/* HARD 1345
Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

 */
public class JumpGameIV {
    public static void main(String[] args) {
        JumpGameIV jg = new JumpGameIV();
        System.out.println(jg.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));  //3
        System.out.println(jg.minJumps(new int[]{7}));  //0
        System.out.println(jg.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7})); //1
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Deque<int[]> deque = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);   // visited position
        deque.offer(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] e = deque.pollFirst();
            int current = e[0];
            int step = e[1];
            if (current == n - 1) {
                return step;
            }
            step++;
            for (int index : map.getOrDefault(arr[current], new ArrayList<>())) {
                if (!set.contains(index)) {
                    set.add(index);
                    deque.offer(new int[]{index, step});
                }
            }
            map.remove(arr[current]);

            if (current + 1 < n && !set.contains(current + 1)) {
                set.add(current + 1);
                deque.offer(new int[]{current + 1, step});
            }
            if (current - 1 >= 0 && !set.contains(current - 1)) {
                set.add(current - 1);
                deque.offer(new int[]{current - 1, step});
            }
        }
        return -1;
    }


    // fastest
    public int minJumps1(int[] arr) {

        Queue<Integer> que = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int depth = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(n << 1);
        for (int i = 0; i < n; i++) {
            if (i > 0 && i + 1 < arr.length && arr[i] == arr[i + 1] && arr[i] == arr[i - 1])
                continue;
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        que.offer(0);
        visited[0] = true; // Mark start as visited immediately

        while (!que.isEmpty()) {
            depth++;
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int u = que.poll();

                if (u == n - 1)
                    return depth - 1;

                // Jump to same value indices
                List<Integer> indices = map.getOrDefault(arr[u], new ArrayList<>());
                for (int j = indices.size() - 1; j >= 0; j--) {
                    int index = indices.get(j);
                    if (!visited[index]) {
                        visited[index] = true; // Mark before adding to queue
                        que.offer(index);
                    }
                }
                // Prevent redundant lookups by removing the processed value
                map.remove(arr[u]);

                // Jump to adjacent indices
                int v = u - 1;
                if (v >= 0 && !visited[v]) {
                    visited[v] = true;
                    que.offer(v);
                }

                v = u + 1;
                if (v < n && !visited[v]) {
                    visited[v] = true;
                    que.offer(v);
                }
            }
        }
        return -1;
    }

}
