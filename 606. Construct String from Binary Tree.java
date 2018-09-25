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
    public String tree2str(TreeNode t) {
        String res = "";
        if (t == null) return res;
        res += t.val;
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left == "" && right == "") return res;
        else if (left == "")  res = res + "()" + "(" + right + ")";
        else if (right == "")  res = res + "(" + left + ")";
        else res = res + "(" + left + ")" + "(" + right + ")";
        return res;
    }
}
