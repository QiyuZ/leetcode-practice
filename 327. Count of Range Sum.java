class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) { //mergesort
        if (nums == null || nums.length == 0) return 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) sum[i + 1] = sum[i] + nums[i];
        return mergeCount(sum, 0, sum.length, lower, upper);
    }
    public int mergeCount(long[] sum, int start, int end, int lower, int upper) {
        if (start + 1 >= end) return 0;
        int mid = (start + end) / 2;
        int count = mergeCount(sum, start, mid, lower, upper) + mergeCount(sum, mid, end, lower, upper);
        int left = mid, right = mid, index = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) { //只有排序好的才可以直接right-left,这就是排序的原因
            while (left < end && sum[left] - sum[i] < lower) left++; //左闭右开
            while (right < end && sum[right] - sum[i] <= upper) right++;
            while (index < end && sum[index] < sum[i]) cache[r++] = sum[index++];
            cache[r] = sum[i];
            count += right - left;
        }
        System.arraycopy(cache, 0, sum, start, index - start);
        return count;
    }
}
