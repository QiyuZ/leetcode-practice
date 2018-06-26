class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = nums[0]; 
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] upper = new int[nums.length - 1]; //因为有nums.length - 1的间隔
        int[] lower = new int[nums.length - 1];
        Arrays.fill(upper, Integer.MIN_VALUE);
        Arrays.fill(lower, Integer.MAX_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int index = (num - min) / gap; //根据和gap的距离确定分组
            upper[index] = Math.max(upper[index], num);
            lower[index] = Math.min(lower[index], num);
        }
        int res = Integer.MIN_VALUE;
        int pre = min;   //其实特殊情况，先让被减的=min，这样lower[i]就是连续min比它大的下一个
        for (int i = 0; i < upper.length; i++) {
            if (upper[i] == Integer.MIN_VALUE && lower[i] == Integer.MAX_VALUE) continue;
            res = Math.max(res, lower[i] - pre);
            pre = upper[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
/*bucket sort
最大gap肯定大于等于 (max - min) / (n - 1) ，所以以此划分组，上下限，gap=下一个的区间的max-上一个区间的min，特殊考虑min和max
*/
