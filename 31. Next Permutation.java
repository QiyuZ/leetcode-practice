class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int i = nums.length - 1, j = nums.length - 1;
        //从后向前找到第一个非上升序列的比如6349871， 找到4
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        i -= 1;
        //如果存在这样的数和右边第一个比它大的交换，7
        if (i >= 0) {
            while (nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        //要想这个新的数字是紧邻的最大，就要把这两个位置之间的按照升序排一下，就算没有这样的数也相当于从新排列(根据前面这部分数是递减顺序的)
        reverse(nums, i + 1, nums.length - 1);
    }
    public void swap(int[] nums, int i, int j) {
        int cur = nums[i];
        nums[i] = nums[j];
        nums[j] = cur;
    }
    public void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }
}
