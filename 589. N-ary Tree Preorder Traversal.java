class Solution {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (Node children : root.children) preorder(children);
        return res;
    }
}

class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            int size = cur.children.size();
            for (int i = size - 1; i >= 0; i--) {
                Node child = cur.children.get(i);
                if (child != null) stack.add(child);
            }
        }
        return res;
    }
}
