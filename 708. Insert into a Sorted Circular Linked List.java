/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node cur = new Node(insertVal);
            cur.next = cur;
            return cur;
        }
        Node pre = head, cur = head.next;
        while (cur != head) {  //防止一直循环下去，cur最多停在head
            if (insertVal >= pre.val && insertVal <= cur.val) break; //in the middle 3->(4)->5，只有此处包括等号防止开头结尾相等 
            if (pre.val > cur.val && insertVal > pre.val) break; //3->4->5->3, 3,5之间放7 成为新结尾
            if (pre.val > cur.val && insertVal < cur.val) break; //3->4->5->3, 3,5之间放1 成为新开头
            pre = cur;
            cur = cur.next;
        }
        Node newNode = new Node(insertVal);
        pre.next = newNode;
        newNode.next = cur;
        return head;
    }
}
