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
    int count;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode node) {
        if (node.left != null) helper(node.left);
        count--;
        if (count == 0) {
            res = node.val;
            return;
        }
        if (node.right != null) helper(node.right);
    }
}
