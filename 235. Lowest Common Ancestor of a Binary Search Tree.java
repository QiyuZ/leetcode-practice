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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null && q == null) return null;
        if (p == root || q == root) return root; //这个很重要，因为pq可能就是parent-child root不一定就是parent可能等于p或q
        if (p == null) return q;
        if (q == null) return p;
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) return root;
        else if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);
    }
}
