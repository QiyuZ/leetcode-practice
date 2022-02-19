class Solution {
    public int longestArithSeqLength(int[] nums) { //actually a dp
        if (nums == null || nums.length == 0) return 0;
        List<Map<Integer, Integer>> list = new ArrayList<>(); //diff - count for every index
        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, 1); //if it's same, it needs to add one, so default to 1
        list.add(first);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            list.add(map);
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                Map<Integer, Integer> pre = list.get(j);
                int count = pre.containsKey(diff) ? pre.get(diff) + 1 : 2;
                map.put(diff, count);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}


class Solution {
    public int longestArithSeqLength(int[] nums) { 
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500; //we map diff -500-0 to 0-500, 0-500 to 500-1000
                dp[i][diff] = dp[j][diff] == 0 ? 2 : dp[j][diff] + 1; //if the pre is 0, the currently we got i and j, so it's 2. Otherwise plus one
                res = Math.max(res, dp[i][diff]);
            }
        }   
        return res;
    }
}
