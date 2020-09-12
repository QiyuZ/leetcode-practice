class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {//由于乘法负负得正，所以最大的数可能只有两种可能，正数越来越大，负数最小但后面乘以的负数
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);//所以考虑三种情况
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            res = Math.max(res, max);//注意记录每次的最大值
        }
        return res;
    }
}
