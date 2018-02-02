// class Solution {
//     public boolean PredictTheWinner(int[] nums) {
//         if (nums == null || nums.length == 0) return true;
//         int n = nums.length;
//         if (n % 2 == 0) return true;
//         int[][] dp = new int[n][n];
//         for (int i = 0; i < n; i++) dp[i][i] = nums[i];
//         for (int len = 1; len < n; len++) {
//             for (int i = 0; i < n - len; i++) {
//                 int j = i + len;
//                 if (i == j) dp[i][j] = nums[i];
//                 else dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//             }
//         }
//         return dp[0][n - 1] >= 0;
//     }
// }

//dp放的是两人拿的差值，直接看最后一个是不是大于0就行
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null) { return true; }
        int n = nums.length;
        if ((n & 1) == 0) { return true; } //偶数个一定赢，因为总能决定潜在多的那个
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) dp[i] = nums[i]; //相当于奇数时，因为先手总多一个 
                else dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                //选择了开头那么选手2能比选手1多拿dp[j]个（都是相互的），同理先拿最后一个，选一个差值大的
            }
        }
        return dp[n - 1] >= 0;
    }
}
