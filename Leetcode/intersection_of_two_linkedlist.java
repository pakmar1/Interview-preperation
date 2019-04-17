/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        if(pa==null || pb == null){
            return null;
        }
        while(pa!=pb){
            // this situation will generally occur when after 2nd iteration we are unable to find intersaction and both                 pointers reached to the end.
            if(pa.next==null && pb.next==null){
                return null;
            }
            //if pa reached to end 
            if(pa.next==null){
                pa=headB;
                pb=pb.next;
                continue;
            }
            // if pb reached to end
            if(pb.next==null){
                pb=headA;
                pa=pa.next;
                continue;
            }
            // both pointer not reached to end yet
            pa=pa.next;
            pb=pb.next;
        }
        return pa;
        
    }
}
