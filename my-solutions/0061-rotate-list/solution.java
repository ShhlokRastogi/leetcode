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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode p=head;
        ListNode last=head;
        int length=1;
        while(last.next!=null){
            last=last.next;
            length++;
        }
        k=k%length;
        if(k == 0)
            return head;
        for(int i=1;i<length-k;i++){
            p=p.next;
        }
        last.next=head;
        head=p.next;
        p.next=null;
        return head;
    }
}
