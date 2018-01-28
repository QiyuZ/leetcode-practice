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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }
    public int[] helper(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int dec = 1, inc = 1;
        if (node.left != null) {
            if (node.val - node.left.val == 1) dec = left[0] + 1;
            else if (node.left.val - node.val == 1) inc = left[1] + 1;
        }
        if (node.right != null) {
            //这里需要注意dec, inc 需要Math.max判断因为之前计算过了
            if (node.val - node.right.val == 1) dec = Math.max(dec, right[0] + 1); 
            else if (node.right.val - node.val == 1) inc = Math.max(inc, right[1] + 1);
        }
        max = Math.max(max, inc + dec - 1);//node本身算上去了两次减去一次重复的
        return new int[] {dec, inc};
    }
}
