class Solution {
    public int minSwaps(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int size = 0;
        for (int num : nums) size += num;
        int left = 0, count = 0, res = n;
        for (int right = 0; right < 2 * n; right++) { //doesn't need to creat a new arr with double size, but just iterate twice with %n
            if (right - left + 1 > size) count -= nums[left++ % n];
            count += nums[right % n];
            if (right - left + 1 == size) res = Math.min(res, size - count);
        }
        return res;
    }
}
