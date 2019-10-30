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
    
    private int left, right; 
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        int score = Math.max(left, Math.max(right, n - left - right - 1)); 
        //其实我可以占据三个部分，左右子树和parent,parent其实就是其他，比较这三个最大的是否能超过一半的n,因为整个树肯定都可以被填满
        return score > n / 2;
    }
    
    private int count(TreeNode root, int x) {
        if (root == null) return 0;
        int l = count(root.left, x);
        int r = count(root.right, x);
        if (root.val == x) {
            left = l; //因为recursive一直在走，只记录需要节点的左右子树个数即可
            right = r;
        }
        return l + r + 1; //+1是node本身
    }
}
