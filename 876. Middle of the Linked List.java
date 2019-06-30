/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode root = head;
        while (root.next != null) {
            count++;
            root = root.next;
        }
        count = (count + 1) / 2;
        while (count-- > 0) head = head.next;
        return head;
    }
}


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){ //因为fast直接两个next所以要判断第一个next是不是null
            slow = slow.next;
            fast = fast.next.next;  
        }
        return slow;
    }
}