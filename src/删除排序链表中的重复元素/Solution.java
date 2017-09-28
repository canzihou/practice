package 删除排序链表中的重复元素;

import model.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int curVal = head.val;
        ListNode node = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val != curVal) {
                curVal = next.val;
                node = next;
            } else {
                node.next = next.next;
            }
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(10, new ListNode(11, new ListNode(11)));
        new Solution().deleteDuplicates(node);
    }
}
