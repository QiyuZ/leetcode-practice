class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0);
    }
    public List<Integer> helper(int[] nums, int pos) { //记忆化DFS
        if (map.containsKey(pos)) return map.get(pos);
        List<Integer> res = new ArrayList<>();
        int div = pos == 0 ? 1 : nums[pos - 1]; //开始第一个数前面没有，用1
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] % div == 0) {
                List<Integer> cur = new ArrayList<>(helper(nums, i + 1)); //可以除尽就接着走并且把当前放进去
                cur.add(nums[i]);
                if (cur.size() > res.size()) res = cur; //update
            }
        }
        map.put(pos, res);
        return res;
    }
}
