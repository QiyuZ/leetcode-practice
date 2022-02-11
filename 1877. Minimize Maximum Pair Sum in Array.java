class Solution {
    public int minPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int i = 0, j = nums.length - 1;
        while (i < j) res = Math.max(res, nums[i++] + nums[j--]);
        return res;
    }
}
