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
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1]; //注意传递不能用int
        count[0] = 0;
        if (root == null) return 0;
        helper(root, count);
        return count[0]; 
    }
    public boolean helper(TreeNode node, int[] count) { //递归从下往上，左右都是相同的再判断这个子树
        if (node == null) return true;
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.left.val != node.val) return false;
            if (node.right != null && node.right.val != node.val) return false;
            count[0]++; 
            return true;
        }
        return false;
    }
}
