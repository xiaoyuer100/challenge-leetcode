/*************************************************************************
    > File Name: 3_28_Solution.c
    > Author: Tesi1a
    > Mail: tangsilian@gmail.com 
    > Created Time: 2018-03-28 22:36
 ************************************************************************/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {

    if(!head||!head->next)
        return head;
    //使用两个指针
    struct ListNode *first=head,*second=head->next;
    int temp;
    //循环至链表末尾
    while(second!=NULL){
        //交换前后链表里的val值
        temp = first->val;
        first->val = second->val;
        second->val = temp;
        if(second->next!=NULL){
            first = second->next;
            second = first->next;
        }else
            break;
    }
    return head;
}
