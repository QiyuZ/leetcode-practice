class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum < 0) sum = num; //已经是负的了，如果num>0则还不如自己单独成sum,如果num <0则越来越小
            else sum += num;
            res = Math.max(sum, res);
        }
        return res;
    }
}
