class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[pos++] = nums[i]; //用另一个指针，把非0移到前面
        }
        for (int i = pos; i < nums.length; i++) nums[i] = 0; //把后面填充0
    }
}
