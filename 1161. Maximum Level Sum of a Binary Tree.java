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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0, maxSum = 0, res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            level++;
            for (int count = 0; count < size; count++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                res = level;
            }
        }
        return res;
    }
}
