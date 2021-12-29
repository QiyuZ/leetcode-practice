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
    private int count = 0;
    public int equalToDescendants(TreeNode root) { //from bottom to top to determine level by level
        if (root == null) return 0;
        calculateSum(root);
        return count;
    }
    private int calculateSum(TreeNode root) {
        if (root == null) return 0;
        int left = calculateSum(root.left), right = calculateSum(root.right);
        if (left + right == root.val) count++;
        return left + right + root.val;
    }
}
