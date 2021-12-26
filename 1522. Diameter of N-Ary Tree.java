/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int diameters;
    public int diameter(Node root) {
        this.diameters = 0;
        calculateHeight(root);
        return this.diameters;
    }
    private int calculateHeight(Node root) { //from bottom to top, and update diameter at every node, then backs to parent level with longest node
        if (root == null) return 0;
        int max1 = 0, max2 = 0;
        for (Node child : root.children) {
            int height = calculateHeight(child);
            if (height > max1) {
                max2 = max1;
                max1 = height;
            } else if (height > max2) max2 = height;
        }
        this.diameters = Math.max(this.diameters, max1 + max2); //at every node, calculate the diameters
        return max1 + 1; //when it backs to parent level, it should only provides the longest one
    }
}
