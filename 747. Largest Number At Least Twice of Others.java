class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int max = Integer.MIN_VALUE, index = -1, second = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second)
                second = nums[i];
        }
        return second * 2 <= max ? index : -1;
    }
}
