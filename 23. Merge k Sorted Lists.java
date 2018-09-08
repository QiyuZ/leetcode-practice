/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return partion(lists, 0, lists.length - 1);
    }
    public ListNode partion(ListNode[] lists, int start, int end) { //分治法，下面排序然后慢慢往上合并
        if (start >= end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode l1 = partion(lists, start, mid);
        ListNode l2 = partion(lists, mid + 1, end);
        return merge(l1, l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2); //小的那个node保留，接着往后面走
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
           public int compare(ListNode l1, ListNode l2) {
               return l1.val - l2.val;
           } 
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode list : lists) {
            if (list != null) queue.offer(list); //先全部放入
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll(); //更新tail
            tail = tail.next; //因为只要当前node,所以tail后移，把next放入queue重新排序
            if (tail.next != null) queue.offer(tail.next);
        }
        return dummy.next; //这就是dummy的作用，它的指针依然在头部
    }
}
