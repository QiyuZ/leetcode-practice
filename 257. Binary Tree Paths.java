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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, "", root);
        return res;
    }
    public void helper(List<String> res, String cur, TreeNode root) {
        if (root.left == null && root.right == null) res.add(cur + root.val); //要找到路径，所以必须左右都是null才完
        if (root.left != null) helper(res, cur + root.val + "->", root.left); //哪边不是null就继续走
        if (root.right != null) helper(res, cur + root.val + "->", root.right);
    }
}
