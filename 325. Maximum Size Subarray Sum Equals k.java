class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = Integer.MIN_VALUE;    
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = Math.max(max, i + 1);
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if(!map.containsKey(sum)) map.put(sum, i); 
            //这里不能直接放，如果之前有就不放了，因为要保持i最小， 比如[1,0,-1],sum=1 应当存储i=0,而不是i=1
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
//相当于2Sum，sum一直递增，找到sum的位置，找到k的位置，找差值
