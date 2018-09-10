/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(res.label, res); //初始化map，queue； ，queue放被clone的node，map中放res每次遍历queue中cur在上面clone
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode n : cur.neighbors) {
                if (!map.containsKey(n.label)) {
                    map.put(n.label, new UndirectedGraphNode(n.label)); //注意此处不可以直接put(n.label, n) 因为有包含关系有很多不可以直接放
                    queue.offer(n);
                }
                map.get(cur.label).neighbors.add(map.get(n.label));
            }
        }
        return res;
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
