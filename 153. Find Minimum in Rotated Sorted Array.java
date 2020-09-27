class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int m = nums.length;
        if (nums[m - 1] > nums[0]) return nums[0];
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid]; //line 9, 10是因为左边肯定小于右边即使rotate, 如果不是说明找到了分界点
            else if (mid < m - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1]; 
            else if (nums[mid] > nums[l]) l = mid + 1; //右边的大于左边的说明在左边
            else r = mid; //其实是nums[r] > nums[mid]说明在右边
        }
        return nums[l];
    }
}
