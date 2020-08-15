class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));//注意要首先sort end，因为end是关键看是否相连
        int end = intervals[0][1];
        int count = 1;//起始的首个
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] >= end) {
                count++;
                end = cur[1];
            }
        }
        return intervals.length - count;//减去补集
    }
}
