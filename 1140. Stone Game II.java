class Solution {
    
    private int[] sum;
    private int[][] dp; //dp[i][M] 在i,M情况下先手可以拿到多少石子
    
    public int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0) return 0;
        int m = piles.length;
        sum = new int[m];
        sum[m - 1] = piles[m - 1];
        for (int i = m - 2; i >= 0; i--) sum[i] += sum[i + 1] + piles[i]; //因为从左往右拿，所以要向前累加
        dp = new int[m][m];
        return helper(piles, 0, 1);
    }
    
    private int helper(int[] piles, int i, int M) {
        if (i == piles.length) return 0;
        if (2 * M  + i >= piles.length) return sum[i]; //可以全部拿走
        if (dp[i][M] != 0) return dp[i][M];
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            min = Math.min(min, helper(piles, i + x, Math.max(x, M))); //找出后面的最少可以拿到多少
        }
        dp[i][M] = sum[i] - min;
        return dp[i][M];
    }
}
