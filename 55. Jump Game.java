class Solution {
    public boolean canJump(int[] nums) { //greedy 
        if (nums == null || nums.length < 2) return true;
        int reach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > reach) return false; //达不到这个i后面的更到不了，停止更新
            reach = Math.max(reach, nums[i] + i);
            if (reach >= nums.length - 1) return true;
        }
        return false;
    }
}
