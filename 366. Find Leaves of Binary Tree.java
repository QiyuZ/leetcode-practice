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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getLeavesByDepth(res, root);
        return res;
    }
    private int getLeavesByDepth(List<List<Integer>> res, TreeNode root) { //note, it means the depth of current node not which level the node is at
        if (root == null) return -1; //note, coz we will add 1 as res.size, so here need default to -1
        int left = getLeavesByDepth(res, root.left), right = getLeavesByDepth(res, root.right); //from bottom to top to achieve O(n), so call method first
        int depth = Math.max(left, right) + 1;
        if (res.size() == depth) res.add(new ArrayList<>()); //new depth means there's no such list for it
        res.get(depth).add(root.val);
        root.left = root.right = null; //remove its leaves
        return depth;
    }
}
