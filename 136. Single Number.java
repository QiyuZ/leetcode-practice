class Solution {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
//当是有序数列时，用二分法完成O(lgN)
class Solution {
    public int singleNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) right = mid;
                else left = mid;
            } else {
                if (nums[mid] == nums[mid - 1]) left = mid;
                else right = mid;
            }
        }
        //此处要注意边界
        if((left == 0 || nums[left] != nums[left - 1]) && (left == nums.length - 1 || nums[left] != nums[left + 1])) return nums[left];
        else return nums[right];
    }
}
