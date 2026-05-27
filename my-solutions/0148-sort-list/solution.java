/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; 
        ListNode head3=mergesort(head); 
        return head3;
    }
    ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode mergesort(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middle(head);
        ListNode righthalf = mid.next;
        mid.next = null;

        ListNode left = mergesort(head);
        ListNode right = mergesort(righthalf);

        return mergeLL(left, right);
    }

    ListNode mergeLL(ListNode head1, ListNode head2){

        ListNode tempList = new ListNode(-1);
        ListNode head3 = tempList;

        while(head1 != null && head2 != null){

            if(head1.val <= head2.val){
                head3.next = head1;
                head1 = head1.next;

            } else {
                head3.next = head2;
                head2 = head2.next;
            }
            head3 = head3.next;
        }

        if(head1 != null){
            head3.next = head1;
        }
        if(head2 != null){
            head3.next = head2;
        }
        return tempList.next;
    }
}
