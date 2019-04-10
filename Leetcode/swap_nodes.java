/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode first = head; 
        ListNode second = head.next;
        ListNode third = head.next.next;
        
        second.next = first;
        first.next = swapPairs(third);
        
        return second;   
    }
}
