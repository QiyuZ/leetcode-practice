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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));//因为下一层比上一层个数翻倍，则规律左边为index * 2 - 1，右边为index * 2
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = -1, right = -1;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i == 0) left = cur.index;
                if (i == size - 1) right = cur.index;//不能else if如果只有一个节点那么left==right都要被相同赋值
                if (cur.tree.left != null) queue.offer(new Node(cur.tree.left, cur.index * 2 - 1));
                if (cur.tree.right != null) queue.offer(new Node(cur.tree.right, cur.index * 2));
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
    
    class Node {
        private TreeNode tree;
        private int index;
        public Node (TreeNode tree, int index) {
            this.tree = tree;
            this.index = index;
        }
    }
}
