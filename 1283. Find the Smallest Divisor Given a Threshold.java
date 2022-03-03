class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = l;
        for (int num : nums) r = Math.max(r, num);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (calculateSum(nums, mid) > threshold) l = mid + 1;
            else r = mid;
        }
        return calculateSum(nums, l) <= threshold ? l : l - 1;
    }
    
    private int calculateSum(int[] nums, int divisor) {
        int res = 0;
        for (int num : nums) res += num % divisor != 0 ? num / divisor + 1 : num / divisor;
        return res;
    }
}
