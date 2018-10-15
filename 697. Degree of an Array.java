class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new int[] {1, i, i});
            else {
                int[] cur = map.get(nums[i]);
                cur[0]++;
                cur[2] = i;
                map.put(nums[i], cur);
            }
        }
        int count = Integer.MIN_VALUE, res = 0;
        for (int[] num : map.values()) {
            if (num[0] > count) {
                count = num[0];
                res = num[2] - num[1] + 1;
            } else if (num[0] == count) res = Math.min(res, num[2] - num[1] + 1);
        }
        return res;
    }
}
