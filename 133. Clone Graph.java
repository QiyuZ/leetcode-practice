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

//DFS
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>(); //记录是否被访问
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode newClone = new UndirectedGraphNode(node.label);
        map.put(newClone.label, newClone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newClone.neighbors.add(clone(neighbor));
        }
        return newClone;
    }
}
