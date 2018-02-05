class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    public TreeNode helper(int preStart, int start, int end, int[] preorder, int[] inorder) {
        if (start > end || preStart > preorder.length - 1) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i = start; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = helper(preStart + 1, start, index - 1, preorder, inorder);
        root.right = helper(preStart + (index - start) + 1, index + 1, end, preorder, inorder);
        return root;
    }
}
