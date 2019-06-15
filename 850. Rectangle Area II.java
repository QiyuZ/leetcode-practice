class Solution {
    private long M = (long)1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        long res = 0;
        for (int[] r : rectangles) res += (long)(r[2] - r[0]) * (r[3] - r[1]); //注意此处和下面计算面积要用long
        for (int i = 0; i < rectangles.length; i++) { //n^2 注意只前往后比，不用后面的和前面比，防止重复
            long overlap = overlap(rectangles, rectangles[i], i + 1); //对于每个长方形根据下一个划分多个小块，无重复的接着去比较下一个
            res = (res - overlap + M) % M;
        }
        return (int)res;
    }
    private long overlap(int[][] recs, int[] cur, int i) {
        if (i == recs.length) return 0;
        int[] next = recs[i++];
        int left = Math.max(cur[0], next[0]), right = Math.min(cur[2], next[2]);
        int bottom = Math.max(cur[1], next[1]), top = Math.min(cur[3], next[3]);
        if (left >= right || bottom >= top) return overlap(recs, cur, i); //没有重复全体比较下一个
        long overlap = (long)(right - left) * (top - bottom);            //下面是左右上下的划分，中间的重复则不用计算，i已经在上面++过了
        if (cur[0] < next[0]) overlap = (overlap + overlap(recs, new int[] {cur[0], cur[1], next[0], cur[3]}, i)) % M;
        if (cur[2] > next[2]) overlap = (overlap + overlap(recs, new int[] {next[2], cur[1], cur[2], cur[3]}, i)) % M;
        if (cur[3] > next[3]) overlap = (overlap + overlap(recs, new int[] {left, next[3], right, cur[3]}, i)) % M;
        if (cur[1] < next[1]) overlap = (overlap + overlap(recs, new int[] {left, cur[1], right, next[1]}, i)) % M;
        return overlap;
    }
}
