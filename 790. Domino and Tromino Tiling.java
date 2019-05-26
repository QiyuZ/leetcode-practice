class Solution {
    public int numTilings(int N) {
        if(N == 1) return 1;
        else if(N == 2 ) return 2;
        int mod = 1000000007;
		int[] f = new int[N + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 5;
        for(int i = 4; i <= N; i++) {
            f[i] = 2 * f[i - 1] % mod + f[i - 3] % mod;
            f[i] %= mod;
        }
        return (int) f[N];
    }
}

/*
dp[n]=dp[n-1]+dp[n-2]+ 2*(dp[n-3]+...+d[0])
=dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+...+d[0])
=dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+...+d[0]))
=dp[n-1]+dp[n-3]+dp[n-1]
=2*dp[n-1]+dp[n-3]

如果只差一列只能用竖着的domino, 如果差两列只能两个竖着的domino, 三个以及三个以上分别有两种方式
*/
