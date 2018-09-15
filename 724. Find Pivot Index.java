class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = -1;
        if (nums == null || nums.length == 0) return pivot;
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + nums[i];
        for (int i = 0; i < n; i++) { //两边不考虑
            int left = i == 0 ? 0 : sum[i - 1];
            int right = i == n - 1 ? 0 : sum[n - 1] - sum[i]; //考虑边界情况
            if (left == right) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }
}
