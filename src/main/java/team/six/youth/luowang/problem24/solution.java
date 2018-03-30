package team.six.youth.luowang.problem24;

import team.six.youth.util.ListNode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pHead1 = new ListNode(0);
        ListNode pHead2;
        pHead1.next = head;
        pHead2 = pHead1;

        while(pHead2.next != null && pHead2.next.next != null){
            ListNode tmp1 = pHead2.next;
            ListNode tmp2 = tmp1.next.next;
            pHead2.next = pHead2.next.next;
            pHead2.next.next = tmp1;
            pHead2.next.next.next = tmp2;

            pHead2 = pHead2.next.next;
        }

        return pHead1.next;
    }
}
