class Solution {
    ListNode rev(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;  
        }
        ListNode temp = curr.next;
        curr.next = prev;
        return rev(temp, curr); 
    }
    public ListNode reverseList(ListNode head) {
        return rev(head, null);
    }
}

