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
