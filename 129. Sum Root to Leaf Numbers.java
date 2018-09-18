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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 0);
    }
    public int helper(TreeNode root, int cur) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return cur * 10 + root.val; //到了尽头计算当前值，返回
        return helper(root.left, cur * 10 + root.val) + helper(root.right, cur * 10 + root.val); //不是尽头，计算左右值
    }
}
