// class Solution {
//     public long getDescentPeriods(int[] prices) {
//         List<Integer> amounts = new ArrayList<>();
//         int count = 1;
//         long[] dp = new long[100001];
//         dp[1] = 1;
//         for (int i = 2; i <= 100000; i++) dp[i] = dp[i - 1] + i;
//         for (int i = 0; i < prices.length - 1; i++) {
//             if (prices[i] - prices[i + 1] == 1) count++;
//             else {
//                 amounts.add(count);
//                 count = 1;
//             }
//         }
//         amounts.add(count);
//         long res = 0;
//         for (int amount : amounts) res += dp[amount];
//         return res;
//     }
// }

class Solution {
    public long getDescentPeriods(int[] prices) {
        int start = 0, end = 0;
        long count = 1;
        for(end = 1; end < prices.length; end++){
            if(prices[end] == prices[end - 1] - 1){
                count += end - start + 1; //dp, like 4->3,2,1 then 4 to each num and 4 itself 
            } else {
                start = end; //refresh the start to the latest one
                count++; // still add the number itself
            }
        }
        return count;
    }
}
