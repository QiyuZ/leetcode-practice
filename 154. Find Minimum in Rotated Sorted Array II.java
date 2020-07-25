class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r){
            while (l < r && nums[l] == nums[l + 1]) l++; //去除重复
            while (l < r && nums[r] == nums[r - 1]) r--;
            while (l < r && nums[l] == nums[r]) l++; //去除头尾重复
            if (nums[r] > nums[l]) return nums[l]; //如果已经单调了，则直接取最小
            int mid = l + (r - l) / 2; //否则还按照 153. 的思路
            if (mid > l && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid < r && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] >= nums[l]) l = mid + 1;
            else r = mid;
        }
        return nums[0]; //no rotated
    }
}
