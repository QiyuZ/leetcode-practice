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

class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length + 2;
        int[] balloons = new int[n]; //add 2 for most left and right one, other values will be the same
        balloons[0] = balloons[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) balloons[i] = nums[i - 1];
        int[][] dp = new int[n][n]; //means max score (i, j) exclude i and j
        for (int k = 2; k < n; k++) {//starts from 2 because we need to have at least 3, left...right
            for (int left = 0; left < n - k; left++) { //note as right smaller than n, we need to limit left
                int right = left + k;
                for (int i = left + 1; i < right; i++) { //i is in (left, right)
                    int cur = balloons[left] * balloons[i] * balloons[right] + dp[left][i] + dp[i][right];
                    //either the old value or treat the left and right as current left and right. 
                    //Like a,b,c,d,e  dp[left][i] means a to c; dp[i][right] means c to e. After b,d bursted, a and e are left and right for c
                    dp[left][right] = Math.max(dp[left][right], cur);
                }
            }
        }
        return dp[0][n - 1];
    }
}
