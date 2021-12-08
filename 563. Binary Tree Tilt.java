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
    private int res = 0;
    public int findTilt(TreeNode root) { //calculate the sum of the node from bottom to top, and get titl result during this process
        getSumOfTree(root);
        return res;
    }
    
    private int getSumOfTree(TreeNode root) {
        if (root == null) return 0;
        int left = getSumOfTree(root.left);
        int right = getSumOfTree(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
