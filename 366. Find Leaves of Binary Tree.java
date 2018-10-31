class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> cur = new ArrayList<>();
            root = helper(cur, root);
            res.add(cur);
        }
        return res;
    }
    public TreeNode helper(List<Integer> cur, TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            cur.add(root.val);
            root = null;
        } else {
            root.left = helper(cur, root.left);
            root.right = helper(cur, root.right);
        }
        return root;
    }
}
