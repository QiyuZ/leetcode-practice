/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        int count = 0;
        ListNode cur = head;
        while (count != k && cur != null) { //找下个group的初始节点
            cur = cur.next;
            count++;
        }
        if (count != k) return head;
        cur = reverseKGroup(cur, k);
        while (count > 0) {
            count--;
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        while (true) {
            ListNode p = start;
            ListNode c, n = p;
            start = p.next;
            for(int i = 0; i < k && n != null; i++) n = n.next;
            if(n == null) break;
            for(int i = 0; i < k-1; i++) {
                c = p.next;
                p.next = c.next;
                c.next = n.next;
                n.next = c;
            }
        }
        return dummy.next;
    }
}
