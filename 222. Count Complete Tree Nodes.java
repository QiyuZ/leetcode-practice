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
    public int countNodes(TreeNode root) {
        int leftHeight = leftHeight(root);
	    int rightHeight = rightHeight(root);
        return (leftHeight == rightHeight) ? (int)(Math.pow(2, leftHeight) - 1) : 1 + countNodes(root.left) + countNodes(root.right); 
        //全部Complete 就直接算，否则就分治， 因为左边是Complete 所以每次都直接算出来，直到不Complete 的右边
    }
    
    private int leftHeight(TreeNode root) {
        return root == null ? 0 : 1 + leftHeight(root.left);
    }
    
    private int rightHeight(TreeNode root) {
        return root == null ? 0 : 1 + rightHeight(root.right);
    }
}
