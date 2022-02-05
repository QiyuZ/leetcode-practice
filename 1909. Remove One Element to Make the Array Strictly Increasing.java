class Solution {
    public boolean canBeIncreasing(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int drops = 0;
        for (int i = 1; i < nums.length; i++) { //when find a drop, either remove previous larger one or current smaller one
            if (nums[i - 1] >= nums[i]) {
                if (++drops == 2) return false;//cant have 2 drops
                if (i >= 2 && nums[i - 2] >= nums[i]) nums[i] = nums[i - 1]; //if cur<=nums[i-2] then remove current one, so update current one to previous one
            }
        }
        return true;
    }
}

