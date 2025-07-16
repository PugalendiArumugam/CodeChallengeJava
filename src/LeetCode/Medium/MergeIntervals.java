package LeetCode.Medium;
/*
56 Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] ia1 = new int[][]{{2, 6}, {8, 10}, {15, 18}, {1, 3}};
        //Output: [[1,6],[8,10],[15,18]]
        System.out.println("ia1 "+Arrays.deepToString(mi.merge(ia1)));
        int[][] ia2 = new int[][]{{1, 4}, {4, 5}};
        //Output: [[1,5]]
        System.out.println("ia2 "+Arrays.deepToString(mi.merge(ia2)));
        int[][] ia3 = new int[][]{{1, 3}};
        //Output: [[1,3]]
        System.out.println("ia3 "+Arrays.deepToString(mi.merge(ia3)));
        int[][] ia4 = new int[][]{{1,4},{2,3}};       // typical case
        //Output: [[1,4]]
        System.out.println("ia4 "+Arrays.deepToString(mi.merge(ia4)));
        int[][] ia5 = new int[][]{{1,4},{0,2},{3,5}};       // typical case
        //Output: [[0,4],[3,5]
        System.out.println("ia5 "+Arrays.deepToString(mi.merge(ia5)));

        int[][] ia6 = new int[][]{{1,4},{0,2},{3,5}};       // typical case
        //Output: [[0,5]]
        System.out.println("ia6 "+Arrays.deepToString(mi.merge(ia6)));
    }

    // not working as we need to use the already merged pair.
    public int[][] merge1(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int m = intervals.length;
        if(m<=1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        boolean lastMerge = false;
        for (int i = 0; i < m; i++) {
            int j = i + 1;
            if (j >= m){
                if(!lastMerge){
                    result.add(new int[]{intervals[i][0], intervals[i][1]});
                    break;
                }
            };
            if (intervals[i][1] < intervals[j][0]) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                if(j+1==m){
                    lastMerge =true;
                }
                result.add(new int[]{intervals[i][0], Math.max(intervals[j][1],intervals[i][1])});
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int[] prevInterval = result.get(result.size() - 1);

            if (prevInterval[1] < start) {
                result.add(intervals[i]);
            } else {
                prevInterval[1] = Math.max(prevInterval[1], end);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    //fastest logic
    public int[][] merge2(int[][] intervals) {
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }

        int[] mp = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            mp[start] = Math.max(end + 1, mp[start]);
        }

        int r = 0;
        int have = -1;
        int intervalStart = -1;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (intervalStart == -1) intervalStart = i;
                have = Math.max(mp[i] - 1, have);
            }
            if (have == i) {
                intervals[r++] = new int[] { intervalStart, have };
                have = -1;
                intervalStart = -1;
            }
        }

        if (intervalStart != -1) {
            intervals[r++] = new int[] { intervalStart, have };
        }
        if (intervals.length == r) {
            return intervals;
        }

        int[][] res = new int[r][];
        for (int i = 0; i < r; i++) {
            res[i] = intervals[i];
        }

        return res;
    }

    // another fastest logic
    public int[][] merge5(int[][] intervals) {
        // how to determine if an interval is overlapping
        // to check if the end is >= start of the next inteval && < end of the next interval
        // if it is -> create new interval where start is the current interval's start and end is the next interval end
        // repeat until no more intervals left
        // if it's not, check if the end of the next interval is <= current end, if it is -> skip next interval
        // if the start of the next interval is > end of the current interval -> add current interval to the result and move to the next
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length; i++) {
            pq.offer(intervals[i]);
        }
        var currPair = pq.poll();
        while (!pq.isEmpty()) {
            var nextInterval = pq.poll();
            assert currPair != null;
            var curStart = currPair[0];
            var curEnd = currPair[1];
            var nextStart = nextInterval[0];
            var nextEnd = nextInterval[1];
            if (curEnd < nextStart) {
                result.add(currPair);
                currPair = nextInterval;
            } else {
                if (curEnd < nextEnd) {
                    currPair[1] = nextEnd;
                }
            }
        }
        result.add(currPair);
        return result.toArray(new int[result.size()][]);
    }

    // using sort
    public int[][] merge4(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        if (n<2) return intervals;
        int i =0;
        while(i<n){
            int[] currInterval = intervals[i];
            while(i<n && currInterval[1]>=intervals[i][0]){
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
                i++;
            }
            result.add(currInterval);
        }
        return result.toArray(new int[result.size()][0]);
    }

}
