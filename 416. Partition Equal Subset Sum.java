class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        boolean dp[] = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums) { //0-1 knapback
            for (int i = sum / 2; i >= num; i--) dp[i] = dp[i - num] || dp[i]; //不可以从前往后，因为要用的是上一次的，从前往后会用到即时更新的
        }
        return dp[sum / 2];
    }
}
