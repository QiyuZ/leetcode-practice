class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>(); // sum - index
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : nums[i];//变为-1这样和为0, 类似2sum
            //和2sum不同的是这个是连续的而不是任意找两个，所以不是找0-sum而是找sum,
            //都是sum说明中间的是0，即0,1相等，eg. -1, 1, 1
            if (map.containsKey(sum)) res = Math.max(res, i - map.get(sum));
            else map.put(sum, i); //不更新已经有的，因为那些位置靠前
        }
        return res;
    }
}
