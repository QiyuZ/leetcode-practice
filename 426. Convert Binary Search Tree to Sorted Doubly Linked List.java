/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) { //中序遍历，正反相连，最后头尾相接
        if (root == null) return null;
        Node first = null, last = null;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null) first = root; 
            if (last != null) {
                last.right = root;
                root.left = last;
            }
            last = root;
            root = root.right;
        }
        first.left = last;
        last.right = first;
        return first;
    }
}

class Solution {
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        pre = dummy;
        helper(root);
        pre.right = dummy.right;//此时pre在最后，dummy还在开头，左右相连
        dummy.right.left = pre;
        return dummy.right;
    }
    public void helper(Node cur) {//inorder时左右连接
        if (cur == null) return;
        helper(cur.left);
        pre.right = cur;
        cur.left = pre;
        pre = pre.right; //更新pre
        helper(cur.right);
    }
}
