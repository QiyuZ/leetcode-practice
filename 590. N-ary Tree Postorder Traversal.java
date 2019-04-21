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
    private List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return res;
        for (Node node : root.children) postorder(node);
        res.add(root.val);
        return res;
    }
}

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;  
        Stack<Node> stack = new Stack<>();
        stack.add(root); 
        while(!stack.isEmpty()) {
            root = stack.pop();
            if (list.size() == 0) list.add(root.val);
            else list.add(0, root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        return list;
    }
}
