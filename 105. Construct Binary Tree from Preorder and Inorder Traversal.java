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
    HashMap<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();
    int pIndex = 0; //preIndex的顺序就是中左右，所以可以直接按照这个顺序来建树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i); //查询更快
        }
        return helper(0, preorder.length - 1, preorder);
    }
    private TreeNode helper(int left, int right, int[] preorder) {
        if (left > right) return null;
        int curr = preorder[pIndex++];
        TreeNode root = new TreeNode(curr);
        int index = inorderIndex.get(curr);
        root.left = helper(left, index - 1, preorder); //划分左右
        root.right = helper(index + 1, right, preorder);
        return root;
    }
}
