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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean hasEncounteredNullValue = false;
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current == null) hasEncounteredNullValue = true;
            else if (hasEncounteredNullValue) return false; //只有最后一个是null是才不会遇到这个，因为已经空了，中间有一个null而且不空就会false
            else {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }
}


