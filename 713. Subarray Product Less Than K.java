class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 0, product = 1, res = 0;
        while (r < nums.length) {
            product *= nums[r];
            while (l <= r && product >= k) product /= nums[l++];
            res += r - l + 1;  //因为是连续的，所以每次增加的就是这个window的大小，比如5,2 是3; 5,2,6 就增加了6,26,526
            r++;
        }
        return res;
    }
}
