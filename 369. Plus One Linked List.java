/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, lastNot9 = null;
        while (cur != null) {
            if (cur.val != 9) lastNot9 = cur; //找到最后一个位置不是9的比如 199的1， 1293的3，然后这个位置+1，后面的9（如果有）变0
            cur = cur.next;
        }
        lastNot9.val += 1;
        cur = lastNot9.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return dummy.val == 1 ? dummy : dummy.next;
    }
}
