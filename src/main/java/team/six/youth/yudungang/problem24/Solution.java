package team.six.youth.yudungang.problem24;

import team.six.youth.util.ListNode;

/**
 * Created by yudungang on 2018/3/28 0028.
 */

public class Solution {

    /**
     * 递归版
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode pre = head.next;
        head.next= swapPairs(pre.next);
        pre.next = head;
        return pre;
    }

    /**
     * 非递归版
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode pre ;
        boolean keep = true;
        while(keep){
            ListNode nextPre = head.next.next;
            pre = head;
            head.next.next = pre;
            head = nextPre;
            if(nextPre != null && nextPre.next != null){
                pre.next = nextPre.next;
            }else{
                pre.next= nextPre;
                keep = false;
            }
        }
        return newHead;
    }
}
