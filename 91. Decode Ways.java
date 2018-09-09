class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //第一个是0就是0,因为后面要用的i-2所以先初始化第一个字符
        for (int i = 2; i < dp.length; i++) {
            int single = Integer.parseInt(s.substring(i - 1, i));
            if (single >= 1 && single <= 9) dp[i] = dp[i - 1]; //检查当前数，单位
            //0 dp[i] = 0;
            int two = Integer.parseInt(s.substring(i - 2, i));//检查双位数
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
