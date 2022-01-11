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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return res;
        getSum(root, 0);
        return res;
    }
    private void getSum(TreeNode root, int pre) {
        if(root == null) return;
        int cur = pre * 2 + root.val;
        if (root.left == null && root.right == null) { //only count when left and right are both null
            res += cur;
            return;
        }
        if(root.left != null) getSum(root.left, cur);
        if(root.right != null) getSum(root.right, cur);
    }
}
