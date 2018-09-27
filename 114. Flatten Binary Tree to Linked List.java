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
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right); //先右边因为最后一个要最先访问作为pre加上去。比如2,3,4， 形成的时候是4->3,4->2,3,4,就是右左中的顺序
        flatten(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }
}
