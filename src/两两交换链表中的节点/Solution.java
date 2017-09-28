package 两两交换链表中的节点;

import model.ListNode;

import javax.jws.soap.SOAPBinding;

public class Solution {
    /*
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode one = head;
        ListNode two = head.next;
        ListNode lastTail = null;
        ListNode temp;
        while (two != null) {
            temp = two;
            one.next = two.next;
            two.next = one;
            if (lastTail != null) {
                lastTail.next = two;
            }
            if (one.next == null) {
                break;
            } else {
                one = one.next;
                two = one.next;
                lastTail = temp.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }
}
