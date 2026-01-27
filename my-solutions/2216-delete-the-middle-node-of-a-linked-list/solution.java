class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                mid = slow.next;  
                break;
            }
            slow = slow.next;
        }
        slow.next = mid.next;
        return head;
    }
}
