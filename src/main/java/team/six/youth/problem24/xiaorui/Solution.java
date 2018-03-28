package team.six.youth.problem24.xiaorui;

import team.six.youth.problem24.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp;
        ListNode result;
        ListNode pre=null;
        if(head==null||head.next==null)
        {
            return head;
        }
        result=head.next;
        
        while(head!=null)
        {
            temp=head.next;
            if(temp==null)
            {
                break;
            }
            if(pre!=null)
            {
                pre.next= temp;
            }
            head.next=temp.next;
            temp.next=head;
            pre =head;
            head=head.next;
        }
        
        return result;
    }
}
