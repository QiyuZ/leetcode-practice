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
    private List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return root;
        inorder(root);//inorder iteration is ordered
        return buildTree(0, list.size() - 1);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    private TreeNode buildTree(int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(l, mid - 1);
        root.right = buildTree(mid + 1, r);
        return root;
    }
}
