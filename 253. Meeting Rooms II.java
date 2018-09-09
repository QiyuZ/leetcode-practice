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
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = queue.poll();
            if (intervals[i].start >= cur.end) cur.end = intervals[i].end; //2,4  4,7有time gap可以一间room就把这两个合并
            //因为此处要比较cur.end，所以queue要排列end 距离[[4,9],[4,17],[9,10]]
            else queue.offer(intervals[i]);
            queue.offer(cur);
        }
        return queue.size();
    }
}
