package 链表划分;

import model.ListNode;

public class Solution {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode one = head;
        if (one.val >= x) {
            while (one.next != null && one.next.val >= x) {
                one = one.next;
            }
            ListNode temp = one.next;
            if (temp == null) {
                return head;
            }
            one.next = temp.next;
            temp.next = head;
            head = temp;
        }
        one = head;
        while (one.next != null && one.next.val < x) {
            one = one.next;
        }
        ListNode two = one;
        while (two.next != null) {
            if (two.next.val < x) {
                ListNode temp = two.next;
                two.next = temp.next;
                temp.next = one.next;
                one.next = temp;
                one = one.next;
            } else {
                two = two.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        new Solution().partition(new ListNode(1, new ListNode(2, new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(0, new ListNode(2))))))))), 2);
    }
}
