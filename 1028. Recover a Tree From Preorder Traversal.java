/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //因为是preorder,可以看出是左边1，2，3层然后右边1，2，3层
    private int index = 0; 
    public TreeNode recoverFromPreorder(String S) {
        return dfs(S, 0);
    }
    
    private TreeNode dfs(String s, int depth) {
        int num = 0;
        while ((index + num) < s.length() && s.charAt(index + num) == '-') num++;
        if (num != depth) return null; //没有当前层数
        int next = index + num;
        while (next < s.length() && s.charAt(next) != '-') next++;
        int val = Integer.parseInt(s.substring(index + num, next));
        index = next; //更新下一个开始的位置，因为右子树全部都在左子树后面，所以不用担心有遗漏
        TreeNode root = new TreeNode(val);
        root.left = dfs(s, depth + 1);
        root.right = dfs(s, depth + 1); //因为index会更新到后面
        return root;
    }
}
