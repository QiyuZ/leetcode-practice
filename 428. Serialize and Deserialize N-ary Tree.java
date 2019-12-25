/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new ArrayList<>();
        buildString(root, list);
        return String.join(",", list);
    }
    
    private void buildString(Node root, List<String> list) {
        if (root == null) return;
        list.add(root.val + "");
        list.add(root.children.size() + ""); //记录size,后面解析的时候只需要循环这么多次，即使是0
        for (Node child : root.children) buildString(child, list);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildNode(queue);
    }
    
    private Node buildNode(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        Node root = new Node(Integer.parseInt(queue.poll()));
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            root.children.add(buildNode(queue));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
