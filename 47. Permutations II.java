class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue; //skip duplicate one, like [1,1,2], the first and second 1 can all form 1,1,2 , so skip the second one
            used[i] = true;
            temp.add(nums[i]);
            helper(res, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
