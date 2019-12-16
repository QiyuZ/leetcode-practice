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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return helper(null, root, 0);
    }
    private int helper(TreeNode parent, TreeNode node, int currLong){
        if(node == null) return currLong;
        int childCurrLong = parent != null && parent.val + 1 == node.val ? currLong + 1 : 1;
        int l = helper(node, node.left, childCurrLong);
        int r = helper(node, node.right, childCurrLong);
        return Math.max(Math.max(l, r), childCurrLong);
    }
}
