class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int carry = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum = carry;
            if (l1 != null && l2 == null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null && l1 == null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (l1 != null && l2 != null) {
                sum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum / 10;
            l3.val = sum % 10;
            if (l1 != null || l2 != null) {
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
        }
        if (carry > 0) {
            l3.next = new ListNode(carry);
        }
        return head;
    }
}

