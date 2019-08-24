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
    private int res = 0;
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1; //从下往上， 向上传递需要多少或者需要往上移动多少，所以上一行用abs
    }
}
