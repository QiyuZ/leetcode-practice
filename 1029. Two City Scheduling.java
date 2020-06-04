class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> ((a[0] - a[1]) - (b[0] - b[1]))); //按照差值排序
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) res += costs[i][0];//城市相等要一半一半，差值小的选大的这样后面可以选小的
            else res += costs[i][1];
        }
        return res;
    }
}
