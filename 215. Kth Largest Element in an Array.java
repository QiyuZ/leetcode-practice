class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int helper(int[] nums, int start, int end, int k) {
        int pivot = nums[end], left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, left);
                left++;
            }
        }
        swap(nums, left, end);
        if (left == k) return nums[left];
        else if (left > k) return helper(nums, start, left - 1, k);
        else return helper(nums, left + 1, end, k);
    }
    
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
