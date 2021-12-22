/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//similar as 1644. Lowest Common Ancestor of a Binary Tree II
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> checks = new HashSet<>();
        for (TreeNode node : nodes) checks.add(node.val);
        return findLCA(root, checks);
    }
    
    private TreeNode findLCA(TreeNode root, Set<Integer> checks) {
        if (root == null || checks.contains(root.val)) return root;
        TreeNode left = findLCA(root.left, checks);
        TreeNode right = findLCA(root.right, checks);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
