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
        if (head == null) return null;
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.child != null) {
                Node child = head.child;
                Node next = head.next;
                if (next != null) stack.push(next);
                head.child = null;
                head.next = child;
                child.prev = head;
            }
            if (head.next == null && !stack.isEmpty()) {
                Node next = stack.pop();
                next.prev = head;
                head.next = next;
            } 
            head = head.next;
        }
        return cur;
    }
}
