class Solution { //advanced 2 sum
    private static final int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int l = 0, n = nums.length, r = n - 1, res = 0;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) pow[i] = (pow[i - 1] * 2) % MOD; //in case overflow
        while (l <= r) {
            if (nums[l] + nums[r] > target) r--;//this wont miss the one on right, becase like 6 + 6 < 9, we dont need to consider it
            else res = (res + pow[r - l++]) % MOD; //for element in l + 1 to r, we can either pick or not, so it's 2 ^ (r - l), need to move l forward as all possible res has been added
        }
        return res;
    }
}
