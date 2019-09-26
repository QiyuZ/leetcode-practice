class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> ((b[1] - b[0]) - (a[1] - a[0]))); //tip 排序差值，以为个数为2N，那么前一半就是costs[i][1]花费少，后一般就是costs[i][0]花费少
        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][0] + costs[costs.length - i - 1][1];
        }
        return res;
    }
}
