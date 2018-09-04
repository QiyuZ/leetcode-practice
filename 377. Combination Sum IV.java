// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//         if (target == 0) return 1;
//         int res = 0;
//         for (int num : nums) {
//             if (num <= target) res += combinationSum4(nums, target - num);
//         }
//         return res;
//     }
// }

class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) { //注意区别 416，那个只可以用一次
            for (int num : nums) {
                if (num > i) continue; 
                else if (i == num) dp[i]++;//这个数就可以满足，所以+1
                else dp[i] += dp[i - num]; //相当于i-num + num
            }
        }
        return dp[target];
    }
}


/*follow up 如果是负数，必须限制每个只能用一次，因为 {-1, 1}target = 1可以有无穷个 */
