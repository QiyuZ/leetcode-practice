// iterative

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;//因为最后一位是null
        while (head != null) {
            ListNode next = head.next;
            head.next = newNode;
            newNode = head;
            next = head;
        }
        return newNode;
    }
}

// recursive

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        return helper(head, null);
    }
    public ListNode helper(ListNode head, ListNode newNode) {
        if (head == null) return newNode;
        ListNode next = head.next;
        head.next = newNode;
        return helper(next, head);
    }
}
//head依次取放到新链表的前面即可完成翻转
