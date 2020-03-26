class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        comb[] combs = new comb[startTime.length];
        for (int i = 0; i < combs.length; i++) {
            combs[i] = new comb(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(combs, (a, b) -> (a.end - b.end)); //按照结束排序，因为结束影响了本身的时长和下一个什么时候开始
        int[] dp = new int[combs.length];
        dp[0] = combs[0].profit;
        for (int i = 1; i < dp.length; i++) {
            if (combs[i].start >= combs[i - 1].end) {
                dp[i] = dp[i - 1] + combs[i].profit;
                continue;
            }
            dp[i] = Math.max(dp[i - 1], combs[i].profit); //最大的可能是上一个或者是当前重新开始
            for (int j = i - 1; j >= 0; j--) {
                if (combs[i].start >= combs[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + combs[i].profit);
                    break; //找到合适的既可以停止，因为每次都是记录最大的，再往前找没有意义
                }
            }
        }
        return dp[dp.length - 1];
    }
    
    class comb {
        int start, end, profit;
        public comb (int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
