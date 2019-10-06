class Solution {
    public int lastStoneWeightII(int[] stones) {//其实是背包问题
        int sum = 0, n = stones.length;
        for (int s : stones) sum += s;
        boolean[][] dp = new boolean[sum + 1][n + 1];//dp[i][j]使用0-j-1的stones的subset可以达到sum=i的效果
        for (int i = 0; i <= n; i++) dp[0][i] = true; //初始0都成立
        int less = 0;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= sum / 2; s++) {//因为这一组小，最大和顶多为一半
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                    //s已经可以达到或者s - stones[i - 1]可以达到，因为此时要加上stones[i-1]
                    dp[s][i] = true;
                    less = Math.max(less, s); //更新这一组和的最大值
                }
            }
        }
        return (sum - less) - less;
    }
}

/**
虽然是一个个碰撞，但其实可以分为两个组，直接相减，比如1，2，2，6最小几位1， 6-（1+2+2）可以看作6多次和另外一组碰撞
所以问题转化为找出较小那组最大的和
*/
