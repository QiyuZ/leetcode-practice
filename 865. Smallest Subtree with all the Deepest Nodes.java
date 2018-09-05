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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        Map<TreeNode, Integer> map = new HashMap<>(); //储存每个node的深度，记忆化
        depth(root, map);
        return dfs(root, map); //找到最深的
    }
    public int depth(TreeNode root, Map<TreeNode, Integer> map) { //找深度
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root); //如果原来有，直接返回
        int max = Math.max(depth(root.left, map), depth(root.right, map)) + 1; //别忘了+1
        map.put(root, max);
        return max;
    }
    public TreeNode dfs(TreeNode root, Map<TreeNode, Integer> map) {
        int left = depth(root.left, map);
        int right = depth(root.right, map);
        if (left == right) return root; //因为是从上到下，所以找第一个相等的
        else if (left > right) return dfs(root.left, map);
        else return dfs(root.right, map);
    }
}
