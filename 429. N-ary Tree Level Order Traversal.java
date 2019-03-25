/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                list.add(cur.val);
                for (Node child : cur.children) {
                    if (child != null) queue.offer(child);
                }
            }
            res.add(list);
        }
        return res;
    }
}

//dfs
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>(); 
        dfs(root, 0, results);   
        return results;
    }
    private void dfs(Node node, int level, List<List<Integer>> results) {
        if (node == null) return; 
        List<Integer> list = new ArrayList<>();
        if (results.size() > level) {  //size比这个大说明已经有了这个list则加入原来的
            list = results.get(level);
            list.add(node.val);
        } else { //没有则用新的，再加入这个list
            list.add(node.val);
            results.add(list);
        }
        for (Node n : node.children) {
            dfs(n, level + 1, results);
        }
    }
}
