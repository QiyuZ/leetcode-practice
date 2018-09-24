class Solution {
    public int[] twoSum(int[] nums, int target) {
        int num1 = -1, num2 = -1;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                num1 = l;
                num2 = r;
                break;
            } else if (sum > target) r--;
            else l++;
        }
        return new int[] {num1 + 1, num2 + 1};
    }
}
