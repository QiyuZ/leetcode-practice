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
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> (a.end == b.end? a.start - b.start : a.end - b.end));
        int end = Integer.MIN_VALUE;;
        int count = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) end = interval.end;
            else count++;
        }
        return count;
    }
}

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length <= 1){return 0;}
        Arrays.sort(intervals,(a,b)->a.start - b.start);
        int count = 0;
        for (int i = 1 ; i < intervals.length;i++){
            if (intervals[i].start < intervals[i-1].end){
                intervals[i].end = Math.min(intervals[i].end,intervals[i-1].end);
                count++;
            }
        }
        return count;
    }
}
