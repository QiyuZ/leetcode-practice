class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null || root.right == null) return root.left == null ? root.right : root.left;
            root.val = getMin(root.right); //要删除这个点，就要找个替换的，要找右子树的最小或者左子树的最大
            root.right = deleteNode(root.right, root.val); //替换完以后要删除右边那个最小的
        }
        return root;
    }
    public int getMin (TreeNode node) {
        int min = node.val;
        while (node.left != null) {
            node = node.left;
            min = node.val;
        }
        return min;
    }
}
