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
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right); //其实就是右根左的顺序
        root.val += pre;
        pre = root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
