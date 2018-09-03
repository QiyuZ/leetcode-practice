// class Solution {
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
//         return dfs(nums, 0, S, 0);
//     }
//     public int dfs(int[] nums, int sum, int target, int index) {
//         if (nums.length == index) {
//             return sum == target ? 1 : 0;
//         }
//         return dfs(nums, sum + nums[index], target, index + 1) + dfs(nums, sum - nums[index], target, index + 1);
//     }
// }

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) sum += num;
        if (S > sum || S < -sum || (S + sum) % 2 != 0) return 0; 
        //转化为找子集问题，正数子集一定是偶数
        int target = (S + sum) / 2;
        int[] dp = new int[target + 1]; //0-1 knapsack, see leetcode 416 
        dp[0] = 1; //初始0
        for (int num : nums) {
            for (int i = target; i >= num; i--) dp[i] += dp[i - num]; //要从大到小，否则有重复计算
        }
        return dp[target];
    }
}

/* P - N = S
P = S + N
2P = S + P + N
2P = S + sum
P = (S + sum) / 2
所以找subset和为 (S + sum) / 2 有几个即可 */
