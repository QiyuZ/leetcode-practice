public class Solution { //这个保证两个children,117不保证
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}

class Solution { //level traversal without extra space
    public Node connect(Node root) {
        if (root == null) return root;
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                if (head.left != null) head.left.next = head.right;
                if (head.next != null && head.right != null) head.right.next = head.next.left;
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
