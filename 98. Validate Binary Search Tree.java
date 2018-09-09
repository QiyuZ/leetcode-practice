class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return null;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int lower, int upper) {
        if (root == null) return true;
        if (root.val <= min || root.val >= upper) return false;
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
        //去了左边，parent node的val就是新的最大值， 去了左边，parent node的val就是新的最小值
    }
}
