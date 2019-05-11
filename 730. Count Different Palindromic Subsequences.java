class Solution {
    
    public int countPalindromicSubsequences(String S) {
        int mod = 1000000007;
        int n = S.length();
        int[][] dp = new int[n][n];
        //substring of length 1
        for (int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        //substring with length 2 or more
        for (int len = 1; len <= n; len++){
            for (int i = 0; i < n - len; i++){
                int j = i + len;
                if (S.charAt(i) == S.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] * 2;
                    int l = i + 1;
                    int r = j - 1;
                    while (l <= r && S.charAt(l) != S.charAt(i)){
                        l++;
                    }
                    while (l <= r && S.charAt(r) != S.charAt(i)){
                        r--;
                    }
                    if (l == r){ //中间有一个和首尾相同的字母
                        dp[i][j] += 1;
                    } else if ( l > r){ //没有
                        dp[i][j] += 2;
                    } else { //有多个
                        dp[i][j] -= dp[l + 1][r - 1];
                    }   
                } else { //首尾不同，减去重叠
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j] % mod;
            }
        }
        return dp[0][n - 1];
    }
}

//https://www.jianshu.com/p/d1d4414c97d2
