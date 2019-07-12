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
    private TreeNode pre = null, head = null;
    public TreeNode increasingBST(TreeNode root) { //inorder 的形势
        if (root == null) return null;
        increasingBST(root.left);
        if (pre != null) { //之前赋予了最左点
            root.left = null; //剪枝，清空左边
            pre.right = root; //把当前放到右边
        }
        pre = pre == null ? root : pre.right;
        if (head == null) head = root; //记录起始点，只用一次，返回这个节点
        increasingBST(root.right);
        return head;
    }
}

