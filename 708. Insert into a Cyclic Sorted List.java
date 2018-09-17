/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node cur = head;
        Node next = cur.next;
        while (true) { //因为这个是loop没null的情况
            if (cur.val <= insertVal && insertVal <= next.val //在之间
               || cur.val >= next.val && next.val >= insertVal //cur.val >= next.val说明到了最后，cur是tail, next是head，insertVal最小
               || cur.val >= next.val && insertVal >= cur.val) { //同理到了最后，不过insertVal最大
                Node insert = new Node(insertVal, null); //不管三种情况哪个都要插入之间
                cur.next = insert;
                insert.next = next;
                break;
            }
            cur = next;
            next = next.next;
        }
        return head;
    }
}
