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
    private int rootIndex = 0; //注意不可以作为参数，否则递归值会变
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        this.rootIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(inorder, postorder, map, 0, inorder.length - 1);//post找root,inorder分左右
    }
    private TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> map, int l, int r) {
        if (l > r || rootIndex < 0) return null;
        int rootVal = postorder[rootIndex--];//post root的值都在最后，所以以它找root
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTree(inorder, postorder, map, map.get(rootVal) + 1, r);//注意先右，因为postorder的下一个是右节点
        root.left = buildTree(inorder, postorder, map, l, map.get(rootVal) - 1);
        return root;
    }
}
