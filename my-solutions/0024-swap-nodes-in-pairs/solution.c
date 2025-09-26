/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode *check=head;
    if(check==NULL || check->next==NULL){
        return head;
    }
    struct ListNode *p=head;
    struct ListNode *q=head->next;
    struct ListNode *headfinal=NULL;
    int i=0;
    struct ListNode *prev=NULL;
    while(p!=NULL && p->next!=NULL){
        p->next=q->next;
        q->next=p;
        if (prev != NULL) {
            prev->next = q;
        }
        if(i==0){
        headfinal=q;
        }
        prev=p;
        p=p->next;
        if(p==NULL)q=NULL;
        else q=p->next;
        i++;
    }
    return headfinal;
}
