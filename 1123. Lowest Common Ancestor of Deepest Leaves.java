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
    TreeNode res = null;
    int deepest = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return res;
    }
    private int helper(TreeNode root, int depth) { //这种自下往上的都要postorder
        deepest = Math.max(deepest, depth); //不管是不是null都要更新深度，计算当前深度的同时更新最大深度，然后标记最大深度的tree为res
        if (root == null) return depth;
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (left == deepest && right == deepest) {
            res = root;
        }
        return Math.max(left, right);
    }
}
