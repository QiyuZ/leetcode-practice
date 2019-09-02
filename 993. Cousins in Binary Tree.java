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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean a = false, b = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) a = true;
                if (cur.val == y) b = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y) return false;
                    if (cur.right.val == x && cur.left.val == y) return false;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (a && b) return true;
            a = false; b = false;
        }
        return false;
    }
}
