class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) res.add(new ArrayList<Integer>(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                temp.add(nums[i]);
                helper(res, temp, nums, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
   
