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
class Solution { //max product = (sum - that part's total) * that part's total
    private long sum, res = 0;
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        sum = getSum(root);
        bottomUp(root);
        return (int)(res % 1000000007);
    }
    
    private long getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
    
    private long bottomUp(TreeNode root) {
        if (root == null) return 0;
        long left = bottomUp(root.left);
        long right = bottomUp(root.right);
        long total = left + right + root.val;
        res = Math.max(res, (sum - total) * total); //every time see if we can get rid of this part
        return total;
    }
}
