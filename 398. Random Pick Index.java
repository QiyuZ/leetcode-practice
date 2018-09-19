class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int res = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rand.nextInt(++count) == 0) res = i; //因为不包括，所以要先+1
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
