class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) return true;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                count++;
                if (i > 0 && nums[i - 1] > nums[i + 1]) nums[i + 1] = nums[i]; //一般都情况就是把上一个大的变小（因为当前变大影响下一个）
                //但是变小后，可能上上一个就比上一个大了，如4,5,2，所以此时解决方案是当前变大
                else nums[i] = nums[i + 1];  //一般都情况
            }
        }
        return count <= 1;
    }
}

/* 4,5,2
   1,6,2,5 */
