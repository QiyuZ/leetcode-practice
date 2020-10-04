class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int sum = 0, half = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == half * 2) return i;
            half += nums[i];
        }
        return -1;
    }
}
