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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        dfs(root.left, true, false, res);
        dfs(root.right, false, true, res);
        return res;
    }
    
    private void dfs(TreeNode root, boolean isLeftBound, boolean isRightBound, List<Integer> res) {
        if (root == null) return;
        if (isLeftBound) res.add(root.val); //注意顺序，相当于左中右
        dfs(root.left, isLeftBound, isRightBound && root.right == null, res); //向左边，左边的判断不会变因为一直向左，而rightBound只有在右子树没有的条件下才成立
        if (!isLeftBound && !isRightBound && root.left == null && root.right == null) res.add(root.val); //leaves既不是左右边界又没有左右子树
        dfs(root.right, isLeftBound && root.left == null, isRightBound, res); //注意此处要先dfs,因为逆时针相当于从下到上
        if (isRightBound) res.add(root.val);
    }
}
