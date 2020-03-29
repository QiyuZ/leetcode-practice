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
