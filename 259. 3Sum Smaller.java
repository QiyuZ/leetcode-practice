class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[i] + nums[r] <target) {
                    count += r - l;
                    l++;
                } else r--;
            }
        }
        return count;
    }
}
