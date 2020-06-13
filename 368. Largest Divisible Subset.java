class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();//keep as memory
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);//sort后可以从小开始
        return findSubset(nums, 0);
    }
    private List<Integer> findSubset(int[] nums, int i) {
        if (i == nums.length) return new ArrayList<>(); //防止越界
        if (map.containsKey(i)) return map.get(i);
        int div = i == 0 ? 1 : nums[i - 1];//如果是起始值可以看做直接加入，否则要除以上一位，因为下面是往后走一位
        List<Integer> res = new ArrayList<>();
        for (int j = i; j < nums.length; j++) {
            if (nums[j] % div == 0) {
                List<Integer> cur = new ArrayList<>(findSubset(nums, j + 1));
                //很重要，just copy value，否则会修改reference后面会重复加值，因为前面计算过了
                cur.add(nums[j]);
                if (cur.size() > res.size()) res = cur;
            }
        }
        map.put(i, res);
        return res;
    }
}
