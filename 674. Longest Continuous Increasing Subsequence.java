class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0; //be careful the Corner case
        int count = 1, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) count += 1;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count); //可能一直增加的，最后再比较一下
    }
}
