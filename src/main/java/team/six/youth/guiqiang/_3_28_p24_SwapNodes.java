package team.six.youth.guiqiang;

import team.six.youth.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class _3_28_p24_SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode rethead = head.next;
        ListNode wh = head;
        while(wh.next != null){
            ListNode next1 = wh.next;
            ListNode next2 = next1.next;
            next1.next = wh;
            if (next2 == null){
                wh.next = null;
                break;
            }
            ListNode next3 = next2.next;
            if(next3 == null){
                wh.next = next2;
                break;
            }
            wh.next = next3;
            wh = next2;
        }
        return  rethead;   
    }
}