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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = robWithTwoCases(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] robWithTwoCases(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] res = new int[2];
        int[] left = robWithTwoCases(root.left), right = robWithTwoCases(root.right);
        res[0] = root.val + left[1] + right[1]; //index 0 alaways means rob current one, then we cant rob left and right, so we can only use left[1] and right[1]
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //index 1 means not rob current one, then for the left or right, note that it doesnt mean we must use left[0] or right[0], because we cant really tell it's that's the best case, so we just compare and find the larget one
        return res;
    }
}
