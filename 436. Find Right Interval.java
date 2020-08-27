class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return new int[0];
        if (intervals.length == 1) return new int[] {-1};
        int n = intervals.length;
        int[] res = new int[n];
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(intervals[i], i);
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (intervals[m][0] < intervals[i][1]) l = m + 1;
                else r = m;
            }
            if (l < intervals.length && intervals[l][0] >= intervals[i][1]) res[map.get(intervals[i])] = map.get(intervals[l]);
            else res[map.get(intervals[i])] = -1;
             
        }
        return res;
    }
}

