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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    public int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val; //0为要rob当前，那么要加当前的和左右两边相邻没有rob的
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //1表示不rob当前的，那么左右两边有没有rob没关系，所以找最大的
        return res;
    }
}
