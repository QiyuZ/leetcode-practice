class Solution {
    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a, b) -> (a[0] - b[0]));
        int start = 0, end = 0, i = 0;
        while (start < T) {
            while (i < clips.length && clips[i][0] <= start) {
                end = Math.max(clips[i++][1], end); //greedy每次找小于本次start的最大的end
            }
            if (start == end) return -1; //相等说明没有更新
            res++; 
            start = end; //更新到最大的end找下面的
        }
        return res;
    }
}
