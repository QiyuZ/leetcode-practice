class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int max = Integer.MIN_VALUE, maxIndex = -1;
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        int fromLeft = Math.max(maxIndex, minIndex) + 1;
        int fromRight = n - Math.min(maxIndex, minIndex); 
        int maxToMin = (maxIndex + 1) + (n - minIndex);
        int minToMax = (minIndex + 1) + (n - maxIndex);
        return Math.min(Math.min(Math.min(maxToMin, minToMax), fromRight), fromLeft);
    }
}
