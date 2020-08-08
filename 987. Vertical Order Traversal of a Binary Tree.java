/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //dfs
    public List<List<Integer>> verticalTraversal(TreeNode root) { //刚开始只表达了x发现顺序不对，所以加上y也就是深度，都按照大小排序
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>(); //用list原因是可能位置坐标重复，比如第三层，第二层左子树的右节点和右子树的左节点
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (int x : map.keySet()) {
            List<Integer> cur = new ArrayList<>();
            for (int y : map.get(x).keySet()) {
                List<Integer> values = map.get(x).get(y);
                Collections.sort(values);
                for (int i = 0; i < values.size(); i++) cur.add(values.get(i));
            }
            list.add(cur);
        }
        return list;
    }
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) return;
        if (!map.containsKey(x)) map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y)) map.get(x).put(y, new ArrayList<>());
        map.get(x).get(y).add(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}


class Solution { //bfs
    private int max = 0, min = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        countRange(root, 0);
        for (int i = min; i <= max; i++) res.add(new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                int index = cur.index + Math.abs(min); //note, min is negative
                if (!map.containsKey(index)) map.put(index, new PriorityQueue<>());
                map.get(index).offer(cur.node.val);
                if (cur.node.left != null) queue.offer(new Node(cur.node.left, cur.index - 1));
                if (cur.node.right != null) queue.offer(new Node(cur.node.right, cur.index + 1));
            }
            for (int key : map.keySet()) {
                PriorityQueue<Integer> pq = map.get(key);
                while (!pq.isEmpty()) res.get(key).add(pq.poll());
            }
        }
        return res;
    }
    
    private void countRange(TreeNode root, int index) {
        if (root == null) return;
        max = Math.max(max, index);
        min = Math.min(min, index);
        countRange(root.left, index - 1);
        countRange(root.right, index + 1);
    }
    
    class Node {
        private TreeNode node;
        private int index;
        public Node(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
