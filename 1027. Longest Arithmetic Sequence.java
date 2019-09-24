class Solution {
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] dp = new HashMap[A.length]; //A数组每一位都对应若干个可能的差值
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; j++) {
                int diff = A[j] - A[i];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1); //此处默认为1因为要算上自己A[i]和另一个A[j]
                              //注意这里是dp[j]加的是它的子集
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}
