class Solution {
    public int mergeStones(int[] stones, int K) {
        int len = stones.length;
        if (len == 1) return 0;
        if ((len - 1) % (K - 1) > 0) return -1; 
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) sum[i] = sum[i - 1] + stones[i - 1]; //留出sum[0] = 0这样后面-0位就是前面的和
        int[][] dp = new int[len][len];
        for (int span = K; span <= len; span++) { //从可以足够merge开始
            for (int left = 0; left + span - 1 < len; left++) { //right小于len
                int right = left + span - 1;
                dp[left][right] = Integer.MAX_VALUE;
                for (int split = left; split < right; split += K - 1) { //split要k-1累增，因为每次merge剩一个
                    dp[left][right] = Math.min(dp[left][right], dp[left][split] + dp[split + 1][right]);
                }
                // take e.g. Stones = [1,2,3,4,5] and K = 3
				// when span = 5th index, left = 0th index, right = 4th index and split = 2nd index
				// dp for subarray [1,2,3] will return 6 and for subarray [4,5] it will be 0
				// this will make dp[left][right] as 6 + 0 = 6;
				// so visually the given array will be represented from [1,2,3,4,5] to [([1,2,3] merged to 6), 4, 5]
				// we should merge [6,4,5] as well. This computation is being achieved in the logic below.

                if ((right - left) % (K - 1) == 0) dp[left][right] += sum[right + 1] - sum[left];
            }
        }
        return dp[0][len - 1];
    }
}
