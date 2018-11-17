class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(0, nums.length - 1, nums), rob(1, nums.length, nums)); //其实就是分成了两种情况，分别写下就行
    }
    public int rob(int start, int end, int[] nums) {
        int preRob = 0, preNotRob = 0;
        for (int i = start; i < end; i++) {
            int curRob = preNotRob + nums[i];
            int curNotRob = Math.max(preRob, preNotRob);
            preRob = curRob;
            preNotRob = curNotRob;
        }
        return Math.max(preRob, preNotRob);
    }
}
