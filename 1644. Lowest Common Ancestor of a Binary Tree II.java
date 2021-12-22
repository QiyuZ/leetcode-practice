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
    private int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findLCA(root, p, q);
        return count != 2 ? null : lca;
    }
    
    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {// from bottom to top to find the target node
        if (root == null) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (root == p || root == q) { //one is under another one
            count++;
            return root;
        }
        if (left == null && right == null) return null; // doesnt exist
        if (left != null && right != null) return root; //one in left and one in right
        return left == null ? right : left;
    }

}
