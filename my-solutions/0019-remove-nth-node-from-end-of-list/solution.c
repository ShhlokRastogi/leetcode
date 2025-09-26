struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    int i = 0;
    struct ListNode *p = head;
    while (p->next != NULL) {
        p = p->next;
        i++;
    }
    int length = i + 1; 
    int index = length - n;
    if (index == 0) {
        struct ListNode *temp = head;
        head = head->next;
        free(temp);
        return head;
    }
    struct ListNode *q = head;
    for (int j = 0; j < index - 1; j++) {
        q = q->next;
    }
    struct ListNode *temp = q->next;
    q->next = temp->next;
    free(temp);
    return head;
}
