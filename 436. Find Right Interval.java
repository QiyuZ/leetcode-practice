/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length < 1) return new int[0];
        if (intervals.length == 1) return new int[] {-1};
        int n = intervals.length;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(intervals[i].start, i);
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for (int i = 0; i < n; i++) {
            res[map.get(intervals[i].start)] = -1;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (intervals[m].start < intervals[i].end) l = m + 1;
                else r = m;
            }
            if (l < n && intervals[l].start >= intervals[i].end) res[map.get(intervals[i].start)] = map.get(intervals[l].start); 
        } 
        return res;
    }
}
