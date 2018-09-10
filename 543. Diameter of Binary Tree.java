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
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return max;
    }
    public int depth (TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right); //5213也是4，所以就是查左右两边加起来最多多深
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
