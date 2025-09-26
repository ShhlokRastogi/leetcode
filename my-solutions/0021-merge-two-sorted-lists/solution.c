/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode *m = NULL;
    struct ListNode *headfinal = NULL;
    struct ListNode *p = list1;
    struct ListNode *q = list2;
    if (p == NULL && q == NULL) {
        return NULL;
    } else if (p == NULL) {
        return list2;
    } else if (q == NULL) {
        return list1;
    }
    while (p != NULL && q != NULL) {
        if(p->val<q->val){
            if(headfinal==NULL){
                m=p;
                headfinal=p;
            }else{
            m->next=p;
            m=m->next;
            }
            p=p->next;
        }else if(p->val>q->val){
           if(headfinal==NULL){
                m=q;
                headfinal=q;
            }else{
            m->next=q;
            m=m->next;
            }
            q=q->next;
        }else { 
            if (headfinal == NULL) {
                headfinal = p;
                m = p;
            } else {
                m->next = p;
                m = m->next;
            }
            p = p->next;

            m->next = q;
            m = m->next;
            q = q->next;
        }
    }
    while (p != NULL) {
        m->next = p;
        m = m->next;
        p = p->next;
    }
    while (q != NULL) {
        m->next = q;
        m = m->next;
        q = q->next;
    }
    return headfinal;
}
