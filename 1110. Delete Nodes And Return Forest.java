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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) set.add(num);
        List<TreeNode> list = new ArrayList<>();
        TreeNode newRoot = helper(root, set, list);
        if (newRoot != null) list.add(newRoot);
        return list;
    }
    
    private TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> list) {
        if (root == null) return null;
        root.left = helper(root.left, set, list);
        root.right = helper(root.right, set, list);
        if (set.contains(root.val)) {
            if (root.left != null) list.add(root.left);
            if (root.right != null) list.add(root.right);
            return null;
        }
        return root;
    }
}
