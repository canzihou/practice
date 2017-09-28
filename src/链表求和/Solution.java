package 链表求和;

import model.ListNode;

public class Solution {
    /*
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        int offset = 0;
        int x = l1.val + l2.val;
        if (x >= 10) {
            x = x - 10;
            offset = 1;
        }
        ListNode result = new ListNode(x);
        ListNode node = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + offset;
            if (temp >= 10) {
                temp = temp - 10;
                offset = 1;
            } else {
                offset = 0;
            }
            node.next = new ListNode(temp);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            node.next = l1;
            node.next.val += offset;
            if(node.next.val == 10){
                node.next.val = 0;
                node.next.next = new ListNode(1);
            }
            offset = 0;
        }
        if (l2 != null) {
            node.next = l2;
            node.next.val += offset;
            if(node.next.val == 10){
                node.next.val = 0;
                node.next.next = new ListNode(1);
            }
            offset = 0;
        }
        if(offset == 1){
            node.next = new ListNode(1);
        }
        return result;
    }
}
