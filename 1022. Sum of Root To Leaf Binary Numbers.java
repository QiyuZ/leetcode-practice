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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return dfs(0, root);
    }
    
    private int dfs(int sum, TreeNode root) {
        if (root == null) return 0;
        sum = sum * 2 + root.val;
        if (root.left == null && root.right == null) return sum;
        return dfs(sum, root.left) + dfs(sum, root.right);
    }
}
