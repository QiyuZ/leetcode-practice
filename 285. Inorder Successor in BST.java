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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null; //可能是null,比如例子2的6（最后一个）
        if (root == null) return res;
        while (root != null) {
            if (p.val < root.val) { 
                //利用性质，root.val一定比p.val大或者是null，可能是结果，先把它作为res，再接着往左走，直到走不动
                res = root;
                root = root.left;
            } else root = root.right;
        } 
        return res;
    }
}
