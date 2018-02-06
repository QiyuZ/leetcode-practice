public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            if (a != null) a = a.next;
            else a = headB; //注意要等于headB而不是b因为b在变化
            if (b != null) b = b.next;
            else b = headA;
        }
        return a;
    }
}
