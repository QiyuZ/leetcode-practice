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
public class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int j = 0;
        while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) j++; // the first must be digits and could be negative
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, j)));
        if (j < s.length()) { //left existed
            int i = j;
            int count = 0;
            while (j < s.length()) {
                if (s.charAt(j) == ')') count--;
                if (s.charAt(j) == '(') count++;
                if (count == 0) break; //until balanced
                j++;
            }
            root.left = str2tree(s.substring(i + 1, j)); // note we need i + 1 here to get rid of the first left parathesis, note we wanna exclude the last )
        }
        if (j + 2 < s.length()) { //right existed, now j is at left node's last ), so +2 is check the val of right node
            root.right = str2tree(s.substring(j + 2, s.length() - 1)); //note it's s.length() - 1, as we wanna exclude the last )
        }
        return root;
    }
}
