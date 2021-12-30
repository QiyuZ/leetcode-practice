/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val)); //只有这一个需要不判断直接放入，所以是个特例放在最前面先加入
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : cur.neighbors) {
                if (!map.containsKey(next)) {
                    map.put(next, new Node(next.val));
                    queue.offer(next);  //注意只有之前没走过的才放入queue中，否则如果是个环就无限循环了
                } 
                map.get(cur).neighbors.add(map.get(next));//注意即使map中存在这个也要加入neighbors
            }
        }
        return map.get(node);
    }
}

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        return doClone(root, map);
    }
    
    private NodeCopy doClone(Node root, Map<Node, NodeCopy> map) {
        if (root == null) return null;
        if (map.containsKey(root)) return map.get(root);
        NodeCopy cur = new NodeCopy(root.val);
        map.put(root, cur);
        cur.left = doClone(root.left, map);
        cur.right = doClone(root.right, map);
        cur.random = doClone(root.random, map);
        return cur;
    }
}
