class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> (a[0] > b[0] ? 1 : -1)); //注意此处直接a[0] - b[0]可能越界
        int count = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] cur = points[i];
            if (cur[0] > end) {
                count++;
                end = cur[1];
            } else end = Math.min(end, cur[1]);
        }
        return count;
    }
}
