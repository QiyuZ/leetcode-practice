class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        if (nums[r] > nums[l]) return nums[l]; //no rotated
        while (l < r) { //左右两端分别增加但中间有gap
            int mid = l + (r - l) / 2;
            if (mid > l && nums[mid - 1] > nums[mid]) return nums[mid];//找到了gap, mid在右边，所以才会nums[mid - 1] > nums[mid]
            if (mid < r && nums[mid + 1] < nums[mid]) return nums[mid + 1]; //找到了gap, mid在z左边，所以才会nums[mid + 1] < nums[mid]，注意考虑这两种情况，不可以用else if
            if (nums[mid] > nums[l]) l = mid + 1;//以pivot为分界线，如果nums[mid] > nums[l]说明还在左区间
            else r = mid;
        }
        return nums[l];
    }
}
