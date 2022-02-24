class Solution { 
    public int minDifference(int[] nums) { //actually we can try one by one, change 3 largest one, change 2 large 1 small, 1l2m, 3 smallest
        if (nums == null || nums.length <= 4) return 0; //we can change 3 to the same as the remaining one
        int n = nums.length, res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) res = Math.min(res, nums[n - 4 + i] - nums[i]); //eg. change largest 3, then it's nums[i-4]-nums[0] -> nums[i-3]-nums[1] ....
        return res;
    }
}
