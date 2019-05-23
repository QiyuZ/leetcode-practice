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
    private Integer res = Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre.val);
        pre = root;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}
//因为是BST，所以中序遍历就是递增，然后就一个个比较找出最小的，其实就是中序遍历嵌套比较，就是530
