/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); //note this is a new listnode for the result, wont connect with head
        ListNode pre = dummy;
        while (head != null) {
            ListNode next = head.next;
            if (pre.val >= head.val) pre = dummy; //we put the smaller one every time to the front. If head's val is smaller then we need pre go back to the beginning
            while(pre.next != null && head.val >= pre.next.val) pre = pre.next; //get where to insert, so find the place just smaller than head's val till to end, like 0-1-2-5, and head is 4, then it should at pre=2
            head.next = pre.next; //insert into pre and pre.next
            pre.next = head;
            head = next;
        }
        return dummy.next;
    }
}

