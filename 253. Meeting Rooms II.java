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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> {return a.start - b.start;});
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> {return a.end - b.end;});
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = queue.poll();
            if (cur.end <= intervals[i].start) cur.end = intervals[i].end; //可以合并的
            else queue.offer(intervals[i]); //不能合并的加进去
            queue.offer(cur); //之前去除的放回去
        }
        return queue.size();
    }
}
