class Solution {
    public int movesToMakeZigzag(int[] nums) { 
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int left = (i - 1 >= 0) ? nums[i - 1] : Integer.MAX_VALUE;
            int right = (i + 1 < nums.length) ? nums[i + 1] : Integer.MAX_VALUE;
            int change = Math.max(0, nums[i] - Math.min(left, right) + 1); 
            //两种可能，奇数位或者偶数位小于两边，所以当nums[i]大，就不用变化了， +1是不能相等要多于, change是中间的数要减小的值
            res[i % 2] += change;
        }
        return Math.min(res[0], res[1]);
    }
}
