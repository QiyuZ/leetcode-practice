class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        for (int i = 0; i < nums.length; i++) nums[i] = nums[i] == 0 ? -1 : nums[i]; //变为-1这样和为0
        Map<Integer, Integer> map = new HashMap<>(); //空间换时间，类似2sum
        map.put(0, -1); //相当于-1,1有两位要1-（-1）
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) res = Math.max(res, i - map.get(sum));
            else map.put(sum, i);
        }
        return res;
    }
}
