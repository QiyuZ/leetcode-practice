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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2) {
                return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
            }
        });
        for (List<Interval> list : schedule) {
            for (Interval i : list) queue.offer(i);
        }
        Interval cur = queue.poll();
        while (!queue.isEmpty()) {
            if (queue.peek().start > cur.end) {
                res.add(new Interval(cur.end, queue.peek().start));
                cur = queue.poll();
            } else {
                cur = cur.end < queue.peek().end ? queue.peek() : cur; //保留end大的，因为前一个相当于只用end，所以不用管start是什么
                queue.poll();
            }
        }
        return res;
    }
}
