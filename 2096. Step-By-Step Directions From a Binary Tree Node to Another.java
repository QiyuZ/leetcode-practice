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
 
    private String start, dest;
    private StringBuilder path = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        int i = 0;
        StringBuilder output = new StringBuilder();
        getDirection(startValue, destValue, root);
        while (i < start.length() && i < dest.length() && start.charAt(i) == dest.charAt(i)) i++; //we just need the lowest common ancestor, so maybe there are common parts like firstly going left (LLLRL, LLLRR), so ignore first common parts
        for (int j = i; j < start.length(); j++) output.append('U');
        for (int j = i; j < dest.length(); j++) output.append(dest.charAt(j));
        return output.toString();
    }

    private void getDirection(int startValue, int destValue, TreeNode root) {
        if (root == null) return;
        if (startValue == root.val) start = path.toString();
        else if (destValue == root.val) dest = path.toString();
        path.append('L');
        getDirection(startValue, destValue, root.left);
        path.setCharAt(path.length() - 1, 'R');//no return means last dir is not correct, then replace with r and keep going
        getDirection(startValue, destValue, root.right);
        path.setLength(path.length() - 1);
    }
  
}
