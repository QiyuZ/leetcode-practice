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
    public int rangeSumBST(TreeNode root, int L, int R) {
        int res = 0;
        if (root == null) return res;
        if (root.val >= L && root.val <= R) {
            res += root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R); //后面两个别忘了，要接下去走
        }
        else if (root.val < L) res += rangeSumBST(root.right, L, R);
        else res += rangeSumBST(root.left, L, R);
        return res;
    }
}
