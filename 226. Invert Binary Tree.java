/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertTree(root.left);
        invertTree(root.right);//要把root放在最后，否则root会溯回两次就又变回原来的了
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) { 
        if (root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

//also could use stack or queue to do iteration
