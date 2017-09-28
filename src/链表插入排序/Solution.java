package 链表插入排序;

import model.ListNode;

public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            if (head.val <= newHead.val) {
                ListNode temp = new ListNode(head.val);
                temp.next = newHead;
                newHead = temp;
            } else {
                ListNode temp = newHead;
                while (temp.next != null && temp.next.val <= head.val) {
                    temp = temp.next;
                }
                ListNode temp1 = new ListNode(head.val);
                temp1.next = temp.next;
                temp.next = temp1;
            }
            head = head.next;
        }
        return newHead;
    }
}
