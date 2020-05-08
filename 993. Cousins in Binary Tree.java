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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//因为在同一层，所以bfs一层层找
        boolean foundx = false, foundy = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) foundx = true;
                if (cur.val == y) foundy = true;
                if (cur.left != null && cur.right != null) { //not same parent
                    if (cur.left.val == x && cur.right.val == y) return false;
                    if (cur.left.val == y && cur.right.val == x) return false;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (foundx && foundy) return true; //必须两个有
            if (foundx || foundy) return false; //因为unique如果只有一个说明不同depth,不成立
        }
        return false;
    }
}
