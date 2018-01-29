class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) swap(nums, i); //奇数坐标比较
            } else if (i != 0 && nums[i - 1] < nums[i]) swap(nums, i); //偶数坐标比较
        }
    }
    public void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp; 
    }
}
