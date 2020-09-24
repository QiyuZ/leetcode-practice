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
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        convertToString(root, sb);
        sb.setLength(sb.length() - 1); //最后多一个，
        return sb.toString();
    }
    
    private void convertToString(Node root, StringBuilder sb) {
        sb.append(root.val).append(",");
        sb.append(root.children.size()).append(","); //保持generic即使是0也加上
        for (Node child : root.children) convertToString(child, sb);
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(","))); //one line add all elements
        return buildNode(queue);
    }
    
    private Node buildNode(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        Node root = new Node(Integer.parseInt(queue.poll()));
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>();
        for (int i = 0; i < size; i++) root.children.add(buildNode(queue));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
