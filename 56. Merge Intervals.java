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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() <= 1) return intervals; //一个就不用排序了
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;     //按照开始时间排序，因为这个start肯定是最小的
            }
        });
        int start = intervals.get(0).start, end = intervals.get(0).end;//初始start和end
        for (Interval i : intervals) {
            if (end >= i.start) end = Math.max(end, i.end); //前面的end和后面有重合（考虑相等），因为start肯定小，所以看是否要更新end
            else {
                res.add(new Interval(start, end)); //没重合则加入
                start = i.start; //更新为当前的start和end
                end = i.end;
            }
        }
        res.add(new Interval(start, end)); //最后一个还没加入
        return res;
    }
}
