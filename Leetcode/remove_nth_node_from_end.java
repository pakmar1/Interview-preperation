/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode second = dum;
        ListNode first = dum;
        
        for(int i=0;i<n;i++){
            second = second.next;
        }
        while(second.next!=null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dum.next;
    }
}
