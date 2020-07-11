class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> temp = new ArrayList<>();
        helper(res, nums, 0, temp);
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, int index, List<Integer> list) {
        res.add(new ArrayList<Integer>(list)); //因为是所有子集，所以只要有变化就加进去，包括开头的空集
        //注意要新建，否则temp backtrack时会变化,要放在开头而不是for里面，因为每次加了新元素都要放进去
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
//https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
