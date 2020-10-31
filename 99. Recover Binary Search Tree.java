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
    private TreeNode first = null, second = null, pre = null;
    public void recoverTree(TreeNode root) {
        findTwo(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void findTwo(TreeNode root) {
        if (root == null) return;
        findTwo(root.left);
        if (pre != null && pre.val > root.val && first == null) first = pre;//要两个if都并列
        if (pre != null && pre.val > root.val && first != null) second = root;
        //注意此处是找前面的大的和后面的小的交换，因为大的本来就要在后面不可以再换到前面
        //所以对于first找大的即pre，second找小的即root
        pre = root;
        findTwo(root.right);
    }
}

/*
注意不可以写成
if(pre.val > root.val) {
    if (first == null) first = pre;
    else second = root;
}
这两个要同时因为可能并列 1274564 一个if就行，但是如果132这个时候就找不到2了
first 取前面的 second取后面的，因为找大的放在后面，找小的放在前面
*/
