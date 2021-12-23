class Solution {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while(n > 1) {
			// add new char before prev string
            a = (a + e + i + o + u); // a, e, i, o, u -> aa, ae, ai, ao, au
            e = (e + i + o + u); // e, i, o, u -> ee, ei, eo, eu
            i = (i + o + u); // i, o, u -> ii, io, iu
            o = (o + u); // o, u -> oo, ou
            u = (u);; // u -> uu
            n--;
        }
        return a + e + i + o + u;
    }
}

    // public int countVowelStrings(int n) {
    //     int[] dp = new int[] {0, 1, 1, 1, 1, 1};
    //     for (int i = 1; i <= n; ++i)
    //         for (int k = 1; k <= 5; ++k)
    //             dp[k] += dp[k - 1];
    //     return dp[5];
    // }
