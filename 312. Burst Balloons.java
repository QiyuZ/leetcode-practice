class Solution {
    public int maxCoins(int[] nums) {
        int  m = nums.length;
        int[][] dp = new int[m][m];
        return findMax(nums, 0, m - 1, dp);
    }
    public int findMax(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] != 0) return dp[start][end]; //说明有最终结果了
        int max = 0;
        for (int i = start; i <= end; i++) {
            int val = findMax(nums, start, i - 1, dp ) + get(nums, i) * get(nums, start - 1) * get(nums, end + 1) + findMax(nums, i + 1, end,             dp);      //左边的                            最后burst i这个气球                                        右边的
            max = Math.max(max, val);
        }
        dp[start][end] = max;
        return max;
    }
    public int get(int[] nums, int i) {
        if (i == -1 || i == nums.length) return 1;
        return nums[i];
    }
}
/*分治加dp
分为三部分，每次留下两边的最后戳破，注意nums[-1] = nums[n] = 1，所以范围要大一些， i<=end*/
