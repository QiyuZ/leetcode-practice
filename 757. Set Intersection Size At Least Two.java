class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b)-> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]); //[4,5][1,5]明显4,5在前因为4,5和[1,5]已经有重叠
        int left = intervals[0][1] - 1; //初始尽量和其他有重叠，因为已经按照后一位排序，所以就去两个最大的
        int right = intervals[0][1];
        int res = 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= left) continue; //已经有两个重叠
            if (curr[0] > left && curr[0] <= right) { 
                //只占了一个所以下面要++,加curr[1]，因为尽量使范围变大，left变为right因为right已经在里面
                res++;
                left = right;
                right = curr[1];
            } else if (curr[0] > right) { //完全没有重叠，重新定义
                res += 2;
                left = curr[1] - 1;
                right = curr[1];
            }
        }
        return res;
    }
}
