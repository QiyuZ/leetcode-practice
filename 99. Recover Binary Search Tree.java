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
    TreeNode first = null, second = null, pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        swap(first, second);
    }
    
    public void inorderTraverse(TreeNode root) {
        if(root == null) return;
        inorderTraverse(root.left);
        //first wrong value will be bigger than current so first element = prev
        if(first == null && pre.val > root.val) first = pre;
        //second wrong value will be smaller than current so second element = root
        if(first != null && pre.val > root.val) second = root; 
        pre = root;
        inorderTraverse(root.right);
    }
    
    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
/*
不可以写成
if(pre.val > root.val) {
    if (first == null) first = pre;
    else second = pre;
}
这两个要同时因为可能并列 1274564 一个if就行，但是如果132这个时候就找不到2了
*/
