class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n && i < k; i++) res[i] = -1;
        for (int i = n - 1; i >=0 && i >= n - k; i--) res[i] = -1;
        if (finished(res)) return res;
        int left = 0, right = 2 * k;
        long sum = getRangeSum(nums, left, right), count = 2 * k + 1;
        res[k] = (int)(sum / count);
        for (int i = k + 1; i >= 0 && i < n && i < n - k; i++) {
            sum = sum - nums[left] + nums[++right];
            left++;
            res[i] = (int)(sum / count);
        }
        return res;
    }
    
    private boolean finished (int[] res) {
        for (int n : res) {
            if (n != -1) return false;
        }
        return true;
    }
    
    private long getRangeSum(int[] nums, int l, int r) {
        long sum = 0;
        for (int i = l; i <= r; i++) sum += nums[i];
        return sum;
    }
}
