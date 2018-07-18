class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length + 1];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int cur = i == cost.length ? 0 : cost[i]; //top是指cost最后一个的后面
            res[i] = Math.min(res[i - 1] + cur, res[i - 2] + cur); //根据题意不是上一个跳过来就是上上个
        }
        return res[res.length - 1];
    }
}
