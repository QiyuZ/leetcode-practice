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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>(); //col index - list of node's val
        Queue<NodeWithCol> queue = new LinkedList<>();
        queue.offer(new NodeWithCol(root, 0));
        int max = 0, min = 0;
        while (!queue.isEmpty()) {
            NodeWithCol cur = queue.poll();
            TreeNode node = cur.node;
            int col = cur.col;
            if (!map.containsKey(col)) map.put(col, new ArrayList<>());
            map.get(col).add(node.val);
            min = Math.min(min, col); //count range while traversal 
            max = Math.max(max, col);
            if (node.left != null) queue.offer(new NodeWithCol(node.left, col - 1));
            if (node.right != null) queue.offer(new NodeWithCol(node.right, col + 1));
        }
        for (int i = min; i <= max; i++) res.add(map.get(i));
        return res;
    }
    
    class NodeWithCol {
        TreeNode node;
        int col;
        public NodeWithCol(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}


class Solution {
    private int min, max;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        countRange(root, 0); //找到左右两边范围
        for (int i = min; i <= max; i++) res.add(new ArrayList<Integer>()); //注意这里要=max
        Queue<TreeNode> queue = new LinkedList<>();//两个queue形成map,node和当前的col列数
        Queue<Integer> col = new LinkedList<>();
        queue.add(root);
        col.add(-min); //注意min是负数，当时前面res是从0开始，所以-min是root新的位置
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curCol = col.poll();
            res.get(curCol).add(curNode.val); //这里可以直接加入
            if (curNode.left != null) {
                queue.offer(curNode.left);
                col.offer(curCol - 1);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                col.offer(curCol + 1);
            }
        }
        return res;
    }
    public void countRange(TreeNode root, int index) {
        if (root == null) return;
        min = Math.min(min, index);
        max = Math.max(max, index);
        countRange(root.left, index - 1);
        countRange(root.right, index + 1);
    }
}
