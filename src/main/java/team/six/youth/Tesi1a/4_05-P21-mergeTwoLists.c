#include <stdio.h>
#include <stdlib.h>

#define OK            0
#define ERROR        -1
#define MALLOC_ERROR -2 

//reference: 链表的插入删除和反转  https://blog.csdn.net/BiuBiu741/article/details/53456550


typedef int ElementType;
typedef struct node
{
    ElementType data;    // 结点的数据
    struct node *next;   // 结点指针
}Node;
typedef Node *PNode;     // 重命名结点指针类型

// 头插法创建链表
//int Create_List_Head(struct node ** head, ElementType data)
int Create_List_Head(PNode *h, ElementType data)
{
    // 创建一个新的结点
    //struct node * node = (struct node *)malloc(sizeof(Node)/sizeof(char));
    PNode p = (PNode)malloc(sizeof(Node)/sizeof(char));
    if (p == NULL)
    {
        return MALLOC_ERROR;
    }
    
    // 将新数据赋给新结点
    p->data = data;
    p->next = *h;
    *h = p;
}

// 尾插法创建链表
int Create_List_Tail(PNode *h, ElementType data)
{
    PNode node = (PNode)malloc(sizeof(Node)/sizeof(char));
    if (node == NULL)
    {
        return MALLOC_ERROR;
    }
    node->data = data;
    node->next = NULL;
    
    // 将node加入到链表最后，此处要考虑是否非空表
    if (*h == NULL)   // 空表
    {
        *h = node;
    } 
    else              // 非空表
    {
        PNode temp = *h;
        
        // 找最后一个结点
        while (temp->next)
        {
            temp = temp->next;
        }
        temp->next = node;
    }
    
    return OK;
}

PNode mergeTwoLists(PNode l1, PNode l2) {

    if (l1==NULL)
    {
        /* code */
    }
    if (l2==NULL)
    {
        /* code */
    }
    if (l2==NULL&&l1==NULL)
    {
        /* code */
    }
    PNode head = NULL;
    PNode tempnode =NULL;
    if (l1->data>=l2->data)
    {
        head=l2;
        l2 = l2->next; 
    }else{
        head=l1;
        l1 = l1->next; 
    }
    tempnode= head;
    while(l1&&l2){
        if (l1->data>l2->data)
        {
           head->next=l2;
           l2=l2->next;
        }else{
           head->next=l1;
           l1=l1->next;
        }
        head=head->next;
    }
    if (l1)
    {
       head->next=l1;
    }
    if (l2)
    {
        head->next=l2;
    }
    PNode temp = tempnode;
    while (temp)
    {
        printf ("%4d", temp->data);
        temp = temp->next;
    }
    
   return tempnode;

}

// 在第 pos 个结点处插入一个数据
int Insert_Node(PNode *h, int pos, ElementType data)
{
    PNode temp = *h;
    int k=1;
    
    // 找第pos-1个结点
    while (temp && k < pos-1)
    {
        temp=temp->next;
        k++;
    }
    
    // 非空表
    if (temp == NULL && *h != NULL)
    {
        printf ("给的位置无效\n");
        return ERROR;
    }
    
    // 新建结点
    PNode node = (PNode)malloc(sizeof(Node)/sizeof(char));
    if (node == NULL)
    {
        return MALLOC_ERROR;
    }
    node->data = data;
    
    // 将结点插入到链表中
    if (*h == NULL || pos == 1)  // 插在表前    
    {
        node->next = *h;
        *h = node;
    } 
    else                         // 插在表中或末尾
    {
        node->next = temp->next;
        temp->next = node;
    }
    
    return OK;
}

// 将第 pos 个结点删除
int Delete_Node(PNode *h, int pos)
{
    if (*h == NULL)
    {
        printf ("空表，无法删除数据\n");
        return ERROR;
    }
    
    PNode p = *h;
    int k = 1;
    while (p && k < pos-1)
    {
        p = p->next;
        k++;
    }
    
    if (p == NULL || k >= pos-1)
    {
        printf ("无效的结点\n");
        return ERROR;
    }
    
    PNode temp = p; 
    if (pos == 1)
    {
        *h = p->next;
    }
    else
    {
        temp = p->next;
        p->next = temp->next;
    }

    free(temp);
    temp = NULL;
    
    return OK;
}

//反转链表
int Inverse_List(PNode *h)
{
    //如果是空链表或者只有一个节点的链表默认已经逆序
    if (*h == NULL ||(*h)->next == NULL)
    {
        return OK;
    }
    PNode pre = *h;              
    PNode cur = pre->next;
    PNode next = NULL;
    
    //将各个结点逆序
    while (cur)
    {
        next = cur->next;
        cur->next = pre;
        pre = cur;
        cur = next;
    }
    
    //处理尾指针和结点
    (*h)->next = NULL;
    *h = pre;
    
    return OK;
}
// 打印链表的数值
void DisPlay(PNode head)
{
    if (head == NULL)
    {
        printf ("该链表是空表!\n");
        return;
    }
    PNode temp = head;
    while (temp)
    {
        printf ("%4d", temp->data);
        temp = temp->next;
    }
    
    printf ("\n");
}

int main()
{
    PNode head = NULL;
    PNode head2 = NULL;

    // 头插法创建链表
    int i = 0;
    for (i = 0; i < 10; i++)
    {
        // 头插法创建链表
/*      if (Create_List_Head(&head, i) != OK)
        {
            return ERROR;
        } */
        
        // 尾插法创建链表
        if (Create_List_Tail(&head, i) != OK)
        {
            return ERROR;
        } 
        
    }
    int z= 10;
    for (z = 10; z < 20; z++)
    {
        // 头插法创建链表
      if (Create_List_Head(&head2, z) != OK)
        {
            return ERROR;
        } 
        
        // // 尾插法创建链表
        // if (Create_List_Tail(&head2, z) != OK)
        // {
        //     return ERROR;
        // } 
        
    }
    DisPlay(head);
    DisPlay(head2);
    mergeTwoLists(head, head2) ;
    //DisPlay(head3);
    // 在第 pos 个结点处插入一个数据
    /*  if(Insert_Node(&head, 1, 11) != OK)
    {
        return ERROR;
    }
    DisPlay(head); */
    
    // 将第 pos 个结点删除
    if(Delete_Node(&head, 19) != OK)
    {
        return ERROR;
    }
    DisPlay(head);
    
    return 0;
}
