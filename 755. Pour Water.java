class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int cur = K;
            while (cur > 0 && heights[cur - 1] <= heights[cur]) cur--;
            while (cur < heights.length - 1 && heights[cur + 1] <= heights[cur]) cur++;
            while (cur > K && heights[cur - 1] <= heights[cur]) cur--; //如果在右边要移到第一个右边的地方
            heights[cur]++;
        }
        return heights;
    }
}
