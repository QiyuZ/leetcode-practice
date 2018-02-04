class Solution {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}

class Solution {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
