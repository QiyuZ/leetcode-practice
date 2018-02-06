// n^2
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}


//nlogn  为什么可以用二分法呢？因为tails这个数组就是结果的数组，是有序的
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int l = 0, r = size, m = 0;
            while (l < r) {
                m = l + (r - l) / 2;
                if (tails[m] < num) l = m + 1;
                else r = m;
            }
            tails[l] = num;
            if (l == size) size++;  //如果一直移到了l=size那么说明有新加入的
        }
        return size;
    }
}
