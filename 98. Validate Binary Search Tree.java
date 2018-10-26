/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//inorder traversal 左<根<y右
//iteration
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (cur.val <= pre) return false;
            root = cur.right;
            pre = cur.val;
        }
        return true;
    }
}

//recursive
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
