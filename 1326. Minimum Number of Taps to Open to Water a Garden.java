class Solution { //same as 1024
    public int minTaps(int n, int[] ranges) {
        if (n <= 0) return 0;
        interval[] intervals = new interval[ranges.length];
        for (int i = 0; i < intervals.length; i++) intervals[i] = new interval(Math.max(0, i - ranges[i]), i + ranges[i]);
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        int canReach = 0, end = 0, i = 0, res = 0;
        while (canReach < n) {
            while (i < intervals.length && intervals[i].start <= canReach) { //must have overlap, like 0,3 4,5 4 > 3此时canReach=3则3,4无法顾及
                end = Math.max(end, intervals[i++].end);
            }
            if (end <= canReach) return -1; //can not go further, means fail
            res++;
            canReach = end;
        }
        return res;
    }
    
    class interval {
        int start, end;
        public interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


class Solution {
    public int minTaps(int n, int[] ranges) {
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]), end = Math.min(n, i + ranges[i]);
            ranges[start] = Math.max(ranges[start], end);
        }
        int curEnd = 0, count = 0, reach = 0; //选中一个后，curEnd就是它能触及的最远距离， reach是到达curEnd过程中下次能到达的最远距离
        for (int i = 0; i < n; i++) {
            reach = Math.max(reach, ranges[i]);
            if (i == curEnd) { //当i == curEnd说明本次已经结束，要选择下一次，这是更新成reach
                count++;
                curEnd = reach;
            }
        }
        return curEnd == n ? count : -1;
    }
}
