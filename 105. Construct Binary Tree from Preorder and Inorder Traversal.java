class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length, preorder, inorder);
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (inStart > inEnd || preStart >= preorder.length) return null;
        TreeNode cur = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                index = i;
                break;
            }
        }
        cur.left = helper(preStart + 1, inStart, index - 1, preorder, inorder); //下一个就是左子树的开头
        cur.right = helper(preStart + (index - inStart) + 1, index + 1, inEnd, preorder, inorder);//借助inStart和inEnd来确定这个子树的大小
                                      //加上大小后再移一位到新的子树，而inorder的下一个就是右子树
        return cur;
    }
}
//hint:preorder的每个开头都是一个节点，在inorder中找到它就能确定一边子树的大小
