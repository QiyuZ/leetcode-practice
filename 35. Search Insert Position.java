class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) j = mid;
            else i = mid + 1;
        }
        return nums[i] >= target ? i : i + 1; //避免最后一位的edge case
    }
}
