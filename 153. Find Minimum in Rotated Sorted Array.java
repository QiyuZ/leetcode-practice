class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        if (nums[r] > nums[l]) return nums[l]; //no rotated
        while (l < r) { //先增后减
            int mid = l + (r - l) / 2;
            if (mid > l && nums[mid - 1] > nums[mid]) return nums[mid];//破坏了先增，说明后面那个是target
            if (mid < r && nums[mid + 1] < nums[mid]) return nums[mid + 1]; //破坏了后减，说明前面的那个是target
            if (nums[mid] > nums[l]) l = mid + 1;//以pivot为分界线，如果nums[mid] > nums[l]说明mid在左边所以把l右移，反之把r左移
            else r = mid;
        }
        return nums[l];
    }
}
