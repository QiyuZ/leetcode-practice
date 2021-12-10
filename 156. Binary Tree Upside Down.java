/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode res = upsideDownBinaryTree(root.left); //because most left one will be the new root, so we need to turn over from left bottom, and keep this one as res
        root.left.left = root.right; //root.left will be the new left and its left is root.right, and its right will be the previous root
        root.left.right = root;
        root.left = root.right = null; //unbond the old ones
        return res;
    }
}
