class Solution {
    public int findDerangement(int n) {
        if (n <= 1) return 0;
        long dp[] = new long[n + 1];
        long mod = 1000000007;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % mod;
        }
        return (int)dp[n];        
    }
}

/**
比如n=4
case 1， 在3的基础上加， 2,3,1   3,1,2 可以把4 插到除了最后一位的任何一个地方
case 2， 3的是全符合要求的但可能之前有一个数字不符合要求可以交换（如果有两个则无法通过多一个数来实现符合要求）
**/
