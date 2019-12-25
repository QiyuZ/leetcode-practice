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
    private double res = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        postOrder(root);
        return res;
    }
    private double[] postOrder(TreeNode root) {
        if (root == null) return new double[] {0, 0}; //sum, count
        double[] left = postOrder(root.left);
        double[] right = postOrder(root.right);
        double sum = left[0] + right[0] + root.val, count = left[1] + right[1] + 1; //don't forget add root.val and count itself
        res = Math.max(res, sum / count);
        return new double[] {sum, count};
    }
}
