//recursive
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        flattentail(head);
        return head;
    }
    
    //return the tail of the current branch...
    private Node flattentail(Node cur) {
        if (cur.child != null) {
            Node tail = flattentail(cur.child);
            tail.next = cur.next;
            if (cur.next != null) cur.next.prev = tail;
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
        }
        if (cur.next == null) return cur;
        return flattentail(cur.next);
    }
}

//iterative
class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Stack<Node> stack = new Stack<>();
        Node root = head;
        while (root != null) {
            if (root.child != null) {
                Node next = root.next;
                Node child = root.child;
                root.next = child; //注意是双向，要前后都连接
                child.prev = root;
                if (next != null) stack.push(next);//非null才push
                root.child = null; //注意移动完child要标为null
            }
            if (root.next == null && !stack.isEmpty()) {
                Node next = stack.pop();
                root.next = next; //连到后面继续遍历
                next.prev = root;
            }
            root = root.next;
        }
        return head;
    }
}
