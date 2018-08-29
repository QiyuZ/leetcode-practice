/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> cur = new ArrayList<>();
        helper(root, sum, res, cur);
        return res;
    }
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(cur)); //这里要copy一下，不然recursive里会被reset
            cur.remove(cur.size() - 1); //注意两处移除，清除同一层的那个
            return;
        } else {
            helper(root.left, sum - root.val, res, cur);
            helper(root.right, sum - root.val, res, cur);
        }
        cur.remove(cur.size() - 1);
    }
}
