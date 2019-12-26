/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int i = 0, j = 0;
        while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) j++;
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, j)));
        if (j < s.length()) {
            i = j;
            int count = 1;
            while (j < s.length() && count != 0) {
                j++;
                if (s.charAt(j) == ')') count--;
                if (s.charAt(j) == '(') count++;
            }
            root.left = str2tree(s.substring(i + 1, j));
        }
        if (j + 2 < s.length()) {
            root.right = str2tree(s.substring(j + 2, s.length() - 1));
        }
        return root;
    }
}
