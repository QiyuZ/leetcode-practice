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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        getPathSum(res, new ArrayList<>(), root, sum, 0);
        return res;
    }
    private void getPathSum(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum, int cur) {
        if (root == null) return;
        if (root.left == null && root.right == null && cur + root.val == sum) {
            temp.add(root.val);
            res.add(new ArrayList<>(temp));//这里要copy一下，不然recursive里会被refer
            temp.remove(temp.size() - 1); //注意此处也要remove否则上次的最后一个会留在这里，或者line 33,34 重新new ArrayList
            return;
        }
        int size = temp.size();
        temp.add(root.val);
        getPathSum(res, temp, root.left, sum, cur + root.val);
        getPathSum(res, temp, root.right, sum, cur + root.val);
        temp.remove(size);
    }
}
