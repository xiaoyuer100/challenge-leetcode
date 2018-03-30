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

/**
 * 
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
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