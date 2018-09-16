class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        dfs(res, cur, 0, nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
        if (cur.size() >= 2) res.add(new ArrayList<>(cur));
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) continue; //防止重复计算，比如4,4,6 第一个4放入set第二个4就跳过了，但是44不会跳过（每次new set的原因）
            if (cur.size() == 0 || (cur.size() > 0 && nums[i] >= cur.get(cur.size() - 1))) {
                cur.add(nums[i]);
                set.add(nums[i]);
                dfs(res, cur, i + 1, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
