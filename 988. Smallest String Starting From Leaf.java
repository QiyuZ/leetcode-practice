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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    public String dfs(TreeNode node, String suffix) {
        if(null == node) return suffix;
        suffix = "" + (char)('a' + node.val) + suffix;
        if(null == node.left && null == node.right) return suffix;
        if(null == node.left || null == node.right) { 
            //这里很关键，如果有一个子树是null此时只能走一边因为比如4011,0没有右子树此时就会return一个stirng但其实这个有左子树还没有结束，不能比较这个字符串
            return (null == node.left)? dfs(node.right, suffix) :dfs(node.left, suffix);
        }
        String left = dfs(node.left, suffix);
        String right = dfs(node.right, suffix);
        return left.compareTo(right) <= 0 ? left: right;
    }
}
