package 翻转链表;

import model.ListNode;

public class Solution {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while (next  != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        head.next = null;
        return cur;
    }
}
