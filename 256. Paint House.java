class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);//如果第i个房子涂成0颜色，目前最少花费，下面同理
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
        }
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);//最后一个房子肯定是其中的一个颜色，都是经过累加的直接找最小的
    }
}
//很巧妙，因为相邻颜色不同所以一个房子只能有两个选择（除了第一个）
