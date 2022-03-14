class Solution {
    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int startZero = -1, firstNeg = -1, countNeg = 0, max = 0; //mark startZero and firstNeg as -1, because when there's no such num, it should +1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                startZero = i;
                firstNeg = -1;
                countNeg = 0;
            } else if (nums[i] < 0) {
                countNeg++;
                if (firstNeg == -1) firstNeg = i;
            }
            max = Math.max(max, countNeg % 2 == 0 ? i - startZero : i - firstNeg);//note pos product, so no +1
            //if even neg then count all from start to i. If odd, then just the first neg one to current one eg.[-1,-2,4,-3], when -3, just count to 4
        }
        return max;
    }
}
