class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) { //这里要+1是因为要找到左右两个数考虑中间缺什么
            int mid = left + (right - left) / 2;
            int missing = nums[mid] - nums[left] - (mid - left);
            if (missing >= k) right = mid;
            else {
                left = mid;
                k -= missing;
            }
        }
        if (nums[left] + k >= nums[right]) { //case 1: 缺少的在最后面，所以此时+1是算上了nums[right]
            return nums[left] + k + 1;
        }
        return nums[left] + k;//case 2: 缺少的在中间，之间求算
    }
}
