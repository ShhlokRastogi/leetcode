/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid=head;
        ListNode last=head;
        while(last != null && last.next != null){
            mid=mid.next;
            last=last.next.next;
        }
        ListNode prev = mid;
        ListNode curr = mid.next;
        mid.next = null;      
        ListNode n = null;
        while (curr != null) {
           n = curr.next;
           curr.next = prev;
           prev = curr;
           curr = n;
        }
        ListNode left=head;
        ListNode right=prev;
        while(right!=null){
            if(right.val!=left.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
}
