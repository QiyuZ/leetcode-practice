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
    public List<TreeNode> allPossibleFBT(int N) { //递归，分别形成左右再拼接
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) return res;
        if (N == 1) { //这个很重要，因为任何递归都要有个底层的形成
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }
        for (int left = 1; left < N; left += 2) {
            List<TreeNode> leftNode = allPossibleFBT(left);
            List<TreeNode> rightNode = allPossibleFBT(N - left - 1);//-1是根
            for (TreeNode l : leftNode) {
                for (TreeNode r : rightNode) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
